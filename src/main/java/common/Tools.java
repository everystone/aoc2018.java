package common;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tools {

  // returns matching characters in A and B
  public static String aWithoutB(String a, String b) {
    if (a.length() == 0) {
      return b;
    }
    return IntStream.range(0, a.length())
      .filter(i -> a.charAt(i) == b.charAt(i))
      .mapToObj(a::charAt)
      .map(Object::toString)
      .collect(Collectors.joining(""));
  }
  // returns number of differences between a and b
  public static long getDiff(String a, String b) {
    return IntStream.range(0, a.length())
      .filter(i -> a.charAt(i) != b.charAt(i))
      .count();
  }
}
