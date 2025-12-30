package coding_patterns.bit_manipulation.basic;

public class ConvertNumbersDTOB {

    // 1 0 1 0
    // 8 4 2 1

    // (2*0)0 = 0
    // (2*1)1 = 2
    // (2*1)3 = 8

    int convertBinaryToDecimal(String s) {
        int i = s.length() - 1;
        int pow = 1;
        int num = 0;

        while (i >= 0) {
            if (s.charAt(i) - '0' == 1) {
                num = num + pow;
            }
            pow = pow * 2;
            i--;
        }
        return num;
    }

    String convertDecimalToBinary(int n) {
        String s = "";
        while (n > 0) {
            s = (n % 2) + s;
            n = n / 2;
        }
        return s;
    }

    public static void main(String[] args) {
        var object = new ConvertNumbersDTOB();
        System.out.println(object.convertBinaryToDecimal("101"));
        System.out.println(object.convertDecimalToBinary(12));
    }
}