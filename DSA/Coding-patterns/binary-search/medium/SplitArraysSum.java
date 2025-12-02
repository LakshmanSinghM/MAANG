// https://leetcode.com/problems/split-array-largest-sum

import java.util.Arrays;

public class SplitArraysSum {
    static boolean canPlaceInK(int arr[], int min, int k) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > min) {
                count++;
                sum = arr[i];
            }
            // else if(sum+arr[i]==min){ if needed
            // // count++;
            // sum =arr[i];
            // }
            else
                sum = sum + arr[i];
        }
        return count <= k;
    }

    static int splitArray(int[] arr, int k) {
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int ans = -1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (canPlaceInK(arr, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {7,2,5,10,8};
        int k = 2;
        // [7,2,5,10,8], k = 2
        System.out.println(splitArray(arr, k));
    }
}
