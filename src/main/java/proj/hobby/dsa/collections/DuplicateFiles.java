package proj.hobby.dsa.collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * https://leetcode.com/problems/find-duplicate-file-in-system/description/
 */
public class DuplicateFiles {

    public List<List<String>> findDuplicate(String[] paths) {
        final Map<String, List<String>> contentMap = new HashMap<>();
        Arrays.stream(paths).forEach(x -> {
            String[] txt = x.split(" ");
            String fp = txt[0];
            for(int i = 1; i < txt.length; i++) {
                String fc = txt[i]; // file & content
                int idx = fc.indexOf("(");
                String file = fc.substring(0, idx);
                String cntnt = fc.substring(idx+1, fc.length());
                contentMap.computeIfAbsent(cntnt, k -> new ArrayList<>()).add(fp+"/"+file);
            }
        });

        return contentMap.values().stream().filter(x -> x.size() > 1).collect(Collectors.toList());
    }
}
