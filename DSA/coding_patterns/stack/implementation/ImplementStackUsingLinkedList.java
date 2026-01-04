package coding_patterns.stack.implementation;

class Node {
    Node prev;
    int val;

    Node(int n) {
        val = n;
    }
}

class StackImpl {
    Node top;
    int size;

    StackImpl() {
    }

    void push(int n) {
        Node newNode = new Node(n);
        if (top == null) {
            top = newNode;
            size++;
            return;
        }
        newNode.prev = top;
        top = newNode;
    }

    int peek() {
        if (top != null) {
            return top.val;
        }
        return -1;
    }

    int pop() {
        if (top != null) {
            Node ele = top;
            int data = ele.val;
            top = ele.prev;
            ele = null;
            size--;
            return data;
        }
        return -1;
    }
}

public class ImplementStackUsingLinkedList {
    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push(2);
        stack.push(4);
        stack.push(6);

        System.out.println(stack.pop());
        stack.push(8);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}