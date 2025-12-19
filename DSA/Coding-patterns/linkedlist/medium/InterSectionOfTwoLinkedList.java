// https://leetcode.com/problems/intersection-of-two-linked-lists/

public class InterSectionOfTwoLinkedList {
    static int findLength(ListNode head) {
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = findLength(headA);
        int l2 = findLength(headB);

        ListNode bigOne = null;
        ListNode smallOne = null;
        if (l1 > l2) {
            bigOne = headA;
            smallOne = headB;
        } else {
            bigOne = headB;
            smallOne = headA;
        }

        int diff = Math.abs(l1 - l2);
        while (diff-- > 0) {
            bigOne = bigOne.next;
        }

        System.out.println("S " + smallOne.val + " B  " + bigOne.val);

        while (smallOne != null && bigOne != null) {
            if (smallOne == bigOne)
                return smallOne;
            bigOne = bigOne.next;
            smallOne = smallOne.next;
        }

        return null;
    }

    public static void main(String[] args) {
        // pass the head here
    }
}
