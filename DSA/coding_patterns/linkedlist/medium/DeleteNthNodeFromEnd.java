// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
package medium;

public class DeleteNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;

        if (head.next == null)
            return null;

        int i = 0;
        while (fast != null && i++ < n) {
            fast = fast.next;
        }

        ListNode slow = head;

        if (fast == null)
            return head.next;

        while (fast != null && fast.next != null) {
            System.out.println(fast.val + " f  ");
            System.out.println(slow.val + " s ");
            fast = fast.next;
            slow = slow.next;
        }

        // System.out.println(slow.val+" ");

        // if (slow != null) {
        // System.out.println(slow.val+" ss ");
        // if (slow.next != null)
        slow.next = slow.next.next;
        // else
        // slow.next = null;
        // }
        return head;
    }

    public static void main(String[] args) {

    }
}