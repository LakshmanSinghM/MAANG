// https://takeuforward.org/dsa/strivers-a2z-sheet-learn-dsa-a-to-z

package coding_patterns.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    int[] nextSmallerElement(int arr[]) {

        Stack<Integer> stack = new Stack<>();
        int nums[] = Arrays.copyOf(arr, arr.length);

        for (int i = arr.length - 1; i >= 0; i--) {

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
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 2, 4, 1, 3 };

        NextSmallerElement nextGreatereElement = new NextSmallerElement();
        System.out.println(Arrays.toString(nextGreatereElement.nextSmallerElement(arr)));
    }
}
// do the same thing for the next smaller element-ii as the greater one