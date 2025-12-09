import java.util.HashMap;

public class CountNumberSubstr {

    // private static int countNumberSubstr(String s, int k) {
    // int cnt = 0;

    // for (int i = 0; i < s.length(); i++) {
    // Set<Character> set = new HashSet<>();

    // for (int j = i; j < s.length(); j++) {
    // set.add(s.charAt(j));
    // if (set.size() == k)
    // cnt++;
    // if (set.size() > k)
    // break;
    // }
    // }
    // return cnt;
    // }

    private static int countNumberSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int cnt = 0, l = 0, r = 0;

        for (r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);

                if (map.getOrDefault(s.charAt(l), 0) == 0)
                    map.remove(s.charAt(l));
                l++;
            }

            cnt = cnt + (r - l + 1);
        }
        return cnt;
    }

    private static int countNumberSubstring(String s, int k) {
        // this is the formula to get the total
        // pending to test
        int a = countNumberSubstr(s, k);
        int b = countNumberSubstr(s, k - 1);
        System.out.println(a + "   " + b);

        return a - b;
    }

    public static void main(String[] args) {
        System.out.println(countNumberSubstring("pqpqs", 2));
    }
}
