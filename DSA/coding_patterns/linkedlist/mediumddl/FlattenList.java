// https://www.naukri.com/code360/problems/flatten-a-linked-list_1112655

class Node {
    Node next;
    Node child;
    int data;

    Node(int t) {
        data = t;
    }
}

public class FlattenList {
    static Node mergeTwoList(Node left, Node right) {
        Node dummyHead = new Node(-1);
        Node dummy = dummyHead;

        Node l = left;
        Node r = right;

        while (l != null && r != null) {
            if (l.data < r.data) {
                dummy.child = l;
                dummy = l;
                l = l.child;
            } else {
                dummy.child = r;
                dummy = r;
                r = r.child;
            }
            dummy.next = null;
        }
        if (l != null)
            dummy.child = l;
        if (r != null)
            dummy.child = r;
        return dummyHead.child;
    }

    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node lastNode = flattenLinkedList(head.next);
        return mergeTwoList(lastNode, head);
    }

    public static void main(String[] args) {
        // pass the head
    }
}