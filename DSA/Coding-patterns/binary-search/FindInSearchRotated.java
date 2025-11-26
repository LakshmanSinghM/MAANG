public class FindInSearchRotated {
    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {

            int mid = (high + low) / 2;
            if (arr[mid] == target)
                return mid;

            if (arr[mid] <= arr[high]) {
                if (target >= arr[mid] && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;

            } else {
                if (target >= arr[low] && target <= arr[mid]) {
                    high = mid - 1;
                } else
                    low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 4, 5, 1, 2, 3 };
        System.out.println(search(arr, 1));
    }
}
