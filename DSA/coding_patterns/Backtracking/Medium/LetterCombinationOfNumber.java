// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/comments/1972934/

package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationOfNumber {
    HashMap<Integer, String> map = new HashMap<>();

    List<String> letterCombinationOfNumber(String s) {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> list = new ArrayList<>();

        formComboUsingBacktracking(list, new StringBuilder(), s, 0);
        return list;
    }

    private void formComboUsingBacktracking(List<String> list, StringBuilder sb, String s, int start) {

        if (start == s.length()) {
            list.add(sb.toString());
            return;
        }

        String letters = map.get(s.charAt(start) - '0');

        for (char letter : letters.toCharArray()) {
            sb.append(letter);
            formComboUsingBacktracking(list, sb, s, start + 1);
            sb.deleteCharAt(start);
        }
    }

    public static void main(String[] args) {
        String str = "233";
        System.out.println(new LetterCombinationOfNumber().letterCombinationOfNumber(str));
    }
}
