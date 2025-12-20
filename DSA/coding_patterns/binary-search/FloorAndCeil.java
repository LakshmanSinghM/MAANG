public class FloorAndCeil {
    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1; // if no floor exists

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // exact match
            } else if (arr[mid] < target) {
                ans = arr[mid]; // potential floor
                low = mid + 1; // search right
            } else {
                high = mid - 1; // search left
            }
        }

        return ans;
    }

    public static int ceil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1; // if no ceil exists

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // exact match
            } else if (arr[mid] > target) {
                ans = arr[mid]; // potential ceil
                high = mid - 1; // search left
            } else {
                low = mid + 1; // search right
            }
        }

        return ans;
    }

    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        return new int[] { floor(a, x), ceil(a, x) };
    }

    public static void main(String[] args) {
        int a[] = new int[] { 3, 4, 4, 7, 8 };
        int x = 2;
        System.out.println(floor(a, x) + " " + ceil(a, x));
    }
}