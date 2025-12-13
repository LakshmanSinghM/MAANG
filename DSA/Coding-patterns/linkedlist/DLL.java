class Node {
    Node next;
    Node prev;
    int val;
}

class DDLMethods {
    Node head;
    Node tail;

    void insertFront(int val) {
        Node newNode = new Node();
        newNode.val = val;

        if (head == null || tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void insertLast(int val) {
        Node newNode = new Node();
        newNode.val = val;

        if (head == null || tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    void deleteFront() {
        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }

        if (head != null) {
            head = head.next;
            head.prev = null;
        }
    }

    void deleteLast() {

        if (tail != null) {
            if (tail.prev == null) {
                tail = null;
                head = null;
                return;
            }
            Node prev = tail.prev;
            prev.next = null;
            tail.prev = null;
            tail = prev;
        }
    }

    void printDLLForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    void printDLLBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.prev;
        }
    }

    void arrayToDLL(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            insertLast(arr[i]);
        }
    }
}

public class DLL {
    public static void main(String[] args) {
        DDLMethods ddlMethods = new DDLMethods();
        int arr[] = new int[] { 2, 5, 6, 7 };

        ddlMethods.arrayToDLL(arr);
        ddlMethods.deleteFront();
        ddlMethods.deleteLast();
        ddlMethods.deleteLast();
        // ddlMethods.deleteLast(); 
        // ddlMethods.deleteLast();
        ddlMethods.printDLLForward();
        // ddlMethods.printDLLBackward();
    }
}