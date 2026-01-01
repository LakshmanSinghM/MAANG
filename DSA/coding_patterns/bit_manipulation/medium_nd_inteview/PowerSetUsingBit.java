// https://leetcode.com/problems/subsets/

package coding_patterns.bit_manipulation.medium_nd_inteview;

import java.util.ArrayList;
import java.util.List;

public class PowerSetUsingBit {

    void powerSet(List<List<Integer>> lists, int arr[]) {
        int n = 1 << arr.length;
        // 0-n

        for (int num = 0; num < n; num++) {
            // check each bits set or not in the number 1 - 8
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if ((num & (1 << i)) != 0) {
                    list.add(arr[i]);
                }
            }
            lists.add(list);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        PowerSetUsingBit powerSetUsingBit = new PowerSetUsingBit();
        int arr[] = { 1, 2, 3 };
        powerSetUsingBit.powerSet(lists, arr);
        System.out.println(lists);
    }
}
