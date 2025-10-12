 import java.util.*;
import java.util.stream.Collectors;

public class FindSecondHighestNum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 6, 5);
       List<Integer> listsh =
         list.stream().sorted((a, b) -> b - a).collect(Collectors.toList());
        listsh.forEach(System.out::println);
    }
}
