class Trie {
    Trie links[] = new Trie[26];
    boolean endOfW;

    Trie() {
        for (int i = 0; i < 26; i++)
            links[i] = null;
        endOfW = false;
    }
}

class TrieMethods {
    Trie root = new Trie();
    int index=0;

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

    void display(Trie root, String str) {
        if (root.endOfW == true)
            System.out.println(str);

        for (int i = 0; i < 26; i++) {
            if (root.links[i] != null) {
                String s = str + (char) (i + 'a');
                display(root.links[i], s);
            }
        }
    }

    boolean search(Trie root, String str) {
        Trie node = root;
        for (int i = 0; i < str.length(); i++) {

            if (node.links[str.charAt(i) - 'a'] == null)
                return false;

            node = node.links[str.charAt(i) - 'a'];

        }
        return node.endOfW == true;
    }

    boolean startWith(Trie root, String str) {
        Trie node = root;
        for (int i = 0; i < str.length(); i++) {
            if (node.links[str.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.links[str.charAt(i) - 'a'];
        }
        return true;
    }

    boolean hashNoChilden(Trie currentNode) {
        for (int i = 0; i < currentNode.links.length; i++) {
            if (currentNode.links[i] != null)
                return false;
        }
        return true;
    }

    boolean autoCompleteSuggestions(Trie node, String pref) {

        for (int i = 0; i < pref.length(); i++) {
            int index = pref.charAt(i) - 'a';
            if (node.links[index] == null) {
                return false;
            }
            ;
            node = node.links[index];
        }
        if (node.endOfW && hashNoChilden(node)) {
            System.out.println(pref);
            return false;
        }
        if (!hashNoChilden(node)) {
            display(node, pref);
        }
        return true;
    }

    int countChildren(Trie currentNode) {
        Trie node = currentNode;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (node.links[i] != null){
                   index = i;
                count++;
            }
        }
        return count;
    }

    String longestCommonPrefix(Trie root) {
        String prefix = "";
        Trie node = root; 
        while (countChildren(node) == 1 && !node.endOfW) {
            prefix = prefix + (char) (index + 'a');
            System.out.println("I value is "+index);
            node = node.links[index]; 
        }
        return prefix;
    }
}

public class TrieImplementation {
    public static void main(String[] args) {
        // String arr[] = new String[] { "hi", "hello", "abc", "aa", "ab", "abc", "abcd", "ac" };
        String arr[] = new String[] {"abc","ab","abd" };
        TrieMethods tr = new TrieMethods();
        for (String s : arr)
            tr.insert(s);
        System.out.println("Diplaying the inserted words");
        tr.display(tr.root, "");

        // System.out.println("Searching ");
        // boolean found = tr.search(tr.root, "ab");
        // System.out.println(found);

        // System.out.println("Searching startwith ");
        // boolean startWith = tr.startWith(tr.root, "b");
        // System.out.println(startWith);

        // System.out.println("Auto Completions");
        // tr.autoCompleteSuggestions(tr.root, "a");
        System.out.println("The longest prefix "+ tr.longestCommonPrefix(tr.root));
    }
}