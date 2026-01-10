public class SearchInRotatedII {
    public boolean search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (arr[mid] == target)
                return true;
            // [1,2,1]
            // it should be while condition support we 1 1 2 3 3 then ? 
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            if (low <= high) {
                if (arr[mid] <= arr[high]) {
                    if (target >= arr[mid] && target <= arr[high]) {
                        low = mid + 1;
                    } else
                        high = mid - 1;
                } else {
                    if (target >= arr[low] && target <= arr[mid]) {
                        high = mid - 1;
                    } else
                        low = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 3, 2, 3, 3, 3 };
        System.out.println(new SearchInRotatedII().search(arr, 2));
    }
}