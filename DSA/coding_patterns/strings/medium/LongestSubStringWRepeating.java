// https://leetcode.com/problems/longest-substring-without-repeating-characters/

package medium;

import java.util.HashMap;

public class LongestSubStringWRepeating {

    public static int lengthOfLongestSubstring(String s) {

        // String str = "";

        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, max = 0;

        for (r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c) && map.get(c) >= l) {
                l = map.get(c) + 1;
            }

            // if asks string also
            // if ((r - l + 1) > max) {
            //     str = s.substring(l, r + 1);
            //     max = r - l + 1;
            // }

            max = Math.max(max, (r - l + 1));
            map.put(c, r);
        }

        // System.out.println(str);

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

        // follow up print the string;
    }
}