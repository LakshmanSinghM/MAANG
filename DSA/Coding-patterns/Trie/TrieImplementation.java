
class Trie {
    Trie links[] = new Trie[26];
    boolean endOfW;
}

class TrieMethods {
    Trie root;

    void insert(String s) {
        Trie node = root;

        for (int i = 0; i < s.length(); i++) {
            if (node.links[s.charAt(i) - 'a'] == null) {
                node.links[s.charAt(i) - 'a'] = new Trie();
            }
            node = node.links[s.charAt(i) - 'a'];
        }
        node.endOfW = true;
    }

    void display(Trie root, String str, int index) {
        if (root.endOfW == true)
            System.out.print(str);

        for (int i = 0; i < 26; i++) {
            if (root.links[i] != null) {
                String s = str + (i + 'a');
                display(root.links[i], s, index + 1);
            }
        }
    }

    void search(Trie root, String str, int index) {

        for (int i = 0; i < str.length(); i++) {
            if (root.links[i] != null) {
                String s = str + (i + 'a');
                display(root.links[i], s, index + 1);
            }
        }
    }
}

public class TrieImplementation {
    public static void main(String[] args) {
        String arr[] = new String[] { "hi", "hello" };
        TrieMethods tr = new TrieMethods();
        for (String s : arr)
            tr.insert(s);
        tr.display(new TrieMethods().root, "", 0);
    }
}
