// https://takeuforward.org/plus/dsa/problems/next-greater-element

package coding_patterns.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatereElement {

    int[] nextGreatereElement(int arr[]) {

        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                stack.push(arr[i]);
                arr[i] = -1;
            } else {
                int element = arr[i];
                arr[i] = stack.peek();
                stack.push(element);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };

        NextGreatereElement nextGreatereElement = new NextGreatereElement();
        System.out.println(Arrays.toString(nextGreatereElement.nextGreatereElement(arr)));
    }
}