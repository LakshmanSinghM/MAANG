// https://leetcode.com/problems/reverse-linked-list

public class ReverserSinglyList {

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    // brute force use stack

    // other way is recursion to reverse

    public static void main(String[] args) {
        // call with the head
    }
}