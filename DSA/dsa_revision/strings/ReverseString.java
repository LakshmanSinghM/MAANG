package dsa_revision.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";
        
        // StringBuilder sb = new StringBuilder();

        // for (int i = s.length() - 1; i >= 0; i--) {
        //     sb.append(s.charAt(i));
        // }
        // System.out.println("\n\nReverse string is " + sb.toString());

        //using the java 8

        List<Character> chars = s.chars().mapToObj(c->(char)c).collect(Collectors.toList());

        Collections.reverse(chars);

        // just join here by collectos.joning .collect(Collectors.joining())
        System.out.println("hekrhekhfj"+chars);

        // System.out.println("\n\n Using java 8  "+chars);
        // System.out.println("\n\n Using java 8  ");

    }
}
