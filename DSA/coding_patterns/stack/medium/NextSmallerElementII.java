package coding_patterns.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementII {

    public int[] nextSmallerElementII(int[] nums) {
        int n = nums.length;
        int arr[] = Arrays.copyOf(nums, n);

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;
            while (!stack.isEmpty() && (stack.peek() == arr[index] || stack.peek() > arr[index])) {
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

        int arr[] = { 6, 3, 1, 2, 3 };

        NextSmallerElementII nextGreatereElement = new NextSmallerElementII();
        System.out.println(Arrays.toString(nextGreatereElement.nextSmallerElementII(arr)));
    }
}