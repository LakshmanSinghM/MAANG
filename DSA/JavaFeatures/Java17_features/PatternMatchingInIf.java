package JavaFeatures.Java17_features;
public class PatternMatchingInIf {

  public static void main(String[] args) {
    Object o = "Hello";

    //before java 17
    // if (o instanceof String) {
    //   String s = (String) o;
    //   System.out.println(s.toUpperCase());
    // } else if (o instanceof Integer) {
    //   Integer s = (Integer) o;
    //   System.out.println(s + 10);
    // }

    // after java 17
    if (o instanceof String s) {
      System.out.println(s.toUpperCase());
    } else if (o instanceof Integer s) {
      System.out.println(s + 10);
    }
    // java.util.Objects

    // same thing we can write in the switch statements and also expression inside the case
  }
}