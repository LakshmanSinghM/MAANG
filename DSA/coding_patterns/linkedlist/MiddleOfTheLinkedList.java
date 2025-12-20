// https://leetcode.com/problems/middle-of-the-linked-list/

class ListNode {
    ListNode next;
    int val;
}

public class MiddleOfTheLinkedList {

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // pass the head from here
    }
}
