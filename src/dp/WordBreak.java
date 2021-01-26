package dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordBreak {
    /*
        Go through each char, check if word and recursive call to the rest of the substring
        Use memoization to speed up to O(N^3)
        Use trie to speed up check if it's in dictionary
     */

    public class Node {
        public Character c;
        public Map<Character, Node> child;
        public boolean isWord;

        public Node(Character c) {
            this.c = c;
            this.child = new HashMap<>();
            this.isWord = false;
        }

        public String toString() {
            return child.toString();
        }
    }

    public class Trie {

        public Node root;
        public Map<Integer, Boolean> cache;

        public Trie() {
            root = new Node(null);
            cache = new HashMap<>();
        }

        public void insert(String word) { // leet
            Node current = root;
            for (char c: word.toCharArray()) {
                current = current.child.computeIfAbsent(
                        c,
                        (k) -> new Node(c)
                );
            }
            current.isWord = true;
        }

        public boolean wordBreak(String s) {
            cache = new HashMap<>();
            return wordBreak(s, 0);
        }

        public boolean wordBreak(String s, int startIndex) { // leetcode, 4

            if (startIndex == s.length()) {
                return true;
            }

            if (cache.containsKey(startIndex)) {
                return cache.get(startIndex);
            }

            Node current = root;
            for (int i = startIndex; i < s.length(); i++) { // e
                if (current.child.containsKey(s.charAt(i))) {
                    current = current.child.get(s.charAt(i)); //t
                    if (current.isWord) {
                        boolean isRestBreakable = wordBreak(s, i + 1);
                        if (isRestBreakable) {
                            cache.put(startIndex, true);
                            return true;
                        }
                    }
                } else {
                    cache.put(startIndex, false);
                    return false;
                }
            }
            cache.put(startIndex, false);
            return false;
        }

        public String toString() {
            return root.toString();
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        //build trie
        Trie trie = new Trie();
        for (String word: wordDict) {
            trie.insert(word);
        }
        return trie.wordBreak(s);
    }
}