// https://takeuforward.org/plus/dsa/problems/aggressive-cows

import java.util.Arrays;

public class AggressiveCows {

    static boolean canPlaceCows(int arr[], int distance, int cows) {
        int foundCows = 1;
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - last >= distance) {
                foundCows++;
                last = arr[i];
            }
            // optional check if count become more than cows we can break;
        }
        return foundCows >= cows;
    }

    public static int aggressiveCows(int[] arr, int k) {
        int low = arr[0];
        int high = arr[arr.length - 1];
        int ans = -1;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (canPlaceCows(arr, mid, k)) {
                low = mid + 1;
                ans = mid;
            } else
                high = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 6, k = 4;
        int arr[] = new int[] { 4, 2, 1, 3, 6 };
        int size = arr.length;

        Arrays.sort(arr);
        System.out.println(aggressiveCows(arr, k));
    }
}
