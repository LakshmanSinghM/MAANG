// https://takeuforward.org/plus/dsa/problems/divisors-of-a-number

package coding_patterns.bit_manipulation.medium_nd_inteview;

import java.util.ArrayList;
import java.util.List;

public class DivisorsOfANumber {

    List<Integer> findAllDivisorsOfNumber(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i)
                    list.add(n / i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 6;
        DivisorsOfANumber divisorsOfANumber = new DivisorsOfANumber();
        System.out.println(divisorsOfANumber.findAllDivisorsOfNumber(n));
    }

    // 1 × 36 = 36
    // 2 × 18 = 36
    // 3 × 12 = 36 / 3 = 12
    // 4 × 9 = 36
    // 6 × 6 = 36 / 6 = 6

    // 9 × 4 = 36
    // 12 × 3 = 36 / 12
    // 18 × 2 = 36
    // 36 × 1 = 36
}
