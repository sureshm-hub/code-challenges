package proj.hobby.dsa.graph.bfs;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 *
 * Solved this problem using two approaches: Successor Graph and Predecessor Graph.
 *
 * The Successor Graph approach works well in general but becomes inefficient for dense graphs, as it generates
 * a large number of forward paths to explore during DFS.
 *
 * To improve performance, I introduced a Predecessor Graph, where each word points to its parent(s) based on
 * the shortest path found during BFS.
 *
 * This reverse mapping significantly reduces the number of DFS paths to explore, improving time and space
 * efficiency in dense transformation graphs.
 *
 * Successor Graph:
 *      1) bfs to find the shortest Path to endWord
 *          1.1) build an adjacency list of graph of all words
 *          1.2) find all neighbors of a  word
 *          1.3) prune visited words from the adjacency list
 *      2) dfs to find all paths from beginWord to end Word
 *
 * Predecessor Graph:
 * Successor Map doesn't prune well for trees with large branches.
 * Hence, we start with the end word and work our way back prunning any visited wrods, limiting the branches to be visited
 * We can reconstruct the path using Deque visiting from endWord to beginWord
 *
 *      1) bfs of predecessor Map
 *      2) dfs using Deque
 *
 * Complexity:
 *  Time:
 *      BFS: O(N*26*L)  - L is word length, N is wordList size
 *      DFS: O(K) - K is graph size
 *
 *  Space:
 *      O(N) for graph and distance maps, O(P*D) for storing P paths of D size each
 */
public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) {
            return result; // early exit
        }

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfsPrdecessorGaph(beginWord, endWord, wordSet, graph, distance);

        System.out.println("graph: "+graph);
        System.out.println("distance: "+distance);

        // if we didn't find end word in the graph there is no need to search for paths
        if( distance.containsKey(endWord)) {
            // List<String> path = new ArrayList<>();
            // dfs(beginWord,  endWord, graph, distance, result, path);
           Deque<String> path = new ArrayDeque<>();
           path.add(endWord);
           dfsPrdecessorGraph(beginWord, endWord, graph, distance, result, path);
        }
        return result;
    }

    private void dfs(String word, String endWord, Map<String, List<String>> graph, Map<String, Integer> distance, List<List<String>> result, List<String> path) {
        path.add(word);
        if(word.equals(endWord)) {
            result.add(new ArrayList<>(path));
        } else {
            List<String> next = graph.getOrDefault(word, new ArrayList<>());
            for(String neighbor : next) {
                if(distance.get(neighbor) == distance.get(word)+1) { // prevent back loops and keeps the dfs moving forward
                    dfs(neighbor, endWord, graph, distance, result, path);
                    path.remove(path.size()-1); // back track
                }
            }
        }
    }

    private void dfsPrdecessorGraph(String begin, String end, Map<String, List<String>> graph, Map<String, Integer> distance,
                                    List<List<String>> result, Deque<String> path) {
        if(end.equals(begin)) {
            result.add(new ArrayList<>(path));
        } else {
            List<String> prev = graph.getOrDefault(end, new ArrayList<>());
            for(String parent : prev) {
                if(distance.get(end) == distance.get(parent)+1) { // prevent back loops and keeps the dfs moving forward
                    path.addFirst(parent);
                    dfsPrdecessorGraph(begin, parent, graph, distance, result, path);
                    path.removeFirst(); // back track
                }
            }
        }
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> graph, Map<String, Integer> distance) {

        Queue<String> wordQueue = new LinkedList<>();
        wordQueue.offer(beginWord);
        distance.put(beginWord, 0);
        wordSet.remove(beginWord);//remove begin word to remove loop

        boolean found = false;
        while(!wordQueue.isEmpty() && !found) {

            int size = wordQueue.size();
            Set<String> allNeighbors = new HashSet<>();
            for(int i = 0; i < size; i++) {
                String curr = wordQueue.poll();
                List<String> neighbors = findNeighbors(curr, wordSet);
                allNeighbors.addAll(neighbors);
                for(String next : neighbors) {
                    if(!distance.containsKey(next)) {
                        distance.put(next, distance.get(curr)+1);
                        wordQueue.offer(next);
                        graph.computeIfAbsent(curr, k -> new ArrayList<>()).add(next);// build adjacency list
                        if(next.equals(endWord)) found = true; // found the end word
                    } else if(distance.get(next) == distance.get(curr) + 1) { // add an edge even if visited, if the neighbor is at the next level
                        graph.computeIfAbsent(curr, k -> new ArrayList<>()).add(next);
                    }
                }
            }
            wordSet.removeAll(allNeighbors); // level pruning
        }
    }

    private void bfsPrdecessorGaph(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> graph, Map<String, Integer> distance) {

        Queue<String> wordQueue = new LinkedList<>();
        wordQueue.offer(beginWord);
        distance.put(beginWord, 0);
        wordSet.remove(beginWord);//remove begin word to remove loop

        boolean found = false;
        while(!wordQueue.isEmpty() && !found) {

            int size = wordQueue.size();
            Set<String> allNeighbors = new HashSet<>();
            for(int i = 0; i < size; i++) {
                String curr = wordQueue.poll();
                List<String> neighbors = findNeighbors(curr, wordSet);
                allNeighbors.addAll(neighbors);
                for(String next : neighbors) {
                    if(!distance.containsKey(next)) {
                        distance.put(next, distance.get(curr)+1);
                        wordQueue.offer(next);
                        graph.computeIfAbsent(next, k -> new ArrayList<>()).add(curr);// build adjacency list
                        if(next.equals(endWord)) found = true; // found the end word
                    } else if(distance.get(next) == distance.get(curr) + 1) { // add an edge even if visited, if the neighbor is at the next level
                        graph.computeIfAbsent(next, k -> new ArrayList<>()).add(curr);
                    }
                }
            }
            wordSet.removeAll(allNeighbors); // level pruning
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
        System.out.println("====");
        System.out.println(wl2.findLadders("aaaaa", "ggggg", Arrays.asList("aaaaa","caaaa","cbaaa","bbaaa","bbcaa","bbcba","bbdba","bbeba","bbfba","bbgba",
                "bbhba","bbiba","bbjba","bbkba","bblba","bbmba","bbnba","bboba","bbpba","bbbba",
                "abbba","acbba","ccbba","ccaba","ccaca","ccdba","ccdca","cceba","cceca","ccfba",
                "ccfca","ccgba","ccgca","cchba","cchca","cciba","ccica","ccjba","ccjca","cckba",
                "cckca","cclba","cclca","ccmba","ccmca","ccnba","ccnca","ccoba","ccoca","ccpba",
                "ccpca","cccca","accca","adcca","ddcca","ddaca","ddada","ddbca","ddbda","ddeca",
                "ddeda","ddfca","ddfda","ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca",
                "ddjda","ddkca","ddkda","ddlca","ddlda","ddmca","ddmda","ddnca","ddnda","ddoca",
                "ddoda","ddpca","ddpda","dddda","addda","aedda","eedda","eeeea","ggggg")));
        System.out.println("====");
        System.out.println(wl2.findLadders("aaaaa", "ggggg", Arrays.asList("aaaaa","caaaa","cbaaa","daaaa","dbaaa","eaaaa","ebaaa","faaaa","fbaaa","gaaaa","gbaaa","haaaa","hbaaa","iaaaa","ibaaa","jaaaa","jbaaa","kaaaa","kbaaa","laaaa","lbaaa","maaaa","mbaaa","naaaa","nbaaa","oaaaa","obaaa","paaaa","pbaaa","bbaaa","bbcaa","bbcba","bbdaa","bbdba","bbeaa","bbeba","bbfaa","bbfba","bbgaa","bbgba","bbhaa","bbhba","bbiaa","bbiba","bbjaa","bbjba","bbkaa","bbkba","bblaa","bblba","bbmaa","bbmba","bbnaa","bbnba","bboaa","bboba","bbpaa","bbpba","bbbba","abbba","acbba","dbbba","dcbba","ebbba","ecbba","fbbba","fcbba","gbbba","gcbba","hbbba","hcbba","ibbba","icbba","jbbba","jcbba","kbbba","kcbba","lbbba","lcbba","mbbba","mcbba","nbbba","ncbba","obbba","ocbba","pbbba","pcbba","ccbba","ccaba","ccaca","ccdba","ccdca","cceba","cceca","ccfba","ccfca","ccgba","ccgca","cchba","cchca","cciba","ccica","ccjba","ccjca","cckba","cckca","cclba","cclca","ccmba","ccmca","ccnba","ccnca","ccoba","ccoca","ccpba","ccpca","cccca","accca","adcca","bccca","bdcca","eccca","edcca","fccca","fdcca","gccca","gdcca","hccca","hdcca","iccca","idcca","jccca","jdcca","kccca","kdcca","lccca","ldcca","mccca","mdcca","nccca","ndcca","occca","odcca","pccca","pdcca","ddcca","ddaca","ddada","ddbca","ddbda","ddeca","ddeda","ddfca","ddfda","ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca","ddjda","ddkca","ddkda","ddlca","ddlda","ddmca","ddmda","ddnca","ddnda","ddoca","ddoda","ddpca","ddpda","dddda","addda","aedda","bddda","bedda","cddda","cedda","fddda","fedda","gddda","gedda","hddda","hedda","iddda","iedda","jddda","jedda","kddda","kedda","lddda","ledda","mddda","medda","nddda","nedda","oddda","oedda","pddda","pedda","eedda","eeada","eeaea","eebda","eebea","eecda","eecea","eefda","eefea","eegda","eegea","eehda","eehea","eeida","eeiea","eejda","eejea","eekda","eekea","eelda","eelea","eemda","eemea","eenda","eenea","eeoda","eeoea","eepda","eepea","eeeea","ggggg","agggg","ahggg","bgggg","bhggg","cgggg","chggg","dgggg","dhggg","egggg","ehggg","fgggg","fhggg","igggg","ihggg","jgggg","jhggg","kgggg","khggg","lgggg","lhggg","mgggg","mhggg","ngggg","nhggg","ogggg","ohggg","pgggg","phggg","hhggg","hhagg","hhahg","hhbgg","hhbhg","hhcgg","hhchg","hhdgg","hhdhg","hhegg","hhehg","hhfgg","hhfhg","hhigg","hhihg","hhjgg","hhjhg","hhkgg","hhkhg","hhlgg","hhlhg","hhmgg","hhmhg","hhngg","hhnhg","hhogg","hhohg","hhpgg","hhphg","hhhhg","ahhhg","aihhg","bhhhg","bihhg","chhhg","cihhg","dhhhg","dihhg","ehhhg","eihhg","fhhhg","fihhg","ghhhg","gihhg","jhhhg","jihhg","khhhg","kihhg","lhhhg","lihhg","mhhhg","mihhg","nhhhg","nihhg","ohhhg","oihhg","phhhg","pihhg","iihhg","iiahg","iiaig","iibhg","iibig","iichg","iicig","iidhg","iidig","iiehg","iieig","iifhg","iifig","iighg","iigig","iijhg","iijig","iikhg","iikig","iilhg","iilig","iimhg","iimig","iinhg","iinig","iiohg","iioig","iiphg","iipig","iiiig","aiiig","ajiig","biiig","bjiig","ciiig","cjiig","diiig","djiig","eiiig","ejiig","fiiig","fjiig","giiig","gjiig","hiiig","hjiig","kiiig","kjiig","liiig","ljiig","miiig","mjiig","niiig","njiig","oiiig","ojiig","piiig","pjiig","jjiig","jjaig","jjajg","jjbig","jjbjg","jjcig","jjcjg","jjdig","jjdjg","jjeig","jjejg","jjfig","jjfjg","jjgig","jjgjg","jjhig","jjhjg","jjkig","jjkjg","jjlig","jjljg","jjmig","jjmjg","jjnig","jjnjg","jjoig","jjojg","jjpig","jjpjg","jjjjg","ajjjg","akjjg","bjjjg","bkjjg","cjjjg","ckjjg","djjjg","dkjjg","ejjjg","ekjjg","fjjjg","fkjjg","gjjjg","gkjjg","hjjjg","hkjjg","ijjjg","ikjjg","ljjjg","lkjjg","mjjjg","mkjjg","njjjg","nkjjg","ojjjg","okjjg","pjjjg","pkjjg","kkjjg","kkajg","kkakg","kkbjg","kkbkg","kkcjg","kkckg","kkdjg","kkdkg","kkejg","kkekg","kkfjg","kkfkg","kkgjg","kkgkg","kkhjg","kkhkg","kkijg","kkikg","kkljg","kklkg","kkmjg","kkmkg","kknjg","kknkg","kkojg","kkokg","kkpjg","kkpkg","kkkkg","ggggx","gggxx","ggxxx","gxxxx","xxxxx","xxxxy","xxxyy","xxyyy","xyyyy","yyyyy","yyyyw","yyyww","yywww","ywwww","wwwww","wwvww","wvvww","vvvww","vvvwz","avvwz","aavwz","aaawz","aaaaz")));
        System.out.println("====");
    }
}
