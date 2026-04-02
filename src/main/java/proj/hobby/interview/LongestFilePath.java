package proj.hobby.interview;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 clarifyingQuestions:
    is the absolute path constructed in window or unix format

 Examples:
    root -> 0
    root\n\tsub1\n\t\tfile1.txt\n\tsub2 -> 19
    // root/sub1/file1.txt

 Edge Cases:
    input is null or empty string -> 0
    root\n\tsub1 -> 0
    what if input has spaces

 Constraints:
    How big can be the input length?

 API:
    public int longestAbsoluteFilePath(String dirs) {

    }

 High Lvl:
    the input is a string where:
    \n means a file or dir
    \t means item is nested one level deeper
    goal is to walk through each item and keep a track of its depth and the current length
    we use a stack to remember the length of the path

 Complexity:
    time: O(N) - N is number of file items in input
    space: O(N) - N
*/
public class LongestFilePath {

    record FileInfo(int depth, int length) {};

    private static final String NEW_LINE = "\n";
    private static final String FILE_SEPARATOR = ".";
    private static final char TAB_SEPARATOR = '\t';
    private static final int DIR_SEPARATOR_LENGTH = 1; // "/"

    public int lengthLongestPath(String input) {
        if(input == null || "".equals(input)) return 0;

        int max = 0;
        Deque<FileInfo> stack = new ArrayDeque<>();
        stack.push(new FileInfo(-1, 0));

        String[] items = input.split(NEW_LINE);
        for(String item : items) {

            int depth = getDepth(item);
            while(depth <= stack.peek().depth()) stack.pop();

            item = item.replaceAll("\t", "");
            int absoluteLength = fileAbsoluteLength(stack.peek(), item);
            if(isFile(item)) {
                max = Math.max(max, absoluteLength); // calculate max absolute path length
            } else {
                stack.push(new FileInfo(depth, absoluteLength + DIR_SEPARATOR_LENGTH));
            }
        }
        return max;
    }

    // count # of \t's in item
    private int getDepth(String item) {
        return (int) item.chars().filter(c -> c == TAB_SEPARATOR).count();
    }

    private boolean isFile(String item) {
        return item.indexOf(FILE_SEPARATOR) != -1;
    }

    private int fileAbsoluteLength(FileInfo parent, String item) {
        return parent.length() + item.length();
    }
}
