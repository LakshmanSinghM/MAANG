
// https://leetcode.com/problems/find-a-peak-element-ii

import java.util.Arrays;

public class FindPeekEleIn2d {

    // brute force
    // public int[] findPeakGrid(int[][] nums) {
    //     int cols = nums[0].length-1;
    //     int rows = nums.length-1;

    //     for (int i = 0; i <= rows; i++) {
    //         for (int j = 0; j <= cols; j++) {
    //             int ele = nums[i][j];
    //             boolean found = true;
    //             if (i != 0) {
    //              if(!(ele>nums[i-1][j])){
    //                 found = false;
    //              } 
    //             }
    //             if(j!=0){
    //                 if(!(ele>nums[i][j-1])){
    //                  found = false;
    //                 }
    //             }
    //             if(j!=cols){
    //                  if(!(ele>nums[i][j+1])){
    //                  found = false;
    //                 }
    //             }
    //             if(i!=rows){
    //                  if(!(ele>nums[i+1][j])){
    //                  found = false;
    //                 }
    //             }
               
    //            if(found) return new int[]{i,j};
    //         }
    //     }
    //     return new int[]{-1,-1};
    // }

    private static int[] findMax(int[][] nums, int rows, int col) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i <= rows; i++) {
            if (nums[i][col] > max) {
                max = nums[i][col];
                index = i;
            }
        }
        return new int[] { index, max };
    }

    public static int[] findPeakGrid(int[][] nums) {
        int cols = nums[0].length - 1;
        int rows = nums.length - 1;
        int low = 0, high = cols, j = cols;

        while (low <= high) {
            int mid = (low + high) / 2;
            int rowIndex = findMax(nums, rows, mid)[0];
            int max = findMax(nums, rows, mid)[1];
            int leftMax = mid - 1 >= 0 ? nums[rowIndex][mid - 1] : -1;
            int rightMax = mid + 1 <= cols ? nums[rowIndex][mid + 1] : -1;
            
            if (max > leftMax && max > rightMax)
                return new int[] { rowIndex, mid };
            if (leftMax > max)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        // Input: mat = [[1,4],[3,2]]
        // Output: [0,1]
        int arr[][] = { { 1, 4 },
                        { 3, 2 } };

        System.out.println(Arrays.toString(findPeakGrid(arr)));
    }
}
