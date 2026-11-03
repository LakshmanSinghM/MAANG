package dsa_revision.linkedlist.basic;

public class ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    ListNode current = head;
    ListNode next = null;
    ListNode prev = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
}
