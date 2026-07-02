class TrieNode {
    TrieNode[] child;
    int c;
    boolean isLeaf;

    TrieNode() {
        child = new TrieNode[26];
        c = 0;
        isLeaf = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String key) {
        key = key.toLowerCase();

        TrieNode curr = root;
        for (char ch : key.toCharArray()) {

            if (ch < 'a' || ch > 'z') {
                continue;
            }

            int index = ch - 'a';
            if (curr.child[index] == null) {
                curr.child[index] = new TrieNode();
            }

            curr.child[index].c++;
            curr = curr.child[index];
        }
        curr.isLeaf = true;
    }

    boolean search(String key) {
        key = key.toLowerCase();

        TrieNode curr = root;
        for (char ch : key.toCharArray()) {

            if (ch < 'a' || ch > 'z') continue;

            int idx = ch - 'a';
            if (curr.child[idx] == null)
                return false;

            curr = curr.child[idx];
        }

        return curr.isLeaf;
    }

    boolean PrefixSearch(String key) {
        key = key.toLowerCase();

        TrieNode curr = root;
        for (char ch : key.toCharArray()) {

            if (ch < 'a' || ch > 'z') continue;

            int idx = ch - 'a';
            if (curr.child[idx] == null)
                return false;

            curr = curr.child[idx];
        }

        return true;
    }

    int PrefixCount(String key) {
        key = key.toLowerCase();

        TrieNode curr = root;
        for (char ch : key.toCharArray()) {

            if (ch < 'a' || ch > 'z') continue;

            int idx = ch - 'a';
            if (curr.child[idx] == null)
                return 0;

            curr = curr.child[idx];
        }

        return curr.c;
    }

    int SearchPrefixCount(String key) {
        key = key.toLowerCase();

        TrieNode curr = root;
        for (char ch : key.toCharArray()) {

            if (ch < 'a' || ch > 'z') continue;

            int idx = ch - 'a';
            if (curr.child[idx] == null)
                return 0;

            curr = curr.child[idx];
        }

        return curr.isLeaf ? curr.c : 0;
    }

    
    int StringCount(String key) {
        key = key.toLowerCase();

        TrieNode curr = root;
        for (char ch : key.toCharArray()) {

            if (ch < 'a' || ch > 'z') continue;

            int idx = ch - 'a';
            if (curr.child[idx] == null)
                return 0;

            curr = curr.child[idx];
        }

        
        return curr.isLeaf ? curr.c : 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Trie obj = new Trie();

        obj.insert("red");
        obj.insert("red apple");

        System.out.println(obj.search("pine Apple")); // false
        System.out.println(obj.search("red"));        // true
        System.out.println(obj.search("Apple"));      // false

        System.out.println(obj.PrefixSearch("Apple")); // false
        System.out.println(obj.PrefixSearch("red"));   // true

        System.out.println(obj.PrefixCount("red"));   // 2
        System.out.println(obj.PrefixCount("blue"));  // 0

        System.out.println(obj.SearchPrefixCount("red"));  // 2
        System.out.println(obj.SearchPrefixCount("blue")); // 0
        
        
        obj.insert("red");
        obj.insert("redapple");
        obj.insert("redcar");
        obj.insert("blue");

        System.out.println(obj.StringCount("red"));      // 3
        System.out.println(obj.StringCount("redapple")); // 1
        System.out.println(obj.StringCount("redcar"));   // 1
        System.out.println(obj.StringCount("blue"));     // 1
        System.out.println(obj.StringCount("green"));
    }
}