// https://leetcode.com/problems/combination-sum-ii/
package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    void findCoinsToFormTarget(List<List<Integer>> lists, int i, int n, int arr[], List<Integer> list, int target) {
        if (i == n || target < 0) {
            if (target == 0)
                lists.add(new ArrayList<>(list));
            return;
        }
        if (target == 0)
            lists.add(new ArrayList<>(list));

        for (int index = i; index < arr.length; index++) {
            if (index > i && arr[index] == arr[index - 1])
                continue;
            list.add(arr[index]);
            findCoinsToFormTarget(lists, index + 1, n, arr, list, target - arr[index]);
            list.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        findCoinsToFormTarget(lists, 0, candidates.length, candidates, new ArrayList<>(), target);
        return lists;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, target);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 1 }; 
        int target = 5;
        System.out.println(new CombinationSumII().combinationSum2(arr, target));
    }
}
