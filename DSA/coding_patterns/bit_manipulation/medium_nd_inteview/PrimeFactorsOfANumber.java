// https://takeuforward.org/plus/dsa/problems/prime-factorisation-of-a-number

package coding_patterns.bit_manipulation.medium_nd_inteview;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsOfANumber {

    // avoid built in sqrt functin it takes some complexity

    boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // can be improved
    List<Integer> primeFactorOfANumber(int n) {
        List<Integer> list = new ArrayList<>();
        boolean numberPrimeItself = true;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            int x = n;
            while (x % i == 0) {
                if (isPrime(i)) {
                    list.add(i);
                }
                numberPrimeItself = false;
                x = x / i;
            }
        }
        if (numberPrimeItself) {
            list.add(n);
        }
        return list;
    }

    // { 2, 3, 4, 5, 6 };
    List<List<Integer>> primeFactors(int arr[]) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = primeFactorOfANumber(arr[i]);
            if (!list.isEmpty())
                lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 12, 18 };
        // int arr[] = { 2, 3, 4, 5, 6 };

        // Input : queries = [2, 3, 4, 5, 6]
        // Output : [ [2], [3], [2, 2], [5], [2, 3] ]

        // Input : queries = [7, 12, 18]
        // Output : [ [7], [2, 2, 3], [2, 3, 3] ]

        PrimeFactorsOfANumber primeFactorsOfANumber = new PrimeFactorsOfANumber();
        System.out.println(primeFactorsOfANumber.primeFactors(arr));
    }
}
