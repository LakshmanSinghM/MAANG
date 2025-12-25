// https://takeuforward.org/plus/dsa/problems/subsets-i

package medium;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumI {
    void subSetSum(List<Integer> list, int i, int n, int arr[], int sum) {

        if (i == n) {
            list.add(sum);
            return;
        }

        sum += arr[i];
        subSetSum(list, i + 1, n, arr, sum);
        sum -= arr[i];
        subSetSum(list, i + 1, n, arr, sum);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3};
        List<Integer> list = new ArrayList<>();
        new SubsetSumI().subSetSum(list, 0, arr.length, arr, 0);

        System.out.println(list);
    }
}
