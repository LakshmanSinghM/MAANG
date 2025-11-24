
public class LoweBound {
    static int findLowerBound(int arr[], int target) {
        int low = 0;
        int high = arr.length;
        int ans = -1; // anything acc to question if not found any greater or equal to the given target
        while (low < high) {
            int mid = (high + low) / 2;
            if (target <= arr[mid]) {
                ans = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 2 };
        int target = 2;
        System.out.println("Found At Index " + findLowerBound(arr, target));
    }
}
