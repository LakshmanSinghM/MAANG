public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        int arr[] = new int[256];
        int arr1[] = new int[256];

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char st = t.charAt(i);
            arr[sc]++;
            arr1[st]++;

        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (arr[c] != arr1[c])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}