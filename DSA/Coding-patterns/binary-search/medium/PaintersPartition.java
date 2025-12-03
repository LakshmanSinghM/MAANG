// https://takeuforward.org/plus/dsa/problems/painters-partition

import java.util.Arrays;

public class PaintersPartition {
    static boolean canPainterPaint(int arr[], int min, int k) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > min) {
                count++;
                sum = arr[i];
            } else
                sum += arr[i];
        }
        return count <= k;
    }

    static int paintersPartition(int arr[], int a, int b) {
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int ans = -1;
        while (low <= high) {
            int mid = (high + low) / 2;

            if (canPainterPaint(arr, mid, a)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;

        }
        ans = (ans * b) % 10000003;
        return ans;
    }

    public static void main(String[] args) {
        // Input: A = 2, B = 5, C = [1, 10]
        // Output: 50

        int a = 10, b = 1;
        int arr[] = new int[] { 1, 8, 11, 3};

        // Input: A = 10, B = 1, C = [1, 8, 11, 3]
        // Output: 11

        System.out.println(paintersPartition(arr, a, b));
    }
}
