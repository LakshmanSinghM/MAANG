package medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutation {

    public static void swap(int arr[], int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public static void permutation(int arr[], int index, List<List<Integer>> lists) {
        
        if (index == arr.length) {
            System.out.println(Arrays.toString(arr));
            lists.add(IntStream.of(arr).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = index; i < arr.length; i++) {            
            swap(arr, i, index);
            permutation(arr, index + 1, lists);
            swap(arr, i, index);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3 };
        List<List<Integer>> lists = new ArrayList<>();
        permutation(arr, 0, lists);
        System.out.println(lists);
    }
}
