// https://leetcode.com/problems/next-greater-element-ii/

package coding_patterns.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    // public int[] nextGreaterElements(int[] nums) {
    // int arr[] = Arrays.copyOf(nums, nums.length);

    // for (int i = 0; i < nums.length; i++) {
    // boolean isThere = false;
    // for (int j = i + 1; j < nums.length; j++) {
    // if (i != j) {
    // if (nums[i] < arr[j]) {
    // nums[i] = arr[j];
    // isThere = true;
    // break;
    // }
    // }
    // }
    // if (!isThere) {
    // for (int j = 0; j < i; j++) {
    // if (i != j) {
    // if (nums[i] < arr[j]) {
    // nums[i] = arr[j];
    // isThere = true;
    // break;
    // }
    // }
    // }
    // }
    // if (!isThere)
    // nums[i] = -1;
    // }
    // return nums;
    // }

    // using circular aray

    // public int[] nextGreaterElements(int[] nums) {
    // int arr[] = Arrays.copyOf(nums, nums.length);

    // for (int i = 0; i < nums.length; i++) {
    // boolean isThere = false;
    // for (int j = i + 1; j < nums.length + i; j++) {
    // int index = j % nums.length;
    // if (nums[i] < arr[index]) {
    // nums[i] = arr[index];
    // isThere = true;
    // break;
    // }
    // }
    // if (!isThere)
    // nums[i] = -1;
    // }
    // return nums;
    // }

    // using monotonic stack

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int arr[] = Arrays.copyOf(nums, n);
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;
            while (!stack.isEmpty() && stack.peek() <= arr[index]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                if (i < n)
                    nums[i] = -1;
                stack.push(arr[index]);
            } else {
                if (i < n)
                    nums[i] = stack.peek();
                stack.push(arr[index]);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        // Input: nums = [1,2,1]
        // Output: [2,-1,2]
        // Explanation: The first 1's next greater number is 2;
        // The number 2 can't find next greater number.
        // The second 1's next greater number needs to search circularly, which is also
        // 2.
    }
}
