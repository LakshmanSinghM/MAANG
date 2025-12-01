import java.util.Arrays;

public class CapToShipItemsInDays {

    static boolean canShipInDays(int arr[], int days, int cap) {
        int sum = 0;
        int cnt = 1; 
        // cap=11
        // [1,2,3,4,5,6,7,8,9,10]
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > cap) {
                cnt++;
                sum = arr[i];
            } else {
                sum = sum + arr[i];
            }
        }

        System.out.println("COunt value at cnt " + cnt + "  cap  " + cap + "  day  " + days);
        return cnt <= days;
    }

    // [1,2,3,4,5,6,7,8,9,10]
    public static int shipWithinDays(int[] arr, int days) {
        int low = Arrays.stream(arr).max().getAsInt(), high = Arrays.stream(arr).sum();
        int ans = high;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (canShipInDays(arr, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 4, 5, 6, 7 };
        int day = 4;
        System.out.println(shipWithinDays(arr, day));
    }
}