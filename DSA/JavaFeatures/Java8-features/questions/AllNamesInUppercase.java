import java.util.*;

public class AllNamesInUppercase {
    public static void main(String[] args) { 
        List<String> strList = Arrays.asList("okay", "hI","HelLO");
        List<String> list = strList.stream().map(String::upperCase).collect(Collectors::toList);
        System.out.println(list); 
       }
}
