package interview;

import java.util.Arrays;
import java.util.LinkedList;

public class ToGetTheSumOfThePrevious {

    public static int[] findTheSumOfPrevious(int arr[], int arr1[], int n) {

        // ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            int ele = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (ele < arr[j]) {
                    sum = sum + arr1[j];
                }
            }
            list.addFirst(sum);
        }
        // Collections.reverse(list);
        System.out.println(list);
        return list.stream().mapToInt(e -> e).toArray();
    }

    public static void main(String[] args) {
        System.out.println("Next.pe Java Full Stack ");
        int arr[] = { 8, 4, 1, 2 };
        int arr1[] = { 8, 5, 1, 2 };
        int n = 4;
        System.out.println(Arrays.toString(findTheSumOfPrevious(arr, arr1, n)));
    }
}