package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    
    public static void combinationSum(int index, List<List<Integer>> lists, int arr[],
            List<Integer> list, int sum, int target) {

        if (index == arr.length) {
            if (sum == target) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }

        if (sum < 0) {
            return;
        }

        if (sum == target) {
            lists.add(new ArrayList<>(list));
        }
        list.add(arr[index]);
        sum += arr[index];
        combinationSum(index + 1, lists, arr, list, sum, target);
        sum -= arr[index];
        list.removeLast();
        combinationSum(index + 1, lists, arr, list, sum, target);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 1 };
        List<List<Integer>> lists = new ArrayList<>();
        int target = 5;
        Arrays.sort(arr);
        combinationSum(0, lists, arr, new ArrayList<>(), 0, target);
        System.out.println(lists);
    }
}
