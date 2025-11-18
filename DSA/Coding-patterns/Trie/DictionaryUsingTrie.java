import java.util.HashMap;
import java.util.Map;

// dictionary using the TRIE
class TrieNode {
    Map<Character, TrieNode> links = new HashMap<>();
    String meaning;
    boolean endOfW;
}

class TrieMethods {
    TrieNode root = new TrieNode();

    void insert(String s, String meaning) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.links.get(c) == null) {
                node.links.put(c, new TrieNode());
            }
            node = node.links.get(c);
        }
        node.endOfW = true;
        node.meaning = meaning;
    }

    String searchMeaning(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.links.get(c) == null)
                return "String or word not found";
            node = node.links.get(c);
        }
        if (node.endOfW) {
            return node.meaning;
        }
        return "String or word not found";
    }
}

public class DictionaryUsingTrie {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("hi", "Hi means to proceed the matter casually");
        map.put("hello", "Saying on call to ask hey");

        TrieMethods tm = new TrieMethods();
        map.forEach((key, meaning) -> tm.insert(key, meaning));
        System.out.println(tm.searchMeaning("hello"));
        // tm.insert()
    }
}