package proj.hobby.dsa.prefixTree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 *
 */
public class WordDictionary {

    private WordDictionary[] nodes = new WordDictionary[26];
    private boolean isWord;

    public WordDictionary() {
    }

    public void addWord(String word) {
        WordDictionary current = this;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if(current.nodes[idx] == null) {
                current.nodes[idx] = new WordDictionary();
            }
            current = current.nodes[idx];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, this, 0);
    }

    private boolean dfs(String word, WordDictionary node, int idx) {
        if(idx == word.length()) {
            return node != null && node.isWord;
        }

        char c = word.charAt(idx);
        if(c != '.') {
            int nodeIdx = c - 'a';
            if(node.nodes[nodeIdx] == null) return false;
            return dfs(word, node.nodes[nodeIdx], idx + 1);
        } else {
            for(int i = 0; i < 26; i++) {
                if(node.nodes[i] != null && dfs(word, node.nodes[i], idx + 1)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean searchBFS(String word) {
        List<WordDictionary> currentLevel = new ArrayList<>();
        currentLevel.add(this);

        for(char c : word.toCharArray()) {
            List<WordDictionary> nextLevel = new ArrayList<>();

            if(c != '.') {
                int idx = c - 'a';
                for(WordDictionary current: currentLevel) {
                    if(current.nodes[idx] != null) {
                        nextLevel.add(current.nodes[idx]);
                    }
                }
            } else {
                for(WordDictionary current: currentLevel) {
                    for(int i = 0; i < 26; i++) {
                        if(current.nodes[i] != null) {
                            nextLevel.add(current.nodes[i]);
                        }
                    }
                }
            }

            if(nextLevel.isEmpty()) return false;
            currentLevel = nextLevel;
        }

        for(WordDictionary node : currentLevel) {
            if(node.isWord) return true;
        }
        return false;
    }
}
