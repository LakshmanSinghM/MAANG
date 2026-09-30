// https://leetcode.com/problems/jump-game-ii/description/

package medium;

public class JumpII {

    public int jump(int[] nums) {
        return jumpHelper(nums, 0, 0);
    }

    // Time limit exceeded
    public int jumpHelper(int arr[], int index, int jump) {

        if (index >= arr.length - 1)
            return jump;

        int mini = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[index]; i++) {
            mini = Math.min(mini, jumpHelper(arr, index + i, jump + 1));
        }
        return mini;
    }

    // Memory limit exceeded

    int jump(int arr[], int index, int jump, int dp[][]) {
        if (index >= arr.length - 1)
            return jump;

        if (dp[index][jump] != -1)
            return dp[index][jump];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= arr[index]; i++) {
            min = Math.min(min, jump(arr, index + i, jump + 1, dp));
        }

        dp[index][jump] = min;

        return min;
    }

    // public int jump(int[] nums) {
    // int n = nums.length;
    // int dp[][] = new int[n + 1][n + 1];
    // for (int i = 0; i <= n; i++) {
    // for (int j = 0; j < n; j++)
    // dp[i][j] = -1;
    // }
    // return jump(nums, 0, 0, dp);
    // }
}