
public class RotateString {

    public static boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < s.length(); i++) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            System.out.println(sb.toString());
            if (sb.toString().equals(goal))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcde", goal = "abced";
        System.out.println(rotateString(s, goal));
    }
}
