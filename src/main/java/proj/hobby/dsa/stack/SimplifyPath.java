package proj.hobby.dsa.stack;
import java.util.*;

/**
 *
 * https://leetcode.com/problems/simplify-path
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String SEP = "/";
        if(path.length() == 1 && path.equals(SEP)){
            return SEP;
        }
        String[] dirs = path.split(SEP);
        //System.out.println(">> "+Arrays.toString(dirs));
        StringBuilder simpl = new StringBuilder();
        LinkedList<String> stack = new LinkedList<>();
        int L = path.length();
        for(String dir: dirs) {
            if(dir.equals(SEP) || dir.equals("") || dir.equals(".")) {
                continue;
            } else if(dir.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }
        LinkedList<String> reverse = new LinkedList<>();
        while(!stack.isEmpty()) {
            reverse.push(stack.pop());
        }

        if(reverse.isEmpty()) return SEP;

        simpl.append(SEP);
        while(!reverse.isEmpty()) {
            simpl.append(reverse.pop());
            simpl.append(SEP);
        }
        return simpl.toString().substring(0,simpl.length()-1);
    }
}
