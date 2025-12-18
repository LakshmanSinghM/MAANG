package medium;

class ListNode {
    ListNode next;
    int val;

    ListNode(int val) {
        this.val = val;
    }
}

public class SortList {
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode middle = null;

        while (fast != null && fast.next != null) {
            middle = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        // not an issue as the exact middle not need may have less or greater values any
        // side
        return slow;
    }

    private ListNode merge(ListNode lHead, ListNode rHead) {
        ListNode dHead = new ListNode(-1);
        ListNode temp = dHead;

        while (lHead != null && rHead != null) {
            if (lHead.val < rHead.val) {
                temp.next = lHead;
                lHead = lHead.next;
                temp = temp.next;
            } else {
                temp.next = rHead;
                rHead = rHead.next;
                temp = temp.next;
            }
        }
        if (lHead != null) {
            temp.next = lHead;
        }
        if (rHead != null) {
            temp.next = rHead;
        }
        System.out.println("M-- ");
        print(dHead.next);
        return dHead.next;
    }

    void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val + "  ");
            temp = temp.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode middle = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        ListNode merged = merge(leftHead, rightHead);
        return merged;
    }

    public static void main(String[] args) {
        // pass the head here;
    }
}
