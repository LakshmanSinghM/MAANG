// https://takeuforward.org/plus/dsa/problems/prime-factorisation-of-a-number

package coding_patterns.bit_manipulation.medium_nd_inteview;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizationOfANumber {

    int[] preComputeBlackBox(int n) {
        int arr[] = new int[n + 1];

        for (int i = 0; i < n; i++)
            arr[i] = i;

        for (int i = 2; i * i <= n; i++) {
            if (arr[i] == i) {
                for (int j = i * i; j <= n; j = j + i) {
                    if (arr[j] == j)
                        arr[j] = i;
                }
            }
        }
        return arr;
    }

    List<List<Integer>> primeFactors(int arr[]) {
        List<List<Integer>> lists = new ArrayList<>();
        int blackBox[] = preComputeBlackBox(100000 - 1);
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            List<Integer> list = new ArrayList<>();
            if (blackBox[n] == n) {
                list.add(n);
            } else {
                while (n != 1) {
                    list.add(blackBox[n]);
                    n = n / blackBox[n];
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {

        // Input : queries = [2, 3, 4, 5, 6]
        // Output : [ [2], [3], [2, 2], [5], [2, 3] ]

        int arr[] = { 2, 3, 4, 5, 6 };

        PrimeFactorizationOfANumber primeFactorizationOfANumber = new PrimeFactorizationOfANumber();
        System.out.println(primeFactorizationOfANumber.primeFactors(arr));

    }
}