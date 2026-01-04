package coding_patterns.stack.implementation;

import java.util.Arrays;

class Stack {
    int top = -1;
    int arr[];
    int size = -1;

    Stack(int size) {
        this.arr = new int[size];
        this.size = size;
    }

    void push(int n) {
        if (isStackFull()) {
            System.out.println("Stack is full ");
        } else {
            top = top + 1;
            arr[top] = n;
        }
    }

    int peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        return -1;
    }

    int pop() {
        if (isEmpty()) {
            return -1;
        }

        int n = arr[top];
        arr[top] = 0;
        top--;

        return n;
    }

    boolean isEmpty() {
        return size == 0 || top == -1;
    }

    int size() {
        return top + 1;
    }

    boolean isStackFull() {
        return size - 1 == top;
    }

    void printStack() {
        System.out.println(Arrays.toString(arr));
    }
}

public class ImplementStackUsingArrays {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(3);
        stack.printStack();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.printStack();
    }
}
