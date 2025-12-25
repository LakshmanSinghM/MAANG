// https://www.naukri.com/code360/problems/binary-strings-with-no-consecutive-1s_893001
package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringWihoutCons1 {
    static void generate(List<String> list, int n, String sb) {
        if (sb.length() == n) {
            list.add(sb);
            return;
        }

        if (sb.length() > n)
            return;

        generate(list, n, sb + '0');
        if (sb.length() >= 1 && sb.charAt(sb.length() - 1) != '1')
            generate(list, n, sb + '1');
        else if (sb.length() == 0)
            generate(list, n, sb + '1');

    }

    public static List<String> generateString(int n) {
        List<String> list = new ArrayList<>();
        generate(list, n, "");
        return list;
        // Write your code here.
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateString(n));
    }
}