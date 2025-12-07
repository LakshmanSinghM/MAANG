import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // D C X X I
        // 1100 + 1010 + 100 + 1 + 4
        // M C M X C I V

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cVal = map.get(c);
            System.out.println(s.charAt(i) + " " + cVal);

            if (i >= 1) {
                // System.out.println(s.charAt(i - 1) + " ");
                int pVal = map.get(s.charAt(i - 1));
                if (pVal < cVal) {
                    num -= pVal;
                    cVal -= pVal;
                    num += cVal;
                } else
                    num += cVal;
            } else
                num += cVal;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
