// https://leetcode.com/problems/subsets-ii/description/

package medium;

import java.util.*;
 
public class SubsetsII {

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 1 };
        Set<List<Integer>> lists = new HashSet<>();
        List<List<Integer>> lists2 = new ArrayList<>();
        Arrays.sort(arr);
        subsets(arr, 0, lists, new ArrayList<>());
        subsets(arr, 0, lists2, new ArrayList<>());
        // System.out.println(lists);
        System.out.println(lists2);//wng
    }

    private static void subsets(int[] arr, int i, Set<List<Integer>> lists, List<Integer> list) {
        if (i >= arr.length) {
            if (!list.isEmpty())
                lists.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[i]);
        subsets(arr, i + 1, lists, list);
        list.removeLast();
        subsets(arr, i + 1, lists, list);
    }

    private static void subsets(int[] arr, int i, List<List<Integer>> lists, List<Integer> list) {
        if (i >= arr.length) {
            if (!list.isEmpty())
                lists.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[i]);
        if (i >= 1 && arr[i] != arr[i - 1])
        subsets(arr, i + 1, lists, list);
        else
        subsets(arr, i + 1, lists, list);
        list.removeLast();
        
        if (i >= 1 && arr[i] != arr[i - 1])
        subsets(arr, i + 1, lists, list);
        else   
        subsets(arr, i + 1, lists, list);
    }
}
