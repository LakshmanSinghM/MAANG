public class FindRotatedTimesArray {
    public static int findMin(int[] arr) {
        int ans = Integer.MAX_VALUE;
        int index = 0;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (arr[low] <= arr[mid]) {
                if (ans > arr[low]) {
                    ans = arr[low];
                    index = low;
                }
                low = mid + 1;
            } else if (arr[mid] <= arr[high]) {
                if (ans > arr[mid]) {
                    ans = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index ;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 7, 8, 1, 2, 3, 4, 5 };
        System.out.println(findMin(arr));
    }
}
