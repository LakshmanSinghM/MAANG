// https://takeuforward.org/plus/dsa/problems/book-allocation-problem

import java.util.Arrays;

public class BookAllocation {
    static boolean canAllocateToMStudent(int arr[], int minimum, int k) {
        int count = 1;
        int sum = 0;
        System.out.println("The values are like this " + minimum + "   " + k);
        // 1, 1, 3, 5, 4 m=4 , min=5
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > minimum) {
                count++;
                sum = arr[i];
            } else {
                sum = sum + arr[i];
            }
        }

        return count <= k;
    }

    static int bookAllocation(int arr[], int k) {
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int ans = -1;

        while (low <= high) {
            int mid = (high + low) / 2;

            System.out.println("Mid value is " + mid);

            if (canAllocateToMStudent(arr, mid, k)) {
                ans = mid;
                high = mid - 1;

            } else
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // [12, 34, 67, 90], m=2
        // 25, 46, 28, 49, 24 m=4

        int arr[] = new int[] { 12, 34, 67, 90 };
        int m = 2;

        System.out.println(bookAllocation(arr, m));

    }
}
