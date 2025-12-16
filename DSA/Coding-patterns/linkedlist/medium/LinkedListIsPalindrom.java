// https://leetcode.com/problems/palindrome-linked-list/

package medium;

public class LinkedListIsPalindrom {

    private static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "  ");
            cur = cur.next;

        }
        System.out.println();
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        boolean isEven = fast == null;
        ListNode nexthead = null;

        if (isEven) {
            nexthead = slow;
        } else
            nexthead = slow.next;

        ListNode reversedList = reverse(nexthead);
        slow = head;

        // print(reversedList);
        // print(slow);

        while (reversedList != null) {
            if (slow.val != reversedList.val)
                return false;
            reversedList = reversedList.next;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        // pass the head here
    }
}
