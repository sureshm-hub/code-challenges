package proj.hobby.dsa.binaryTree.bfs;

import java.util.*;

/**

 https://leetcode.com/problems/word-ladder/

 BFS Search from beginWord
 - circular references - keep track of visited words
 - efficient lookup of 1 step words
 - Queue for BFS traversal

 Time Complexity: O(N*M) - N size of Word List and M is the word length
 Space Complexity: O(N) - N size of word list

 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> bfs = new LinkedList<>();
        bfs.offer(beginWord);
        int level = 1;
        while(!bfs.isEmpty()) {
            int size = bfs.size();
            for(int i =0 ; i < size; i++) {
                String current = bfs.poll();

                if(current.equals(endWord)) {
                    return level;
                }
                List<String> neighbors = getNeighbors(current, wordSet);
                for(String neighbor: neighbors) {
                    wordSet.remove(neighbor); // avoid revisiting
                    bfs.offer(neighbor);
                }
            }
            level++;
        }
        return 0;
    }

    private List<String> getNeighbors(String next, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = next.toCharArray();
        for(int j=0; j< chars.length; j++) {
            char x = chars[j];
            for(char c = 'a'; c <= 'z'; c++) {
                if(c != x) {
                    chars[j] = c;
                    String step = new String(chars);
                    if( wordSet.contains(step)) {
                        neighbors.add(step); // we have not traversed this path
                    }
                }
            }
            chars[j] = x; // reset word for next  possible iteration
        }
        return neighbors;
    }

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        System.out.println("Ladder length: "+ladder.ladderLength("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
    }

}
