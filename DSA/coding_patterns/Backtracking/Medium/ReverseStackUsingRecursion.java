// https://takeuforward.org/data-structure/reverse-a-stack-using-recursion

package medium;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    
    static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int temp = stack.pop();
        reverse(stack);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        reverse(stack);
        System.out.println(stack);
    }
}
