public class MaxDepthOfTheBracket {
    public static int maxDepth(String s) {
        int open = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                open++;
            if (open > max)
                max = open;
            if (s.charAt(i) == ')')
                open--;

        }
        return max;
    }

    public static void main(String[] args) {
        // Input:
        String s = "(1+(2*3)+((8)/4))+1";

        // Output: 3
        System.out.println(maxDepth(s));
    }
}
