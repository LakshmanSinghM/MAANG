// https://takeuforward.org/plus/dsa/problems/rat-in-a-maze

package hard;

import java.util.ArrayList;
import java.util.List;

public class RateInAMaze {

    int[][] giveMeDirections(int row, int col) {
        int arr[][] = { { row - 1, col, 'U' }, { row, col + 1, 'R' }, { row + 1, col, 'D' }, { row, col - 1, 'L' } };
        return arr;
    }

    void solveMaz(List<String> list, int row, int col, int[][] grid, String move, int n) {

        if (row >= n-1 && col >= n-1) {
            list.add(move);
            return;
        }

        int direction[][] = giveMeDirections(row, col);

        for (int i = 0; i < direction.length; i++) {

            int newRow = direction[i][0];
            int newCol = direction[i][1];

            if (newCol >= 0 && newRow >= 0 && newCol < n && newRow < n && grid[newRow][newCol] != 0
                    && grid[newRow][newCol] != '$') {
                char c = (char) direction[i][2];
                int temp = grid[newRow][newCol];
                grid[newRow][newCol] = '$';
                solveMaz(list, newRow, newCol, grid, move + c, n);
                grid[newRow][newCol] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int maz[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 0 },
                { 1, 1, 0, 0 },
                { 1, 1, 1, 1 },
        };

        List<String> list = new ArrayList<>();

        new RateInAMaze().solveMaz(list, 0, 0, maz, "D", maz.length);
        System.out.println(list);
    }
}