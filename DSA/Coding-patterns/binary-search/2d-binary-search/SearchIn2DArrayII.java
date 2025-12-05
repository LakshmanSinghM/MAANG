// https://leetcode.com/problems/search-a-2d-matrix-ii/description/

public class SearchIn2DArrayII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0;
        int c = cols - 1;

        while (r < rows && c < cols) {

            if (target >= matrix[r][0] && target <= matrix[r][c]) {
                if (matrix[r][c] == target)
                    return true;
                c--;
            } else
                r++;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        int target = 5;
        System.out.println(searchMatrix(arr, target));
    }
}
