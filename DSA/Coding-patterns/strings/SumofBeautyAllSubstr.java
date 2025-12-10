import java.util.HashMap;

public class SumofBeautyAllSubstr {

    public static int beautySum(String s) {
        int cnt = 0; 

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int val : map.values()) {
                    if (min > val)
                        min = val;
                    if (max < val)
                        max = val;
                }

                // if (map.size() >= 2) {
                // System.out.println(map + " " + min + " " + max + " " + (max - min));
                cnt = cnt + (max - min);
                // }
                // System.out.println
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // System.out.println("Okay");
        System.out.println(beautySum("Okay"));
    }
}