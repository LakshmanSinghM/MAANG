// https://takeuforward.org/plus/dsa/problems/add-one-to-a-number-represented-by-ll

package medium;

public class AddOneToList {
    // optimal use recursion as we can have the last push element in the stack trace
    int findHelper(ListNode node) {
        if (node == null) {
            return 1;
        }
        int carry = findHelper(node.next);
        if (node.val + carry > 9) {
            node.val = 0;
            return 1;
        } else
            node.val = node.val + carry;
        return 0;
    }

    public ListNode addOne(ListNode head) {
        int carry = findHelper(head);

        if (carry == 1) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public static void main(String[] args) {

    }

    // brute force
    public ListNode reverse(ListNode head) {
        ListNode next = null;
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode addOne(ListNode head) {
        ListNode revHead = reverse(head);
        ListNode cur = revHead;
        int carry = 0;
        ListNode prev = null;
        cur.val = cur.val + 1;

        while (cur != null) {
            prev = cur;
            int num = cur.val + carry;
            if (num > 9) {
                cur.val = num % 10;
                carry = 1;
            } else {
                cur.val = num;
                carry = 0;
            }
            cur = cur.next;
        }
        if (carry == 1) {
            prev.next = new ListNode(carry);
        }
        revHead = reverse(revHead);
        return revHead;
    }
}