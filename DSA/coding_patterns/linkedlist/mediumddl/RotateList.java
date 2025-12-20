// https://leetcode.com/problems/rotate-list/description/

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        int n = 1;

        if (head == null || head.next == null)
            return head;

        while (cur.next != null) {
            n++;
            cur = cur.next;
        }

        ListNode tempHead = head;
        cur = head;

        k = k % n;
        if (k == 0)
            return head;

        for (int i = 1; i <= n - k - 1; i++)
            cur = cur.next;

        ListNode newHead = cur.next;
        // System.out.println("New Head pit "+newHead.val);
        cur.next = null;

        ListNode t = newHead;
        while (t.next != null)
            t = t.next;

        t.next = tempHead;

        return newHead;
    }

    public static void main(String[] args) {
        // pass the head here
    }
}
