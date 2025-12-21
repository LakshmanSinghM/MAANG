import java.util.Arrays;

class TrieNode {
    TrieNode links[] = new TrieNode[26];
    boolean endOfW;
}

class TrieMethods {
    TrieNode root = new TrieNode();
    int index = 0;

    void insert(String w) {
        TrieNode node = root;

        for (int i = 0; i < w.length(); i++) {
            int index = w.charAt(i) - 'a';
            if (node.links[index] == null)
                node.links[index] = new TrieNode();

            node = node.links[index];
        }
        node.endOfW = true;
    }

    int countChildren(TrieNode root) {
        TrieNode node = root;
        int count = 0;
        if (node == null)
            return 0;
        for (int i = 0; i < 26; i++) {
            if (node.links[i] != null) {
                count++;
                index = i;
            }
        }
        return count;
    }

    String lCP(TrieNode root) {
        TrieNode node = root;
        String prefix = "";

        while (countChildren(node) == 1 && node.endOfW == false) {
            prefix += (char) (index + 'a');
            node = node.links[index];
        }
        return prefix;
    }
}

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        // StringBuilder sb = new StringBuilder();
        // Arrays.sort(strs);
        // int min = Integer.MAX_VALUE;
        // String mins = strs[0];
        // int max = Integer.MIN_VALUE;
        // String maxs = strs[strs.length - 1];
        // for (int i = 0; i < Math.min(mins.length(), maxs.length()); i++) {
        // if (mins.charAt(i) != maxs.charAt(i)) {
        // return sb.toString();
        // }
        // sb.append(mins.charAt(i));
        // }
        // return sb.toString();
        TrieMethods tm = new TrieMethods();
        for (String s : strs)
            tm.insert(s);

        return tm.lCP(tm.root);
    }
}
