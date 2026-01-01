// https://leetcode.com/problems/divide-two-integers/

package coding_patterns.bit_manipulation.basic;

public class DivideToNumWithoutDMOperator {

    int divideTwoNumberWithoutUsingMulAndDevideOperator(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;

        int sign = 1;

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        if ((dividend > 0 && divisor < 0) || (divisor > 0 && dividend < 0))
            sign = -1;

        long num = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int cnt = 0;
        long ans = 0;

        while (num >= d) {

            cnt = 0;
            while (num >= (d << (cnt + 1))) {
                cnt++;
            }
            ans = ans + (1 << cnt);
            num = num - (d << cnt);
        }
        return sign < 0 ? (int) ans * -1 : (int) ans;
    }

    public static void main(String[] args) {
        DivideToNumWithoutDMOperator o = new DivideToNumWithoutDMOperator();
        System.out.println(o.divideTwoNumberWithoutUsingMulAndDevideOperator(22, 3));
    }
}