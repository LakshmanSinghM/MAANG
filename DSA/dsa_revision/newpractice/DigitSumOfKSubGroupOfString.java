package dsa_revision.newpractice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class DigitSumOfKSubGroupOfString {

    private String sumString(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum = sum + (c - '0');
        }
        return sum + "";
    }

    String findStr(int i, int j, String s) {
        if (s.length() >= j) {
            return s.substring(i, j);
        }
        return s.substring(i);
    }

    public String digitSum(String s, int k) {

       // we can user stringbuilder to optimize this furthur performancewise          
        while (s.length() > k) {
            String sum = "";
            for (int i = 0; i < s.length(); i = i + k) {
                String temp = findStr(i, i + k, s);
                sum = sum + sumString(temp);
            }
            s = sum;
        }
        return s;
    }
}