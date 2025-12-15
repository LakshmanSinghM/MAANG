// https://leetcode.com/problems/linked-list-cycle/

package medium;

class ListNode {
    ListNode next;
    ListNode prev;
    int val;
}

public class DetectLoopInLinkedList {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int cnt = 1;
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast && cnt >= 2)
                return true;
            slow = slow.next;
            fast = fast.next.next;
            // if we put condition on this line then we dont need cnt;
            cnt++;
        }
        return false;
    }

    // public boolean hasCycle(ListNode head) {
    // List<ListNode> list = new ArrayList<>();
    // ListNode temp = head;

    // while(temp!=null){
    // if(!list.contains(temp)){
    // list.add(temp);
    // temp = temp.next;
    // }
    // else{
    // return true;
    // }
    // }
    // return false;
    // }

    public static void main(String[] args) {
        // detect cycle in a loop
    }
}