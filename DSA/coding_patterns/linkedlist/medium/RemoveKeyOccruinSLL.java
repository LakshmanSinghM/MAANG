// https://leetcode.com/problems/remove-linked-list-elements/

public class RemoveKeyOccruinSLL {
        public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            if (head != null && head.val == val) {
                head = head.next;
                cur = cur.next;
                continue;
            }
            
            if (cur.val == val) {
                next = cur.next;

                if (prev != null) {
                    prev.next = next;
                }
            }else prev = cur;
            cur =  cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        //pas the head
    }
}
