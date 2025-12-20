// https://takeuforward.org/plus/dsa/problems/remove-duplicated-from-sorted-dll

package coding_patterns.linkedlist.mediumddl;

public class RemoveDuplicatesInDDL {

  public ListNode removeDuplicates(ListNode head) {
    ListNode cur = head;
    ListNode next = null;

    while (cur != null && cur.next != null) {
      next = cur.next;

      while (next != null && cur.val == next.val) {
        next = next.next;
      }

      cur.next = next;

      if (next != null)
        next.prev = cur;

      cur = cur.next;
    }

    return head;
  }

  public static void main(String[] args) {
    // pass the head
  }
}
