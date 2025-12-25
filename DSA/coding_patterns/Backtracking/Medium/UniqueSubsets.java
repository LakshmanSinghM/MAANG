// https://leetcode.com/problems/subsets/

package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueSubsets {
    void formSubSet(Set<List<Integer>> lists, List<Integer> list, int arr[], int i, int n) {
        lists.add(new ArrayList<>(list));

        if (i >= n) {
            return;
        }

        list.add(arr[i]);
        formSubSet(lists, list, arr, i + 1, n);
        list.removeLast();
        formSubSet(lists, list, arr, i + 1, n);
    }

    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> lists = new HashSet<>();
        formSubSet(lists, new ArrayList<>(), nums, 0, nums.length);
        return new ArrayList<>(lists);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        System.out.println(new UniqueSubsets().subsets(arr));
    }
}
