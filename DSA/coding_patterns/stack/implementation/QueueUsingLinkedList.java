package coding_patterns.stack.implementation;

class DNode {
    DNode next;
    DNode prev;
    int data;

    DNode(int d) {
        data = d;
    }
}

class Queue {
    DNode head, tail;
    int size;

    void push(int n) {
        DNode newNode = new DNode(n);
        if (head == null || tail == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;

    }

    int pop() {

        if (head == null || tail == null) {
            return -1;
        }

        int data = head.data;
        if (head.next == null) {
            head = null;
            tail = null;
            size--;
            return data;
        }
        DNode node = head;
        head = head.next;
        head.prev = null;
        node.next = null;
        size--;

        return data;
    }

    void printQueue() {
        DNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

public class QueueUsingLinkedList {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(4);
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.printQueue();
    }
}
