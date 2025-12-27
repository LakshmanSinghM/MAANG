// https://leetcode.com/problems/word-search/description/

// dekhke kiya hai bhai need revisionn to undertand

package hard;

public class WordSearch {

    int[][] forIndexes(int i, int j) {
        return new int[][] { { i, j - 1 }, { i, j + 1 }, { i - 1, j }, { i + 1, j } };
    }

    boolean find(int i, int j, char[][] board, String word, int m, int n, int index) {

        if (index == word.length())
            return true;

        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '$')
            return false;

        char c = board[i][j];

        int arr[][] = forIndexes(i, j);

        if (board[i][j] == word.charAt(index)) {
            for (int left = 0; left < arr.length; left++) {
                int newRow = arr[left][0];
                int newCol = arr[left][1];
                if (find(newRow, newCol, board, word, m, n, index + 1))
                    return true;
            }
        }
        board[i][j] = c;

        return false;
    }

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][i] == word.charAt(0) && find(i, j, board, word, m, n, 0))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][] {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' } };

        String word = "ABCCED";
        System.out.println(new WordSearch().exist(arr, word));
    }
}