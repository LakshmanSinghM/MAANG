// https://leetcode.com/problems/palindrome-partitioning/description/

package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

    // optimization we do using the hasmap

    boolean isSafe(char[][] chess, int r, int c) {
        int row = r;
        int col = c;
        int n = chess.length;

        // upper diag
        while (row >= 0 && col >= 0) {
            if (chess[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        row = r;
        col = c;

        while (col >= 0) {
            if (chess[row][col] == 'Q')
                return false;
            col--;
        }

        row = r;
        col = c;

        while (row < n && col >= 0) {
            if (chess[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }

    void solve(char[][] chess, int n, int col, List<List<String>> ans) {

        if (col == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(chess[i]));
            }
            ans.add(list);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(chess, row, col)) {
                chess[row][col] = 'Q';
                solve(chess, n, col + 1, ans);
                chess[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] chess = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(chess[i], '.');
        }

        solve(chess, n, 0, ans);

        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new NQueen().solveNQueens(n));
    }
}