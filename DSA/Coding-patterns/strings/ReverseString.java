import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseString {
    public static String reverseWords(String s) {

        String arr[] = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        System.out.println(Arrays.toString(arr));

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i != 0)
                sb.append(arr[i] + " ");
            else
                sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static String reverseWordsWithRegex(String s) {
        Pattern p = Pattern.compile("[A-Za-z0-9]+");
        Matcher m = p.matcher(s);
        String t = "";
        while (m.find()) {
            t = m.group() + " " + t;
        }

        return t.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" hello world "));
    }
}
