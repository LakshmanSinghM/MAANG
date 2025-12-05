
// https://leetcode.com/problems/search-a-2d-matrix/description/

import java.util.Arrays;

public class SearchIn2DArray {
    public static boolean search(int arr[], int ele) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == ele)
                return true;
            if (ele > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // [[-10,-9],[-7,-5],[-4,-3]]
        int row = matrix.length;
        int col = matrix[0].length;
        int lastCol = col - 1;
        for (int i = 0; i < matrix.length; i++) {

            System.out.println(Arrays.toString(matrix[i]));

            if (col >= 2) {
                if (target >= matrix[i][0] && target <= matrix[i][lastCol])
                    return search(matrix[i], target);
            } else {
                boolean found = search(matrix[i], target);
                if (found)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;
        System.out.println(searchMatrix(arr, target));
    }
}
