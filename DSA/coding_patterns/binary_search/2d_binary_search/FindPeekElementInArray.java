
public class FindPeekElementInArray {

    // brute force

    // public static int findPeakElement(int[] arr) {
    // if (arr.length == 1)
    // return arr[0];
    // if (arr[1] < arr[0])
    // return arr[0];
    // if (arr[arr.length - 1] > arr[arr.length - 2])
    // return arr[arr.length - 1];

    // for (int i = 1; i <= arr.length - 2; i++) {
    // int ele = arr[i];
    // if (ele > arr[i - 1] && ele > arr[i + 1])
    // return i;
    // }
    // return -1;
    // }

    static public int findPeakElement(int[] nums) {
        int low = 1;
        int high = nums.length - 2;

        if (nums.length == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;

            if (nums[mid + 1] > nums[mid])
                low = mid + 1;
            else if (nums[mid - 1] > nums[mid])
                high = mid - 1;
            // go anywhere
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // int arr[] = new int[] { 1, 1, 1, 0, 2, 0 }; //infinite

        // questions says - nums[i] != nums[i + 1] for all valid i.

        int arr[] = new int[] { 0, 1, 0, 1, 2, 0 };
        System.out.println(findPeakElement(arr));
    }
}
