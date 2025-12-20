public class ReverseNodeInKGroup {
    ListNode[] reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // System.out.println("The prev head reversed ");
        // print(prev);
        return new ListNode[] { prev, head };
    }

    void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode cur = head;
        int cnt = 1;
        ListNode lastHead = head;
        ListNode nextStart = null;
        ListNode lastEnd = null;
        boolean reverseFirst = false;

        while (cur != null) {
            if (k == cnt) {
                nextStart = cur.next;
                cur.next = null;
                ListNode starAndEnd[] = reverse(lastHead);

                if (reverseFirst == false) {
                    reverseFirst = true;
                    head = starAndEnd[0];
                }
                // print(starAndEnd[0]);

                if (lastEnd != null)
                    lastEnd.next = starAndEnd[0];
                lastEnd = starAndEnd[1];
                cur = nextStart;
                lastHead = nextStart;
                cnt = 1;
            } else {
                cnt++;
                cur = cur.next;
            }
        }
        if (lastHead != null)
            lastEnd.next = lastHead;
        return head;
    }

    public static void main(String[] args) {
        // pass the head here
    }
}
