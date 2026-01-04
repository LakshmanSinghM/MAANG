// https://leetcode.com/problems/powx-n/

package coding_patterns.bit_manipulation.medium_nd_inteview;

public class PowerNOfX {
    // Optimal not working now
    public double myPow(double x, int num) {
        double ans = 1;
        // int num = n;
        // 1/2 = 0.5
        // n = 2

        // x= 2.00000
        // n =-2
        // Output
        // 0.25000

        long n = num;

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * x;
                n = n - 1;
            } else {
                x = (x * x);
                n = n / 2;
            }
        }

        // if(num<0) ans= 1.0/ans;

        return ans;
    }

    public static void main(String[] args) {

    }

    // Brute force

    // public double pow(int i, int n, double x, double calx) {
    // if (i == n)
    // return calx;

    // System.out.println("Calculated is " + (calx * x));
    // return pow(i + 1, n, x, calx * x);
    // }

    // public double myPow(double x, int n) {

    // if (n < 0) {
    // double val = pow(1, Math.abs(n), x, x);
    // System.out.println("Val is " + val);
    // return (1 / val);
    // }
    // double val = pow(1, n, x, x);
    // return val;
    // }
}
