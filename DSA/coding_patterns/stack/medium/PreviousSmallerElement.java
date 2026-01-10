// https://leetcode.com/problems/sum-of-subarray-minimums/

package coding_patterns.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {

    // int[] previousSmallerElement(int arr[]) {

    // Stack<Integer> stack = new Stack<>();
    // int nums[] = Arrays.copyOf(arr, arr.length);

    // for (int i = 0; i < nums.length; i++) {

    // while (!stack.isEmpty() && (nums[i] == stack.peek() || stack.peek() >=
    // nums[i])) {
    // stack.pop();
    // }

    // if (stack.isEmpty()) {
    // stack.push(nums[i]);
    // arr[i] = -1;
    // } else {
    // arr[i] = stack.peek();
    // stack.push(nums[i]);
    // }
    // }
    // return arr;
    // }

    int[][] previousAndNextSmallerElement(int arr[]) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int nums[] = Arrays.copyOf(arr, arr.length); // to traverse on
        int arr2[] = Arrays.copyOf(arr, arr.length);
        int j = nums.length - 1;

        for (int i = 0; i < nums.length; i++, j--) {
            while (!stack.isEmpty() && (nums[i] == stack.peek() || stack.peek() >= nums[i])) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                stack.push(nums[i]);
                arr[i] = -1;
            } else {
                arr[i] = stack.peek();
                stack.push(nums[i]);
            }

            while (!stack2.isEmpty() && (nums[j] == stack2.peek() || stack2.peek() >= nums[j])) {
                stack2.pop();
            }

            if (stack2.isEmpty()) {
                stack2.push(nums[j]);
                arr2[j] = -1;
            } else {
                arr2[j] = stack2.peek();
                stack2.push(nums[j]);
            }

        }
        return new int[][] { arr, arr2 };
    }

      int[][] previousAndNextSmallerElementIndexes(int nums[]) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int arr[] = Arrays.copyOf(nums, nums.length); // to traverse on
        int arr2[] = Arrays.copyOf(nums, nums.length);
        int j = nums.length - 1;

        for (int i = 0; i < nums.length; i++, j--) {

            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }

            arr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);

            while (!stack2.isEmpty() && nums[stack2.peek()] >= nums[j]) {
                stack2.pop();
            }

            arr2[j] = stack2.isEmpty() ? nums.length : stack2.peek();

            stack2.push(j);

        }
        return new int[][] { arr, arr2 };
    }

    public int sumSubarrayMins(int[] arr) {
        long total = 0;
        int output[][] = previousAndNextSmallerElement(arr);
        int prev[] = output[0];
        int next[] = output[1];
        long MOD = 1000000007L;
 

        for (int i = 0; i < arr.length; i++) {
            int left = i - prev[i];
            int right = next[i] - i;
            
            total = (total + (left * right * 1L * arr[i]) % MOD) % MOD;
        }
        return (int) (total % MOD);
    }

    // brute force 

    // public int sumSubarrayMins(int[] arr) {
    //     long total = 0;

    //     for (int i = 0; i < arr.length; i++) {
    //         long min = arr[i];
    //         for (int j = i; j <= arr.length - 1; j++) {
    //             if (min > arr[j])
    //                 min = arr[j];
    //             total += min;
    //         }
    //     }

    //     long MOD = 1000000007L;
    //     return (int) (total % MOD);
    // }


    public static void main(String[] args) {
        // int arr[] = { 6, 2, 4, 1, 3 };
        // PreviousSmallerElement previousSmallerElement = new PreviousSmallerElement();
        // int output[][] = previousSmallerElement.previousAndNextSmallerElementIndexes(arr);
        // System.out.println(Arrays.toString(output[0]));
        // System.out.println(Arrays.toString(output[1]));
    }
}