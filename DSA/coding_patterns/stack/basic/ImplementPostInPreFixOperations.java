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
        Stack<String> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (isOprend(c)) {
                stack.push(c + "");
            } else {
                String s2 = stack.pop();
                String s1 = stack.pop();

                String newStr = c + s1 + s2;
                stack.push(newStr);
            }
        }
        return stack.pop();
    }

    String postfixToInfix(String s) {
        Stack<String> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (isOprend(c)) {
                stack.push(c + "");
            } else {
                String s2 = stack.pop();
                String s1 = stack.pop();

                String newStr = "(" + s1 + c + s2 + ")";
                stack.push(newStr);
            }
        }
        return stack.pop();
    }

    String infixToPrefix(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            } else if (sb.charAt(i) == ')') {
                sb.setCharAt(i, '(');

            }
        }
        s = sb.toString();
        s = infixToPostfix(s);
        s = new StringBuilder(s).reverse().toString();
        return s;
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
        Stack<String> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (isOprend(c)) {
                stack.push(c + "");
            } else {
                String s2 = stack.pop();
                String s1 = stack.pop();

                String newStr = "(" + s2 + c + s1 + ")";
                stack.push(newStr);
            }
        }
        return stack.pop();
    }

    String prefixToPostfix(String s) {
        
        Stack<String> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (isOprend(c)) {
                stack.push(c + "");
            } else {
                String s1 = stack.pop();
                String s2 = stack.pop();

                String newStr = s1 + s2 + c;
                stack.push(newStr);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ImplementPostInPreFixOperations obj = new ImplementPostInPreFixOperations();

        // Infix to postfix
        // String inFix = "(a+b)*c";
        // String inFix = "a+b*c";
        // String inFix = "A + (B * C - (D / E ^ F) * G) * H"; // A B C * D E F ^ / G *
        // - H * +
        // String inFix = "A + B * C ^ D - E / F"; // A B C D ^ * + E F / -

        // Infix to preffix
        // String inFix = "(a+b)*c";
        // Prefix: *+abc

        // String inFix = "a+b*c";
        // Prefix: +a*bc

        // String inFix = "A + (B * C - (D / E ^ F) * G) * H";
        // Prefix: +A*-*BC*/D^EFGH

        // String inFix = "A + B * C ^ D - E / F";
        // Prefix: -+A*B^CD/EF

        // System.out.println(obj.infixToPrefix(inFix));

        // Postfix to Infix
        // String postFix = "ab+c";
        // (a+b)*c

        // String postFix = "abc*+";
        // a+(b*c)

        // String postFix = "ABC*DEF^/G*-H*+";
        // A+((B*C-(D/(E^F))*G)*H)

        // String postFix = "ABCD^*+EF/-";
        // A+(B*(C^D))-(E/F)

        // System.out.println(obj.postfixToInfix(postFix));

        // Prefix to Infix

        // String preFix = "*+abc";
        // (a+b)*c

        // String preFix = "+a*bc";
        // a+(b*c)

        // String preFix = "+A*-*BC*/D^EFGH";
        // A+((B*C-(D/(E^F))*G)*H)

        // String preFix = "-+A*B^CDEF";
        // A+(B*(C^D))-(E/F)

        // System.out.println(obj.prefixToInfix(preFix));

        // Postfix to Prefix

        // String postFix = "ab+c*";
        // *+abc

        // String postFix = "abc*+";
        // +a*bc

        // String postFix = "ABC*DEF^/G*-H*+";
        // +A*-*BC*/D^EFGH

        // String postFix = "ABCD^*+EF/-";
        // -+A*B^CDEF

        // System.out.println(obj.postfixToPrefix(postFix));

        // Prefix to Postfix

        // String preFix = "*+abc";
        // ab+c*

        // String preFix = "+a*bc";
        // abc*+

        // String preFix = "+A*-*BC*/D^EFGH";
        // ABC*DEF^/G*-H*+

        String preFix = "-+A*B^CDEF";
        // AB^C*+EF/-

        System.out.println(obj.prefixToPostfix(preFix));

    }
}

// Infix to Postfix
// left right operator

// Infix to Prefix
// operator left right

// Postfix to Infix
// (left operator right)

// Prefix to Infix
// (left operator right)

// Postfix to Prefix
// operator left right

// Prefix to Postfix
// left right operator