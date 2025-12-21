package medium;

import java.util.ArrayList;
import java.util.List;

public class PrintSubSequenceOfTarget {

    static List<Integer> findTargetSequence(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            if (target == 0) return new ArrayList<>(list); // base case: target matched
            return new ArrayList<>();
        }

        // Include current element
        list.add(arr[index]);
        List<Integer> include = findTargetSequence(arr, target - arr[index], index + 1, list);
        list.removeLast(); // backtrack

        if (!include.isEmpty()) return include;
    
        List<Integer> exclude = findTargetSequence(arr, target, index + 1, list);
        return exclude;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int target = 4;
        System.out.println(findTargetSequence(arr, target, 0, new ArrayList<>()));
    }
}
