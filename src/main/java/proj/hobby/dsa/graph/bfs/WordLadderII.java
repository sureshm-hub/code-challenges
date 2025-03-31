package proj.hobby.dsa.graph.bfs;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 *
 * 1) bfs to find the shortest Path to endWord
 * 	1.1) build an adjacency list of graph of all words
 * 	1.2) find all neighbors of a  word
 *
 * 2) dfs to find all paths from beginWord to end Word
 *
 *
 */
public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) {
            return new ArrayList<>(); // early exit
        }

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfs(beginWord, endWord, wordSet, graph, distance);

        System.out.println(">>>"+graph);
        List<String> path = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        dfs(beginWord, endWord, graph, distance, result, path);

        return result;
    }

    private void dfs(String word, String endWord, Map<String, List<String>> graph, Map<String, Integer> distance, List<List<String>> result, List<String> path) {

        path.add(word);

        if(word.equals(endWord)) {
            result.add(new ArrayList<>(path));
        } else {

            List<String> next = graph.get(word);
            for(String neighbor : next) {
                if(distance.get(neighbor) == distance.get(word)+1) { // prevent back loops and keeps the dfs moving forward

                    dfs(neighbor, endWord, graph, distance, result, path);
                    path.remove(path.size()-1); // back track
                }
            }
        }
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> graph, Map<String, Integer> distance) {

        Queue<String> wordQueue = new LinkedList<>();
        wordQueue.offer(beginWord);

        distance.put(beginWord, 0);
        for(String word : wordSet) {
            graph.put(word, new ArrayList<>());
        }
        graph.put(beginWord, new ArrayList<>());

        while(!wordQueue.isEmpty()) {

            int size = wordQueue.size();
            boolean found = false;

            for(int i = 0; i < size; i++) {
                String curr = wordQueue.poll();
                int currDistance = distance.get(curr);
                List<String> neighbors = findNeighbors(curr, wordSet);
                for(String next : neighbors) {
                    graph.get(curr).add(next); // build adjacency list

                    if(!distance.containsKey(next)) {
                        distance.put(next, currDistance+1);

                        if(next.equals(endWord)) found = true; // found the end word

                        wordQueue.offer(next);
                    }
                }

            }

            if(found) break;// Stop as we found end word
        }

    }


    private List<String> findNeighbors(String word, Set<String> wordSet) {

        char[] chars = word.toCharArray();
        List<String> neighbors = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) {
            char c = chars[i];

            for(char  j = 'a'; j <= 'z' ; j++) {
                if( c != j) {
                    chars[i] = j;
                    String key = new String(chars);
                    if(wordSet.contains(key)) {
                        neighbors.add(key);
                    }
                }
            }
            chars[i] = c;// reset char
        }
        return neighbors;
    }

    public static void main(String[] args) {
        WordLadderII wl2 = new WordLadderII();
        System.out.println(wl2.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));

        System.out.println(wl2.findLadders("aaaaa", "ggggg", Arrays.asList("aaaaa","caaaa","cbaaa","daaaa","dbaaa","eaaaa","ebaaa","faaaa","fbaaa","gaaaa","gbaaa","haaaa","hbaaa","iaaaa","ibaaa","jaaaa","jbaaa","kaaaa","kbaaa","laaaa","lbaaa","maaaa","mbaaa","naaaa","nbaaa","oaaaa","obaaa","paaaa","pbaaa","bbaaa","bbcaa","bbcba","bbdaa","bbdba","bbeaa","bbeba","bbfaa","bbfba","bbgaa","bbgba","bbhaa","bbhba","bbiaa","bbiba","bbjaa","bbjba","bbkaa","bbkba","bblaa","bblba","bbmaa","bbmba","bbnaa","bbnba","bboaa","bboba","bbpaa","bbpba","bbbba","abbba","acbba","dbbba","dcbba","ebbba","ecbba","fbbba","fcbba","gbbba","gcbba","hbbba","hcbba","ibbba","icbba","jbbba","jcbba","kbbba","kcbba","lbbba","lcbba","mbbba","mcbba","nbbba","ncbba","obbba","ocbba","pbbba","pcbba","ccbba","ccaba","ccaca","ccdba","ccdca","cceba","cceca","ccfba","ccfca","ccgba","ccgca","cchba","cchca","cciba","ccica","ccjba","ccjca","cckba","cckca","cclba","cclca","ccmba","ccmca","ccnba","ccnca","ccoba","ccoca","ccpba","ccpca","cccca","accca","adcca","bccca","bdcca","eccca","edcca","fccca","fdcca","gccca","gdcca","hccca","hdcca","iccca","idcca","jccca","jdcca","kccca","kdcca","lccca","ldcca","mccca","mdcca","nccca","ndcca","occca","odcca","pccca","pdcca","ddcca","ddaca","ddada","ddbca","ddbda","ddeca","ddeda","ddfca","ddfda","ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca","ddjda","ddkca","ddkda","ddlca","ddlda","ddmca","ddmda","ddnca","ddnda","ddoca","ddoda","ddpca","ddpda","dddda","addda","aedda","bddda","bedda","cddda","cedda","fddda","fedda","gddda","gedda","hddda","hedda","iddda","iedda","jddda","jedda","kddda","kedda","lddda","ledda","mddda","medda","nddda","nedda","oddda","oedda","pddda","pedda","eedda","eeada","eeaea","eebda","eebea","eecda","eecea","eefda","eefea","eegda","eegea","eehda","eehea","eeida","eeiea","eejda","eejea","eekda","eekea","eelda","eelea","eemda","eemea","eenda","eenea","eeoda","eeoea","eepda","eepea","eeeea","ggggg","agggg","ahggg","bgggg","bhggg","cgggg","chggg","dgggg","dhggg","egggg","ehggg","fgggg","fhggg","igggg","ihggg","jgggg","jhggg","kgggg","khggg","lgggg","lhggg","mgggg","mhggg","ngggg","nhggg","ogggg","ohggg","pgggg","phggg","hhggg","hhagg","hhahg","hhbgg","hhbhg","hhcgg","hhchg","hhdgg","hhdhg","hhegg","hhehg","hhfgg","hhfhg","hhigg","hhihg","hhjgg","hhjhg","hhkgg","hhkhg","hhlgg","hhlhg","hhmgg","hhmhg","hhngg","hhnhg","hhogg","hhohg","hhpgg","hhphg","hhhhg","ahhhg","aihhg","bhhhg","bihhg","chhhg","cihhg","dhhhg","dihhg","ehhhg","eihhg","fhhhg","fihhg","ghhhg","gihhg","jhhhg","jihhg","khhhg","kihhg","lhhhg","lihhg","mhhhg","mihhg","nhhhg","nihhg","ohhhg","oihhg","phhhg","pihhg","iihhg","iiahg","iiaig","iibhg","iibig","iichg","iicig","iidhg","iidig","iiehg","iieig","iifhg","iifig","iighg","iigig","iijhg","iijig","iikhg","iikig","iilhg","iilig","iimhg","iimig","iinhg","iinig","iiohg","iioig","iiphg","iipig","iiiig","aiiig","ajiig","biiig","bjiig","ciiig","cjiig","diiig","djiig","eiiig","ejiig","fiiig","fjiig","giiig","gjiig","hiiig","hjiig","kiiig","kjiig","liiig","ljiig","miiig","mjiig","niiig","njiig","oiiig","ojiig","piiig","pjiig","jjiig","jjaig","jjajg","jjbig","jjbjg","jjcig","jjcjg","jjdig","jjdjg","jjeig","jjejg","jjfig","jjfjg","jjgig","jjgjg","jjhig","jjhjg","jjkig","jjkjg","jjlig","jjljg","jjmig","jjmjg","jjnig","jjnjg","jjoig","jjojg","jjpig","jjpjg","jjjjg","ajjjg","akjjg","bjjjg","bkjjg","cjjjg","ckjjg","djjjg","dkjjg","ejjjg","ekjjg","fjjjg","fkjjg","gjjjg","gkjjg","hjjjg","hkjjg","ijjjg","ikjjg","ljjjg","lkjjg","mjjjg","mkjjg","njjjg","nkjjg","ojjjg","okjjg","pjjjg","pkjjg","kkjjg","kkajg","kkakg","kkbjg","kkbkg","kkcjg","kkckg","kkdjg","kkdkg","kkejg","kkekg","kkfjg","kkfkg","kkgjg","kkgkg","kkhjg","kkhkg","kkijg","kkikg","kkljg","kklkg","kkmjg","kkmkg","kknjg","kknkg","kkojg","kkokg","kkpjg","kkpkg","kkkkg","ggggx","gggxx","ggxxx","gxxxx","xxxxx","xxxxy","xxxyy","xxyyy","xyyyy","yyyyy","yyyyw","yyyww","yywww","ywwww","wwwww","wwvww","wvvww","vvvww","vvvwz","avvwz","aavwz","aaawz","aaaaz")));
    }
}
