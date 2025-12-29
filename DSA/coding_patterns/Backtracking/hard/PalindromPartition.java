// https://leetcode.com/problems/palindrome-partitioning/description/

package hard;

// need revision for this problem

import java.util.ArrayList;
import java.util.List;

public class PalindromPartition {

    void palindromPartition(List<List<String>> lists, int index, String s, List<String> list) {

        if (index == s.length()) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrom(s, index, i)) {
                list.add(s.substring(index, i + 1));
                palindromPartition(lists, i + 1, s, list);
                list.removeLast();
            }
        }
    }

    boolean isPalindrom(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();

        new PalindromPartition().palindromPartition(lists, 0, s, list);
        System.out.println(lists);
    }
}