package coding_patterns.stack.basic;

import java.util.Stack;

public class ValidaParenthesis {
    boolean isOpen(char c) {
        if (c == '(' || c == '[' || c == '{')
            return true;
        return false;
    }

    boolean isClose(char c) {
        if (c == ')' || c == ']' || c == '}')
            return true;
        return false;
    }

    boolean isMatchingSame(char c, char c2) {
        if (c == '(' && c2 == ')')
            return true;
        else if (c == '{' && c2 == '}')
            return true;
        else if (c == '[' && c2 == ']')
            return true;
        return false;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (isOpen(ch))
                stack.push(ch);

            else {
                if (stack.isEmpty())
                    return false;

                if (!isMatchingSame(stack.peek(), ch))
                    return false;

                if (!stack.isEmpty() && isMatchingSame(stack.peek(), ch)) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(())";
        ValidaParenthesis validaParenthesis = new ValidaParenthesis();
        System.out.println(validaParenthesis.isValid(s));
    }
}
