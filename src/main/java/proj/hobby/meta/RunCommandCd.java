package proj.hobby.meta;

import java.util.Stack;

/**
 * Implement cd (change directory) Command from a Given cwd (current working Directory)
 *
 */
public class RunCommandCd {

    final String ROOT = "/";
    final String PATH_SEPARATOR = "/";
    final String PARENT  = "..";
    final String CURRENT = ".";


    public String cd(String cwd, String cd) {
        Stack<String> dir = new Stack<>();
        String[] parts = cwd.split(PATH_SEPARATOR);
        for(String part : parts) {
            if("".equals(part)) {
                dir.push(ROOT);
            } else {
                dir.push(part);
            }
        }
        String[] ops = cd.split(PATH_SEPARATOR);
        if("".equals(ops[0])) {
            ops[0] = ROOT;
        }
        for(String op : ops) {
            if(ROOT.equals(op)) {
                dir.clear();
                dir.push(ROOT);
            } else if(PARENT.equals(op)) {
                if(!dir.peek().equals(ROOT)) {
                    dir.pop();
                }
            } else if(CURRENT.equals(op)) {
                ;
            } else {
                dir.push(op);
            }
        }
        // reverse stack
        Stack<String> changedDir = new Stack<>();
        while(!dir.isEmpty()) {
            changedDir.push(dir.pop());
        }

        StringBuilder cdResult = new StringBuilder();
        while(!changedDir.isEmpty()) {
            String path = changedDir.pop();
            String separator = (ROOT.equals(path) || changedDir.isEmpty()) ? "" : PATH_SEPARATOR;
            cdResult.append(path).append(separator);
        }
        return cdResult.toString();
    }
}
