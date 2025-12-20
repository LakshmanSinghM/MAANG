public class AtoI {

    public static int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        long num = 0;

        if (s.startsWith("-")) {
            sign = -1;
            s = s.substring(1);
        } else if (s.startsWith("+")) {
            s = s.substring(1);
            sign = 1;
        }

        if (s.isEmpty())
            return 0;

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                break;

            num = num * 10 + (s.charAt(i) - '0');

            if (sign * num >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sign * num <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) num * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-+12"));
        System.out.println(myAtoi("-12"));
    }
}