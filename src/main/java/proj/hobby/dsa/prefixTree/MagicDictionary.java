package proj.hobby.dsa.prefixTree;

/**
 *
 * https://leetcode.com/problems/implement-magic-dictionary/description
 *
 */
public class MagicDictionary {

    class Trie{
        Trie[] nodes = new Trie[26];
        boolean isWord;
    }


    private Trie root = new Trie();

    public MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
        for(String word : dictionary) {
            Trie node = root;
            for(char c : word.toCharArray()) {
                int idx = c - 'a';

                if(node.nodes[idx] == null)  node.nodes[idx] = new Trie();

                node = node.nodes[idx];
            }
            node.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        for(int i = 0; i < searchWord.length(); i++) {
            if(search(searchWord, 0, i, root)) return true;
        }
        return false;
    }

    private boolean search(String word, int idx, int exc, Trie cur) {
        if(cur == null) return false;

        if(idx == word.length()) return cur.isWord;

        char c = word.charAt(idx);
        int p = c - 'a';
        if(idx == exc) {
            for(int k = 0; k < 26; k++) {
                if(k == p) continue;
                if(cur.nodes[k] != null && search(word, idx+1, exc, cur.nodes[k])) return true;
            }
            return false;
        } else {
            return search(word, idx+1, exc, cur.nodes[p]);
        }
    }
}
