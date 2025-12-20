// https://www.naukri.com/code360/problems/find-pairs_759395

package coding_patterns.linkedlist.mediumddl;

import java.util.ArrayList;

class Node {
    Node prev;
    Node next;
    int data;
}

public class FindPairSum {
    public static ArrayList<ArrayList<Integer>> getAllPairSum(Node head, int target) {
        Node right = head;
        Node left = head;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        while (right.next != null) {
            right = right.next;
        }

        while (left != null && right != null) {

            if (left == right || right.next == left)
                break;

            int sum = right.data + left.data;

            if (sum > target) {
                right = right.prev;
            } else if (sum < target)
                left = left.next;
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(left.data);
                temp.add(right.data);
                list.add(temp);
                left = left.next;
                right = right.prev;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // pass the head
    }
}
