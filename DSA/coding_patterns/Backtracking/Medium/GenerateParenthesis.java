// https://leetcode.com/problems/generate-parentheses/

package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    void generateParenthesisHelper(List<String> list, String s, int n, int open, int close) {
        if (s.length() == n * 2) {
            list.add(s);
            return;
        }
        if (open < n)
            generateParenthesisHelper(list, s + "(", n, open + 1, close);
        if (close < open)
            generateParenthesisHelper(list, s + ")", n, open, close + 1);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesisHelper(list, "", n, 0, 0);
        return list;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new GenerateParenthesis().generateParenthesis(n));
    }
}
