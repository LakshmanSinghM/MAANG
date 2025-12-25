package medium;

public class CountSubSequenceEqToK {
    int countSubsequenceOfTarget(int target, int nums[], int i, int n, int sum) {

        if (i >= n || sum > target || sum < 0) {
            // even single element is there then also it will get chance to come in this if
            if (target == sum)
                return 1;
            else
                return 0;
        }

        sum += nums[i];
        int left = countSubsequenceOfTarget(target, nums, i + 1, n, sum);
        sum -= nums[i];
        int right = countSubsequenceOfTarget(target, nums, i + 1, n, sum);
        return left + right;
    }

    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        int count = countSubsequenceOfTarget(k, nums, 0, nums.length, 0);

        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 9, 2, 5, 1 };
        int k = 10;
        System.out.println(new CountSubSequenceEqToK().countSubsequenceWithTargetSum(arr, k));
    }
}
