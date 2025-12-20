
class ListNode {
    ListNode prev;
    ListNode next;
    int val;
}

public class DeleteOccurOfKeyInDDL {
    public ListNode deleteAllOccurrences(ListNode head, int target) {

        ListNode cur = head;

        while (cur != null) {
            if (head != null && head.val == target) {
                head = head.next;
                head.prev = null;
                cur = cur.next;
                continue;
            }
            if (cur.val == target) {
                ListNode next = cur.next;
                ListNode prev = cur.prev;

                if (next != null)
                    next.prev = prev;
                if (prev != null)
                    prev.next = next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // pass the headh here
    }
}