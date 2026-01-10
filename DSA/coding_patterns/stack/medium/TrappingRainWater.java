package coding_patterns.stack.medium;

import java.util.Arrays;

public class TrappingRainWater {

    // brute force to solve
    // T- (3N)
    // T - (2N)

    void calculateLeft(int left[]) {
        int leftMax = left[0];
        for (int i = 1; i < left.length; i++) {
            if (leftMax < left[i]) {
                leftMax = left[i];
            } else
                left[i] = leftMax;
        }
    }

    void calculateRight(int right[]) {
        int rightMax = right[right.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            if (rightMax < right[i]) {
                rightMax = right[i];
            } else
                right[i] = rightMax;
        }
    }

    // int trappingRainWater(int arr[]) {

    // int left[] = Arrays.copyOf(arr, arr.length);
    // int right[] = Arrays.copyOf(arr, arr.length);

    // calculateLeft(left);
    // calculateRight(right);
    // int total = 0;

    // // we can optimize the space by tracking the left in this loop itself see
    // below method

    // for (int i = 0; i < left.length; i++) {
    // total = total + Math.min(left[i], right[i]) - arr[i];
    // }
    // return total;
    // }

    // T- (3N)
    // T - (N)

    int trappingRainWater(int arr[]) {

        // int left[] = Arrays.copyOf(arr, arr.length);
        int right[] = Arrays.copyOf(arr, arr.length);

        // calculateLeft(left);
        calculateRight(right);
        int total = 0;
        int leftMax = arr[0];

        // we can optimize the space by tracking the left in this loop itself see below
        // method

        for (int i = 0; i < arr.length; i++) {
            if (leftMax < arr[i]) {
                leftMax = arr[i];
            }
            total = total + Math.min(leftMax, right[i]) - arr[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trappingRainWaterOptimal(arr));
    }

    // The Optimimal
    // T- O(N)
    // T- O(1)

    int trappingRainWaterOptimal(int arr[]) {

        int total = 0, left = 0, right = arr.length - 1, leftMax = 0, rightMax = 0;

        while (left < right) {
            if (leftMax < arr[left])
                leftMax = arr[left];

            if (rightMax < arr[right])
                rightMax = arr[right];

            int min = 0;

            if (arr[left] < arr[right]) {
                min = arr[left];
            } else
                min = arr[right];

            total = total + Math.min(leftMax, rightMax) - min;

            if (arr[left] < arr[right]) {
                left++;
            } else
                right--;

        }
        return total;
    }
}