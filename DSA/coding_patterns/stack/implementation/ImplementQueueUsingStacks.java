// https://leetcode.com/problems/implement-queue-using-stacks/

package coding_patterns.stack.implementation;

import java.util.Stack;

import java.util.*;

public class ImplementQueueUsingStacks {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public ImplementQueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        peek();
        if (s2.isEmpty())
            return -1;
        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty())
            return s2.peek();

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    public boolean empty() {
        return s2.isEmpty() && s1.isEmpty();
    }

    public static void main(String[] args) {
        // do the operation here

        // Example 1:

        // Input
        // ["MyQueue", "push", "push", "peek", "pop", "empty"]
        // [[], [1], [2], [], [], []]
        // Output
        // [null, null, null, 1, 1, false]
    }
}