package proj.hobby.dsa.prefixTree;

/**
 *
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 */
public class WordDictionary {

    private static class Node {
        Node[] child = new Node[26];
        boolean isWord;
    }

    private final Node root = new Node();

    public WordDictionary() {
    }

    public void addWord(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if(cur.child[idx] == null) cur.child[idx] = new Node();
            cur = cur.child[idx];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, Node cur) {

        if (cur == null) return false;
        if (i == word.length()) return cur.isWord;

        char c = word.charAt(i);
        if (c == '.') {
            for(int k =0; k < 26; k++) {
                if(cur.child[k] != null && dfs(word, i+1, cur.child[k])) return true;
            }
            return false;
        } else {
            int idx = c - 'a';
            return dfs(word, i + 1, cur.child[idx]);
        }
    }
}