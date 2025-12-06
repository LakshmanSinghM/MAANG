// https://leetcode.com/problems/remove-outermost-parentheses/description/

public class RemoveOuterMostParenthesis {
    public static String removeOuterParentheses(String s) {
        int open = 0;
        StringBuilder sb = new StringBuilder();
        int findex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(') {
                open++;
            } else if (s.charAt(i) != ')') {
                open--;
            }
            if (open == 0) {
                System.out.println(findex + "  " + i);
                sb.append(s.substring(findex + 1, i));
                findex = i + 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Input: s = "(()())(())(()(()))"
        // Output: "()()()()(())"

        String s = "(()())(())(()(()))";
        System.err.println(removeOuterParentheses(s));
    }
}
