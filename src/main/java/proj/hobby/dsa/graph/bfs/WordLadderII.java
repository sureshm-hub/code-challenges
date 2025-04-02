package proj.hobby.dsa.graph.bfs;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 *
 * Successor Map:
 * 1) bfs to find the shortest Path to endWord
 * 	1.1) build an adjacency list of graph of all words
 * 	1.2) find all neighbors of a  word
 * 	1.3) prune visited words from the adjacency list
 *
 * 2) dfs to find all paths from beginWord to end Word
 *
 * Predecessor Map:
 * Successor Map doesn't prune well for trees with large branches.
 * Hence, we start with the end word and work our way back prunning any visited wrods, limiting the branches to be visited
 * We can reconstruct the path using Deque visiting from endWord to beginWord
 *
 * 1) bfs of predecessor Map
 * 2) dfs using Deque
 *
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

        bfsPrdecessorMap(beginWord, endWord, wordSet, graph, distance);

        System.out.println("graph: "+graph);
        System.out.println("distance: "+distance);

        // if we didn't find end word in the graph there is no need to search for paths
        if( distance.containsKey(endWord)) {
            // List<String> path = new ArrayList<>();
            // dfs(beginWord,  endWord, graph, distance, result, path);
           Deque<String> path = new ArrayDeque<>();
           path.add(endWord);
           dfsPrdecessorMap(beginWord, endWord, graph, distance, result, path);
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

    private void dfsPrdecessorMap(String begin, String end, Map<String, List<String>> graph, Map<String, Integer> distance,
                                  List<List<String>> result, Deque<String> path) {
        if(end.equals(begin)) {
            result.add(new ArrayList<>(path));
        } else {
            List<String> prev = graph.getOrDefault(end, new ArrayList<>());
            for(String parent : prev) {
                if(distance.get(end) == distance.get(parent)+1) { // prevent back loops and keeps the dfs moving forward
                    path.addFirst(parent);
                    dfsPrdecessorMap(begin, parent, graph, distance, result, path);
                    path.removeFirst(); // back track
                }
            }
        }
    }

    private void dfsGrok(String word, String endWord, Map<String, List<String>> graph,
                     Map<String, Integer> distance, List<List<String>> result,
                     List<String> path) {
        path.add(word);
        if (word.equals(endWord)) {
            result.add(new ArrayList<>(path));
        } else {
            if (graph.containsKey(word)) {
                for (String neighbor : graph.get(word)) {
                    if (distance.get(neighbor) == distance.get(word) + 1) {
                        dfsGrok(neighbor, endWord, graph, distance, result, path);
                    }
                }
            }
        }
        path.remove(path.size() - 1); // Backtrack
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

    private void bfsPrdecessorMap(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> graph, Map<String, Integer> distance) {

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

    void bfsGrokSuccessorMapOptimized(String beginWord, String endWord, Set<String> wordSet,
             Map<String, List<String>> graph, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        wordSet.remove(beginWord); // Prevent reprocessing beginWord

        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> allNeighbors = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> neighbors = findNeighbors(word, wordSet);
                allNeighbors.addAll(neighbors);
                for (String neighbor : neighbors) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, distance.get(word) + 1);
                        queue.offer(neighbor);
                        graph.computeIfAbsent(word, k -> new ArrayList<>()).add(neighbor);
                        if (neighbor.equals(endWord)) found = true; // Early stopping
                    } else if (distance.get(neighbor) == distance.get(word) + 1) {
                        graph.computeIfAbsent(word, k -> new ArrayList<>()).add(neighbor);
                    }
                }
            }
            wordSet.removeAll(allNeighbors); // Prune immediately
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

    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> allPaths;  // List of paths from beginWord to endWord
        Map<String, Set<String>> predecessorsMap;  // Map to track the predecessors of each word in the shortest paths

        allPaths = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList); // Convert word list to a set for efficient lookups
        if (!wordSet.contains(endWord)) {
            return allPaths; // If endWord is not in the word list, return empty list
        }
        wordSet.remove(beginWord); // Remove beginWord from the set to prevent cycles
        Map<String, Integer> distanceMap = new HashMap<>(); // Map to track the shortest path distances for words
        distanceMap.put(beginWord, 0); // Distance from beginWord to itself is 0
        predecessorsMap = new HashMap<>(); // Initialize the predecessors map
        Queue<String> queue = new ArrayDeque<>(); // Queue for BFS
        queue.offer(beginWord);
        boolean isEndWordFound = false; // Flag to check if endWord is found
        int steps = 0; // Step counter for BFS
        while (!queue.isEmpty() && !isEndWordFound) {
            ++steps;
            for (int i = queue.size(); i > 0; --i) {
                String currentWord = queue.poll();
                char[] currentChars = currentWord.toCharArray();
                for (int j = 0; j < currentChars.length; ++j) {
                    char originalChar = currentChars[j];
                    for (char c = 'a'; c <= 'z'; ++c) { // Try all possible one-letter mutations
                        currentChars[j] = c;
                        String newWord = new String(currentChars);
                        if (distanceMap.getOrDefault(newWord, 0) == steps) {
                            predecessorsMap.get(newWord).add(currentWord);
                        }
                        if (!wordSet.contains(newWord)) {
                            continue; // If the new word isn't in the set, skip it
                        }
                        // Update distance map and predecessors map for new words
                        predecessorsMap.computeIfAbsent(newWord, key -> new HashSet<>()).add(currentWord);
                        wordSet.remove(newWord); // Remove new word to prevent revisiting
                        queue.offer(newWord);
                        distanceMap.put(newWord, steps);
                        if (endWord.equals(newWord)) {
                            isEndWordFound = true; // Found the endWord; will finish after this level
                        }
                    }
                    currentChars[j] = originalChar; // Restore original character before next iteration
                }
            }
        }

        if (isEndWordFound) { // If the end word has been reached
            Deque<String> path = new ArrayDeque<>(); // Path stack for reconstructing paths
            path.add(endWord);
            backtrackPath(path, beginWord, endWord, predecessorsMap, allPaths); // Perform DFS to build all shortest paths
        }
        return allPaths; // Return the list of all shortest paths
    }

    private void backtrackPath(Deque<String> path, String beginWord, String currentWord, Map<String, Set<String>> predecessorsMap, List<List<String>> allPaths) {
        if (currentWord.equals(beginWord)) { // If the beginning of the path is reached, add it to allPaths
            allPaths.add(new ArrayList<>(path));
            return;
        }
        // Recursively go through all predecessors of the current word, adding them to the path
        for (String predecessor : predecessorsMap.get(currentWord)) {
            path.addFirst(predecessor); // Push the predecessor onto the path
            backtrackPath(path, beginWord, predecessor, predecessorsMap, allPaths); // Continue backtracking
            path.removeFirst(); // Remove the predecessor to backtrack
        }
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
//        System.out.println(wl2.findLadders2("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
//        System.out.println(wl2.findLadders2("aaaaa", "ggggg", Arrays.asList("aaaaa","caaaa","cbaaa","bbaaa","bbcaa","bbcba","bbdba","bbeba","bbfba","bbgba",
//                "bbhba","bbiba","bbjba","bbkba","bblba","bbmba","bbnba","bboba","bbpba","bbbba",
//                "abbba","acbba","ccbba","ccaba","ccaca","ccdba","ccdca","cceba","cceca","ccfba",
//                "ccfca","ccgba","ccgca","cchba","cchca","cciba","ccica","ccjba","ccjca","cckba",
//                "cckca","cclba","cclca","ccmba","ccmca","ccnba","ccnca","ccoba","ccoca","ccpba",
//                "ccpca","cccca","accca","adcca","ddcca","ddaca","ddada","ddbca","ddbda","ddeca",
//                "ddeda","ddfca","ddfda","ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca",
//                "ddjda","ddkca","ddkda","ddlca","ddlda","ddmca","ddmda","ddnca","ddnda","ddoca",
//                "ddoda","ddpca","ddpda","dddda","addda","aedda","eedda","eeeea","ggggg")));
//        System.out.println(wl2.findLadders2("aaaaa", "ggggg", Arrays.asList("aaaaa","caaaa","cbaaa","daaaa","dbaaa","eaaaa","ebaaa","faaaa","fbaaa","gaaaa","gbaaa","haaaa","hbaaa","iaaaa","ibaaa","jaaaa","jbaaa","kaaaa","kbaaa","laaaa","lbaaa","maaaa","mbaaa","naaaa","nbaaa","oaaaa","obaaa","paaaa","pbaaa","bbaaa","bbcaa","bbcba","bbdaa","bbdba","bbeaa","bbeba","bbfaa","bbfba","bbgaa","bbgba","bbhaa","bbhba","bbiaa","bbiba","bbjaa","bbjba","bbkaa","bbkba","bblaa","bblba","bbmaa","bbmba","bbnaa","bbnba","bboaa","bboba","bbpaa","bbpba","bbbba","abbba","acbba","dbbba","dcbba","ebbba","ecbba","fbbba","fcbba","gbbba","gcbba","hbbba","hcbba","ibbba","icbba","jbbba","jcbba","kbbba","kcbba","lbbba","lcbba","mbbba","mcbba","nbbba","ncbba","obbba","ocbba","pbbba","pcbba","ccbba","ccaba","ccaca","ccdba","ccdca","cceba","cceca","ccfba","ccfca","ccgba","ccgca","cchba","cchca","cciba","ccica","ccjba","ccjca","cckba","cckca","cclba","cclca","ccmba","ccmca","ccnba","ccnca","ccoba","ccoca","ccpba","ccpca","cccca","accca","adcca","bccca","bdcca","eccca","edcca","fccca","fdcca","gccca","gdcca","hccca","hdcca","iccca","idcca","jccca","jdcca","kccca","kdcca","lccca","ldcca","mccca","mdcca","nccca","ndcca","occca","odcca","pccca","pdcca","ddcca","ddaca","ddada","ddbca","ddbda","ddeca","ddeda","ddfca","ddfda","ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca","ddjda","ddkca","ddkda","ddlca","ddlda","ddmca","ddmda","ddnca","ddnda","ddoca","ddoda","ddpca","ddpda","dddda","addda","aedda","bddda","bedda","cddda","cedda","fddda","fedda","gddda","gedda","hddda","hedda","iddda","iedda","jddda","jedda","kddda","kedda","lddda","ledda","mddda","medda","nddda","nedda","oddda","oedda","pddda","pedda","eedda","eeada","eeaea","eebda","eebea","eecda","eecea","eefda","eefea","eegda","eegea","eehda","eehea","eeida","eeiea","eejda","eejea","eekda","eekea","eelda","eelea","eemda","eemea","eenda","eenea","eeoda","eeoea","eepda","eepea","eeeea","ggggg","agggg","ahggg","bgggg","bhggg","cgggg","chggg","dgggg","dhggg","egggg","ehggg","fgggg","fhggg","igggg","ihggg","jgggg","jhggg","kgggg","khggg","lgggg","lhggg","mgggg","mhggg","ngggg","nhggg","ogggg","ohggg","pgggg","phggg","hhggg","hhagg","hhahg","hhbgg","hhbhg","hhcgg","hhchg","hhdgg","hhdhg","hhegg","hhehg","hhfgg","hhfhg","hhigg","hhihg","hhjgg","hhjhg","hhkgg","hhkhg","hhlgg","hhlhg","hhmgg","hhmhg","hhngg","hhnhg","hhogg","hhohg","hhpgg","hhphg","hhhhg","ahhhg","aihhg","bhhhg","bihhg","chhhg","cihhg","dhhhg","dihhg","ehhhg","eihhg","fhhhg","fihhg","ghhhg","gihhg","jhhhg","jihhg","khhhg","kihhg","lhhhg","lihhg","mhhhg","mihhg","nhhhg","nihhg","ohhhg","oihhg","phhhg","pihhg","iihhg","iiahg","iiaig","iibhg","iibig","iichg","iicig","iidhg","iidig","iiehg","iieig","iifhg","iifig","iighg","iigig","iijhg","iijig","iikhg","iikig","iilhg","iilig","iimhg","iimig","iinhg","iinig","iiohg","iioig","iiphg","iipig","iiiig","aiiig","ajiig","biiig","bjiig","ciiig","cjiig","diiig","djiig","eiiig","ejiig","fiiig","fjiig","giiig","gjiig","hiiig","hjiig","kiiig","kjiig","liiig","ljiig","miiig","mjiig","niiig","njiig","oiiig","ojiig","piiig","pjiig","jjiig","jjaig","jjajg","jjbig","jjbjg","jjcig","jjcjg","jjdig","jjdjg","jjeig","jjejg","jjfig","jjfjg","jjgig","jjgjg","jjhig","jjhjg","jjkig","jjkjg","jjlig","jjljg","jjmig","jjmjg","jjnig","jjnjg","jjoig","jjojg","jjpig","jjpjg","jjjjg","ajjjg","akjjg","bjjjg","bkjjg","cjjjg","ckjjg","djjjg","dkjjg","ejjjg","ekjjg","fjjjg","fkjjg","gjjjg","gkjjg","hjjjg","hkjjg","ijjjg","ikjjg","ljjjg","lkjjg","mjjjg","mkjjg","njjjg","nkjjg","ojjjg","okjjg","pjjjg","pkjjg","kkjjg","kkajg","kkakg","kkbjg","kkbkg","kkcjg","kkckg","kkdjg","kkdkg","kkejg","kkekg","kkfjg","kkfkg","kkgjg","kkgkg","kkhjg","kkhkg","kkijg","kkikg","kkljg","kklkg","kkmjg","kkmkg","kknjg","kknkg","kkojg","kkokg","kkpjg","kkpkg","kkkkg","ggggx","gggxx","ggxxx","gxxxx","xxxxx","xxxxy","xxxyy","xxyyy","xyyyy","yyyyy","yyyyw","yyyww","yywww","ywwww","wwwww","wwvww","wvvww","vvvww","vvvwz","avvwz","aavwz","aaawz","aaaaz")));
    }
}
