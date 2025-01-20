package proj.hobby.dsa.prefixTree;

import java.util.*;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/?envType=study-plan-v2&envId=leetcode-75
 *
 * Trie Data structure:
 * A Trie, also known as a prefix tree, is a tree-like data structure used to store strings in a way
 * that facilitates efficient retrieval. It is widely used for problems involving prefix-based searches,
 * such as autocomplete, spell checking, and dictionary applications.
 *
 * Size of this Trie Data structure grows linearly with the total chars in words inserted
 *
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root =  new TrieNode();
    }

    /**
     *  Complexity: O(N) - N is length of Word
     *
     * @param word
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for(char c: chars){
            node = node.children.computeIfAbsent( c, k -> new TrieNode());
        }
        node.isWord = true;
    }

    /**
     * Complexity: O(N) - N is length of Word
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            node = node.children.get(c);
            if(node == null) {
                return false;
            }
        }
        return node.isWord;
    }

    /**
     * Complexity: O(N) - N is length of prefix
     *
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if(node == null) {
                return false;
            }
        }
        return true;
    }

    class TrieNode {
        private boolean isWord;
        private Map<Character, TrieNode> children;

        TrieNode(){
            children = new HashMap<>();
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("search result: "+trie.search("apple"));   // return True
        System.out.println("search result: "+trie.search("app"));     // return False
        System.out.println("search preix result: "+trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println("search result: "+trie.search("app"));     // return True

    }
}
