public class FindOneNonDuplication {
    public static int singleNonDuplicate(int[] nums) {
        int low = 1;
        int n = nums.length;
        int high = n - 2;

        if (nums.length == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];

            // this is not fully clear to me at this time
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1]))
                low = mid + 1;

            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 1, 2, 3, 3 };
        System.out.println(singleNonDuplicate(arr));
    }
}
