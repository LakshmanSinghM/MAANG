package medium;

import java.util.ArrayList;
import java.util.List;

public class TestLaterDelete {

    static void printSS(int i, int arr[], List<List<Integer>> lists, List<Integer> list) {
        if (i >= arr.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        printSS(i + 1, arr, lists, list);
        list.removeLast();
        printSS(i+1, arr, lists, list);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        int arr[] = new int[] { 1, 2, 3 };
        printSS(0, arr, lists, new ArrayList<>());
        System.out.println(lists);
    }
}
