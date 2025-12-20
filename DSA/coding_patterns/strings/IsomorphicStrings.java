
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        int arrs[] = new int[256];
        int arrt[] = new int[256];

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (arrs[sc] != arrt[tc])
                return false;
            // not getting it so leaving for now
            // we are not checking the occurence we are checking the place of the occurence
            arrs[sc] = i + 1;
            arrt[tc] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        // Input:
        String s = "paper", t = "title";
        System.out.println(isIsomorphic(s, t));
    }
}
