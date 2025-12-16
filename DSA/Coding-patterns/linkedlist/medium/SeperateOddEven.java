// https://leetcode.com/problems/odd-even-linked-list/

package medium;

public class SeperateOddEven {

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        // print(head);
        // print(evenHead);
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {

    }

    // ListNode insert(int val, ListNode head) {
    // ListNode temp = head;
    // ListNode newNode = new ListNode();
    // newNode.val=val;
    // if (head == null) {
    // head = newNode;
    // return head;
    // }
    // while (temp.next != null) {
    // temp = temp.next;
    // }
    // temp.next = newNode;
    // return head;
    // }

    // bruteforce/better

    // public ListNode oddEvenList(ListNode head) {
    // //using the extra space brute force

    // ListNode odd = head;
    // ListNode even = head;
    // ListNode newHead = null;
    // ListNode temp = head;

    // int cnt = 1;
    // while (temp != null) {
    // if (cnt % 2 == 1)
    // newHead = insert(temp.val, newHead);
    // temp = temp.next;
    // cnt++;
    // }

    // cnt = 1;
    // temp = head;
    // while (temp != null) {
    // if (cnt % 2 == 0)
    // newHead = insert(temp.val, newHead);
    // temp = temp.next;
    // cnt++;
    // }
    // return newHead;
    // }
}
