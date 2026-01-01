// https://leetcode.com/problems/power-of-two/description/

package coding_patterns.bit_manipulation.basic;

public class BasicProblems {
    void swapTwoNumbers(int a, int b) {
        System.out.println("Before swapping " + a + "   " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swapping " + a + "   " + b);
    }

    void checkTheIthBItSetOrNotUsingLeftShift(int n, int i) {
        ConvertNumbersDTOB object = new ConvertNumbersDTOB();
        System.out.println(object.convertDecimalToBinary(n));
        if ((n & (1 << i)) != 0) {
            System.out.println("Yes");
        } else
            System.out.println("No");
    }

    void checkTheIthBItSetOrNotUsingRightShift(int n, int i) {
        ConvertNumbersDTOB object = new ConvertNumbersDTOB();
        System.out.println(object.convertDecimalToBinary(n));

        if (((n >> i) & 1) == 1) {
            System.out.println("Yes");
        } else
            System.out.println("No");
    }

    void setTheIthBItUsingLeftShift(int n, int i) {
        ConvertNumbersDTOB object = new ConvertNumbersDTOB();
        System.out.println(object.convertDecimalToBinary(n));
        n = n | (1 << i);
        System.out.println(object.convertDecimalToBinary(n));
    }

    void clearTheIthBit(int n, int i) {
        ConvertNumbersDTOB object = new ConvertNumbersDTOB();
        System.out.println(object.convertDecimalToBinary(n));
        n = (n & (~(1 << i)));
        System.out.println(object.convertDecimalToBinary(n));
    }

    void toggleIthBit(int n, int i) {
        ConvertNumbersDTOB object = new ConvertNumbersDTOB();
        System.out.println(object.convertDecimalToBinary(n));
        n = (n ^ (1 << i));
        System.out.println(object.convertDecimalToBinary(n));
    }

    void removeTheLastBit(int n) {
        ConvertNumbersDTOB object = new ConvertNumbersDTOB();
        System.out.println(object.convertDecimalToBinary(n));
        n = (n & (n - 1));
        System.out.println(object.convertDecimalToBinary(n));
    }

    void checkIsNumberPowOfTwo(int n) {
        ConvertNumbersDTOB object = new ConvertNumbersDTOB();
        System.out.println(object.convertDecimalToBinary(n));
        boolean isPOfTwo = ((n & (n - 1)) == 0);
        System.out.println(isPOfTwo);
        System.out.println(object.convertDecimalToBinary(n));
    }

    void countTheOddNumberOfBits(int n) {
        // we can count both odd and even also

        ConvertNumbersDTOB object = new ConvertNumbersDTOB();
        System.out.println(object.convertDecimalToBinary(n));
        int cnt = 0;

        while (n > 0) {
            // if (n % 2 == 1)
            // cnt++;
            cnt += n & 1; // odd | even

            // n = n/2;
            n = n >> 1;
        }

        System.out.println("Total odd bits are " + cnt);
        System.out.println(object.convertDecimalToBinary(n));
    }

    void countTheNumberOfSetBits(int n) {

        ConvertNumbersDTOB object = new ConvertNumbersDTOB();
        System.out.println(object.convertDecimalToBinary(n));
        int cnt = 0;

        while (n != 0) {
            n = (n & (n - 1));
            cnt++;
        }

        System.out.println("Total set bits are " + cnt);
        System.out.println(object.convertDecimalToBinary(n));
    }

    void checkNumberEvenOrNot(int n) {
        // we can count both odd and even also
        ConvertNumbersDTOB object = new ConvertNumbersDTOB();
        System.out.println(object.convertDecimalToBinary(n));

        if ((n & 1) == 0) {
            System.out.println("Even Number");
        } else
            System.out.println("Odd Number");
    }

    public static void main(String[] args) {

        BasicProblems b = new BasicProblems();

        // b.swapTwoNumbers(5, 3);
        // b.setTheIthBItUsingLeftShift(13, 2);
        // b.checkTheIthBItSetOrNotUsingLeftShift(8, 2);
        // b.checkTheIthBItSetOrNotUsingRightShift(12, 2);

        // b.clearTheIthBit(15, 2);
        // b.toggleIthBit(12, 1);
        // b.removeTheLastBit(12);
        // b.checkIsNumberPowOfTwo(8);
        // b.countTheOddNumberOfBits(8);
        // b.countTheOddNumberOfBits(8);
        // b.countTheNumberOfSetBits(13);
        // b.checkNumberEvenOrNot(12);
    }
}