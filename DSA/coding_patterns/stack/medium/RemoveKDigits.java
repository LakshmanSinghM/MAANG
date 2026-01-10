// https://leetcode.com/problems/remove-k-digits/

package coding_patterns.stack.medium;

import java.util.LinkedList;
import java.util.List;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        List<Integer> stack = new LinkedList<>();
        if (num.length() == k)
            return "0";

        // "26221184202197273"
        // "3356221184202197273" 18

        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            while (!stack.isEmpty() && stack.getLast() > n && k > 0) {
                stack.removeLast();
                k--;
            }
            stack.add(n);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.removeLast();
            k--;
        }

        StringBuilder temp = new StringBuilder();
        boolean isZeroSkipped = false;

        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i) != 0) {
                isZeroSkipped = true;
            }
            if (isZeroSkipped)
                temp.append(stack.get(i));
        }

        return temp.toString().length() == 0 ? "0" : temp.toString();
    }

    public static void main(String[] args) {

    }
}