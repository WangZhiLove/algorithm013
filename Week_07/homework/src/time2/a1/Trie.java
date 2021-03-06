package time2.a1;

public class Trie {
    /**
     *  实现 Trie (前缀树)
     * 实现一个 Trie (前缀树)，包含insert,search, 和startsWith这三个操作。
     *
     * 示例:
     *
     * Trie trie = new Trie();
     *
     * trie.insert("apple");
     * trie.search("apple");   // 返回 true
     * trie.search("app");     // 返回 false
     * trie.startsWith("app"); // 返回 true
     * trie.insert("app");
     * trie.search("app");     // 返回 true
     * 说明:
     *
     * 你可以假设所有的输入都是由小写字母a-z构成的。
     * 保证所有输入均为非空字符串。
     */


    /** Inserts a word into the trie. */
    public void insert(String word) {

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        // 返回 true
        System.out.println(trie.search("apple"));
        // 返回 false
        System.out.println(trie.search("app"));
        // 返回 true
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        // 返回 true
        System.out.println(trie.search("app"));
    }
}


