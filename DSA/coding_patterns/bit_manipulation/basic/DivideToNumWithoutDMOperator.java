// https://leetcode.com/problems/divide-two-integers/

package coding_patterns.bit_manipulation.basic;

public class DivideToNumWithoutDMOperator {

    int divideTwoNumberWithoutUsingMulAndDevideOperator(int dividend, int divisor) {

        if (dividend == divisor)
            return 1;

        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (divisor > 0 && dividend < 0))
            sign = -1;

        int num = Math.abs(dividend);
        int d = Math.abs(divisor);
        int cnt = 0;
        int ans = 0;

        // needs some clarification in this solution
        // not solved yet fully
        System.out.println(1 << 2);

        while (num >= d) {

            cnt = 0;
            while (num >= (d << (cnt + 1))) {
                System.out.println(d << (cnt + 1));
                cnt++;
            }
            ans = ans + (1 << cnt);
            num = num - (d << cnt);
        }

        if (ans == Integer.MAX_VALUE && sign == 1) {
            return Integer.MAX_VALUE;
        }
        if (ans == Integer.MAX_VALUE && sign == -1) {
            return Integer.MIN_VALUE;
        }
        return ans;
    }

    public static void main(String[] args) {
        DivideToNumWithoutDMOperator o = new DivideToNumWithoutDMOperator();
        System.out.println(o.divideTwoNumberWithoutUsingMulAndDevideOperator(22, 3));
    }
}