// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

import java.util.Arrays;

public class MinThrehold {
    static boolean canfindSumOfDivisors(int arr[], int div, int t) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (int) Math.ceil((double) arr[i] / div);
        }
        return sum <= t;
    }

    public static int smallestDivisor(int[] arr, int threshold) {
        // int low = Arrays.stream(arr).min().getAsInt(); // smallest element wont work
        int low = 1; // smallest element
        int high = Arrays.stream(arr).max().getAsInt(); // largest element

        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (canfindSumOfDivisors(arr, mid, threshold)) {
                if (ans > mid)
                    ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 5, 9 };
        int t = 6;
        System.out.println(smallestDivisor(arr, t));
    }
}
