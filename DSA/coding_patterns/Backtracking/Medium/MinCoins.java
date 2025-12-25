package medium;

import java.util.*;

public class MinCoins {
    // this is the technique to print the any one solution so return the true when
    // condition satisfied and return false when cndn not satisfied

    public static boolean findMinCoins(int arr[], int index, int n, int target, int sum, int cnt) {
        if (index >= arr.length) {
            return false;
        }

        if (target == sum) {
            System.out.println("Counts are  : " + cnt);
            return true;
        }
        if (sum > target) {
            return false;
        }
        sum += arr[index];
        cnt++;
        if (findMinCoins(arr, index, n, target, sum, cnt) == true)
            return true;
        sum -= arr[index];
        cnt--;
        if (findMinCoins(arr, index + 1, n, target, sum, cnt) == true)
            return true;
        return false;
    }

    // count total no of the subsequences return 1 when condition satisfied and
    // return 0 when condition not satisfied
    
    // find  min coins to get the target
    public static int findMinCoinsCount(int arr[], int index, int n, int target) {

        if (target == 0) {
            return 0;
        }

        if (index >= arr.length || target < 0) {
            return Integer.MAX_VALUE;
        }

        int leftCnt = findMinCoinsCount(arr, index, n, target - arr[index]);
        if (leftCnt != Integer.MAX_VALUE) {
            leftCnt = 1 + leftCnt;
        }

        int rightCnt = findMinCoinsCount(arr, index + 1, n, target);
        return Math.min(leftCnt, rightCnt);
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 4, 3, 2, 3 };
        // first sort the array in any order for now i will be sorting in DESC order
        // Arrays.sort(arr,(a,b)->b[0]-a[0]);
        // System.out.println(findMinCoins(arr, 0, arr.length, 7, 0, 0));
        System.out.println(findMinCoinsCount(arr, 0, arr.length, 4)); // wrong
        // ans
    }
}