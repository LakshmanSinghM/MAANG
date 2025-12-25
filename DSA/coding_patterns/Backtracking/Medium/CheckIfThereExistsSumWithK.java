// https://takeuforward.org/plus/dsa/problems/check-if-there-exists-a-subsequence-with-sum-k

package medium;

public class CheckIfThereExistsSumWithK {

    boolean checkIfThereExistsSumWithK(int sum, int target, int i, int n, int arr[]) {
        if (i >= n || sum > target || sum < 0) {
            if (sum == target)
                return true;
            else
                return false;
        }
        sum += arr[i];
        if (checkIfThereExistsSumWithK(sum, target, i + 1, n, arr) == true)
            return true;
        sum -= arr[i];
        if (checkIfThereExistsSumWithK(sum, target, i + 1, n, arr) == true)
            return true;

        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };
        int target = 8;
        System.out.println(new CheckIfThereExistsSumWithK().checkIfThereExistsSumWithK(0, target, 0, arr.length, arr));
    }
}