public class UpperBound {
    static int findUpperBound(int arr[], int target) {
        int low = 0;
        int high = arr.length;
        int ans = -1; // anything acc to question if not found any greater or equal to the given
                      // target
                      // upper bound means the arr[mid] should be greater than the target
        while (low < high) {
            int mid = (high + low) / 2;
            if (target < arr[mid]) {
                ans = mid;
                high = mid;
            } else {
                // ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 1, 2, 3 };
        int target = 2;
        System.out.println("Found At Index " + findUpperBound(arr, target));
    }
}