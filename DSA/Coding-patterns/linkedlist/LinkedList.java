class Node {
    Node next;
    int val;
}

class NodeMethods {
    Node head;

    void insert(int val) {
        if (head == null) {
            head = new Node();
            head.val = val;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node();
        temp.next.val = val;
    }

    void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    void deleteLast() {
        Node temp = head;
        Node prev = head;
       
        if(head.next==null) head = null;
        // 1 2 3 4 5

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.val + " ");
            temp = temp.next;
        }
    }
}

public class LinkedList {
    public static void main(String[] args) {
        NodeMethods nm = new NodeMethods();
        nm.insert(3);
        nm.insert(4);
        // nm.insert(7);
        // nm.deleteFirst();
        nm.deleteLast();
        nm.printList(nm.head);
    }
}