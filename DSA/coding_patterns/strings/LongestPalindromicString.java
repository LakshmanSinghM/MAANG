// https://leetcode.com/problems/longest-palindromic-substring/

public class LongestPalindromicString {

    static String palindrom(int i, int j, String s) {
        // a
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    };

    static String longestPalindromString(String s) {
        int max = 0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            String even = palindrom(i, i + 1, s);
            
            if (max < even.length()) {
                max = even.length();
                str = even;
            }
            String odd = palindrom(i, i, s);
            if (max < odd.length()) {
                max = odd.length();
                str = odd;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromString("abba"));
    }
}
