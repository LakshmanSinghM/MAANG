// https://leetcode.com/problems/min-stack/

package coding_patterns.stack.basic;

import java.util.Stack;

class MinStack {
    Stack<Long> stack;

    long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
            stack.push((long) val);
        } else {
            if (min < val)
                stack.push((long) val);
            else {
                long ele = 2L * val - min;
                stack.push((long) ele);
                min = val;
            }
        }
    }

    public void pop() {
        long top = stack.peek();
        if (top < min) {
            min = 2L * min - top;
            stack.pop();
        } else
            stack.pop();
    }

    public int top() {
        long top = stack.peek();
        if (top > min)
            return (int) top;
        return (int) min;
    }

    public int getMin() {
        return (int) min;
    }
}

public class MinStackLeetcode {

    public static void main(String[] args) {

    }

    // careful with the date type

    // brute force is to take the stack of type Node where value and min will there
    // to keep track of the last min till the point

}