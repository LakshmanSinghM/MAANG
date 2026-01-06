package coding_patterns.stack.basic;

import java.util.Stack;

public class ImplementPostInPreFixOperations {

    int getPriority(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        return -1;
    }

    boolean isOprend(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')
            return true;
        return false;
    }

    boolean isOpenBracket(char c) {
        return c == '(';
    }

    boolean isCloseBracket(char c) {
        return c == ')';
    }

    String postfixToPrefix(String s) {
        return "";
    }

    String postfixToInfix(String s) {
        return "";
    }

    String infixToPrefix(String s) {
        return "";
    }

    String infixToPostfix(String s) {
        s = s.replaceAll("\\s+", "");
        Stack<Character> stack = new Stack<>();
        String ans = "";

        for (char c : s.toCharArray()) {
            if (isOprend(c))
                ans = ans + c;
            else {
                if (stack.isEmpty() && !isOprend(c)) {
                    stack.push(c);
                } else if (stack.isEmpty() && isOprend(c)) {
                    ans = ans + c;
                } else {
                    char top = stack.peek();
                    if (getPriority(top) <= getPriority(c) || isOpenBracket(c))
                        stack.push(c);
                    else {
                        if (isCloseBracket(c)) {
                            while (!stack.isEmpty() && !isOpenBracket(stack.peek())) {
                                ans = ans + stack.peek();
                                stack.pop();
                            }
                            stack.pop();
                        } else {
                            while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
                                ans = ans + stack.peek();
                                stack.pop();
                            }
                            stack.push(c);
                        }
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        return ans;
    }

    String prefixToInfix(String s) {
        return "";
    }

    String prefixToPostfix(String s) {
        return "";
    }

    public static void main(String[] args) {
        ImplementPostInPreFixOperations obj = new ImplementPostInPreFixOperations();

        String postFix = "";
        String preFix = "";

        // String inFix = "(a+b)*c";
        // String inFix = "a+b*c";
        // String inFix = "A + (B * C - (D / E ^ F) * G) * H"; // A B C * D E F ^ / G *
        // - H * +
        // String inFix = "A + B * C ^ D - E / F"; // A B C D ^ * + E F / -
        // System.out.println(obj.infixToPostfix(inFix));
    }
}