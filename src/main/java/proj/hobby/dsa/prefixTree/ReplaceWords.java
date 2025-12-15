package proj.hobby.dsa.prefixTree;

import java.util.List;

/**
 *
 * https://leetcode.com/problems/replace-words/description
 *
 */
public class ReplaceWords {

    class Trie {
        Trie[] child = new Trie[26];
        String word;
    }

    private Trie root = new Trie();
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String s : dictionary) {
            insert(s);
        }

        StringBuilder sb = new StringBuilder();
        for(String s : sentence.split(" ")) {
            sb.append(search(s)).append(" ");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    private void insert(String word) {
        Trie current = root;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if(current.child[idx] == null) {
                current.child[idx] = new Trie();
            }
            current = current.child[idx];
        }
        current.word = word;
    }

    private String search(String word) {

        if(root.word != null) return root.word;

        Trie current = root;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if(current.child[idx] == null) {
                return word;
            }
            if(current.child[idx].word != null) {
                return current.child[idx].word;
            }
            current = current.child[idx];
        }
        return word;
    }
}
