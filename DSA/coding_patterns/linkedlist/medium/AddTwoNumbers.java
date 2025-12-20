// https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry = 0;
        ListNode dummyHead = new ListNode(-1);
        ListNode d = dummyHead;

        while (t1 != null || t2 != null || carry == 1) {
            int num = carry;
            if (t1 != null) {
                num += t1.val;
                d.next = t1;
                t1 = t1.next;
            }
            if (t2 != null) {
                num += t2.val;
                d.next = t2;
                t2 = t2.next;
            }

            if (d.next != null)
                d = d.next;

            if (num > 9) {
                d.val = num % 10;
                carry = num / 10;
            } else {
                d.val = num;
                carry = 0;
            }

            if (d.next == null && carry >= 1)
                d.next = new ListNode(carry);

            // else d.next = null;
            // d = d.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        // pass head
    }
}
