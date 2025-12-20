// https://takeuforward.org/plus/dsa/problems/length-of-loop-in-ll

package medium;

public class LengthOfLoop {

    // public static int findLengthOfLoop(ListNode head) {
    // ListNode fast = head;
    // ListNode slow = head;
    // while (fast != null && fast.next != null) {
    // slow = slow.next;
    // fast = fast.next.next;
    // if (slow == fast) {
    // slow = head;
    // while (slow != fast) {
    // slow = slow.next;
    // fast = fast.next;
    // }
    // ListNode start = slow.next;
    // int cnt = 1;

    // while (start != slow) {
    // cnt++;
    // start = start.next;
    // }
    // return cnt;
    // }
    // }
    // return 0;
    // }

    public static int findLength(ListNode start, ListNode end) {
        int cnt = 1;
        end = end.next;
        while (end != start) {
            end = end.next;
            cnt++;
        }
        return cnt;
    }

    public static int findLengthOfLoop(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return findLength(slow, fast);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // pass head here
    }
}