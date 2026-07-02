class TrieNode {
    TrieNode[] child;
    boolean isLeaf;

    TrieNode() {
        child = new TrieNode[26];
        isLeaf = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }

            curr = curr.child[idx];
        }

        curr.isLeaf = true;
    }

    public String longestCommonPrefix() {
        TrieNode curr = root;
        StringBuilder res = new StringBuilder();

        while (true) {
            int count = 0;
            int index = -1;

            // Count children
            for (int i = 0; i < 26; i++) {
                if (curr.child[i] != null) {
                    count++;
                    index = i;
                }
            }

            // Stop if more than one child or current node is end of a word
            if (count != 1 || curr.isLeaf) {
                break;
            }

            res.append((char) ('a' + index));
            curr = curr.child[index];
        }

        return res.toString();
    }
}

public class LongestCommonPrefixTrie {

    public static String longestSubString(String[] arr) {
        if (arr.length == 0)
            return "";

        Trie trie = new Trie();

        for (String s : arr) {
            trie.insert(s);
        }

        return trie.longestCommonPrefix();
    }

    public static void main(String[] args) {

        String[] arr1 = {"geeksforgeeks", "geeks", "geek", "geerer"};
        String[] arr2 = {"apple", "april", "ap"};
        String[] arr3 = {"hello", "world"};

        System.out.println(longestSubString(arr1)); // ge
        System.out.println(longestSubString(arr2)); // ap
        System.out.println(longestSubString(arr3)); //


        Trie obj = new Trie();
        for(String x:arr1){
            obj.insert(x);
        }

        System.out.println(obj.longestCommonPrefix());

        Trie obj2 = new Trie();
        for(String x:arr2){
            obj2.insert(x);
        }

        System.out.println(obj2.longestCommonPrefix());


        Trie obj3 = new Trie();
        for(String x:arr3){
            obj3.insert(x);
        }

        System.out.println(obj3.longestCommonPrefix());
    }
}