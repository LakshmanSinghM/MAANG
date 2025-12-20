// https://takeuforward.org/plus/dsa/problems/sort-a-ll-of-0's-1's-and-2's
class ListNode {
    ListNode next;
    int val;

    ListNode(int v) {
        this.val = v;
    }
}

public class Sort012InList { 

    public static ListNode sortList(ListNode head) {
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);
        ListNode z = zeroHead, o = oneHead, t = twoHead;

        ListNode temp = head;

        while (temp != null) {
            if (temp.val == 0) {
                z.next = temp;
                z = temp;
            }
            if (temp.val == 1) {
                o.next = temp;
                o = temp;
            }
            if (temp.val == 2) {
                t.next = temp;
                t = temp;
            }
            temp = temp.next;
        }

        z.next = null;
        o.next = null;
        t.next = null;
        // else this will form the infinite loop

        if (oneHead.next != null) {
            z.next = oneHead.next;
            if (twoHead.next != null)
                o.next = twoHead.next;
        } else
            z.next = twoHead.next;
            
        return zeroHead.next;
    }

    static void print(ListNode h) {
        ListNode t = h;
        while (t != null) {
            System.out.println(t.val);
            t = t.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(0);
        n2.next = n3;
        sortList(n1);
        print(n1);
    }
}