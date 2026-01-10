// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

public class FindMBouquetInMinDays {

    static boolean isBloomed(int arr[], int maxDayNum, int m, int k) {
        int count = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += (count / k);

            if ((count / k) >= 1)
                count = 0;

            if (arr[i] <= maxDayNum)
                count++;
            else
                count = 0;
        }
        
        sum += (count / k);
        return sum >= m;
    }

    static int[] minMax(int arr[]) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
            if (max < arr[i])
                max = arr[i];
        }
        return new int[] { min, max };
    }

    public static int minDays(int[] arr, int m, int k) {
        if (arr.length < (m * 1L * k * 1L))
            return -1;

        int low = minMax(arr)[0];
        int high = minMax(arr)[1];
        int minDay = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (high + low) / 2;

            // System.out.println("next step at " + mid);

            if (isBloomed(arr, mid, m, k)) {
                // System.out.println("isbloomed at " + mid);
                if (minDay > mid)
                    minDay = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return minDay;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 5, 4, 6, 7 };
        int m = 2;
        int k = 2;
        System.out.println(minDays(arr, m, k));
    }
}
