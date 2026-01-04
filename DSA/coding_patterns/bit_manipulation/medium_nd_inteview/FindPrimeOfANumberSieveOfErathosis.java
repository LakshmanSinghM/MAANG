// https://takeuforward.org/plus/dsa/problems/count-primes-in-range-l-to-r
// https://leetcode.com/problems/count-primes/description/

package coding_patterns.bit_manipulation.medium_nd_inteview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPrimeOfANumberSieveOfErathosis {

    int[] preComputeBlackBox(int n) {
        int arr[] = new int[n + 1];
        Arrays.fill(arr, 1);

        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j = j + i) {
                arr[j] = 0;
            }
        }
        return arr;
    }

    int countPrimeinRange(int arr[], int left, int right) {
        int cnt = 0;
        if (left < 2) {
            left = 2;
        }
        if (right<2) {
            right = 2;
        }
        for (int i = left; i <= right; i++) {
            if (arr[i] == 1)
                cnt++;
        }
        return cnt;
    }

    List<Integer> findPrimesBetbeenRange(int arr[][]) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int left = arr[i][0];
            int right = arr[i][1];
            int computedArray[] = preComputeBlackBox(right);
            int primeCount = countPrimeinRange(computedArray, left, right);
            list.add(primeCount);
        }
        return list;
    }

    public static void main(String[] args) {
        // int arr[][] = { { 2, 5 }, { 4, 7 } };
        int arr[][] = { { 1, 7 }, { 3, 7 } };
        FindPrimeOfANumberSieveOfErathosis findPrimeOfANumberSieveOfErathosis = new FindPrimeOfANumberSieveOfErathosis();

        System.out.println(findPrimeOfANumberSieveOfErathosis.findPrimesBetbeenRange(arr));
    }
}


// 2 × 2
// 2 × 3
// 2 × 4
// 2 × 5
// .
// .

// 3 × 2
// 3 × 3
// 3 × 4
// 3 × 5
// .
// .

// 5 × 2
// 5 × 3
// 5 × 4
// 5 × 5

// 7 × 2 ✓
// 7 × 3 ✓
// 7 × 4 ✓
// 7 × 5 ✓
// 7 × 6 ✓
// 7 × 7

// = 42




    // leetcode 

    
    // int[] preComputeBlackBox(int n) {
    //     int arr[] = new int[n];
    //     Arrays.fill(arr, 1);

    //     for (int i = 2; i * i <n; i++) {
    //         for (int j = i * i; j <n; j = j + i) {
    //             arr[j] = 0;
    //         }
    //     }
    //     return arr;
    // }

    // int countPrimeinRange(int arr[], int left, int right) {
    //     int cnt = 0;
    //     if (left < 2) {
    //         left = 2;
    //     }

    //     if (right<=2) {
    //        return 0;
    //     }

    //     for (int i = left; i<right; i++) {
    //         if (arr[i] == 1)
    //             cnt++;
    //     }
    //     return cnt;
    // }

    // public int countPrimes(int n) {
    //     int arr[] = preComputeBlackBox(n);
    //     return countPrimeinRange(arr, 2, n);
    // }