package solutions;

import common.FileUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


// revtoubfniyhzsgxdowjwkqglp


public class DayTwo {
  private long charCount(String c, String[] src) {
    return Arrays.stream(src).filter(l -> l.equals(c)).count();
  }
  public static void main(String[] args) {
    String[] lines = FileUtils.readLines("./puzzles/day2.txt");

    // count number of line that have exactly 2 character duplicates.
    long twoCount = Arrays.stream(lines).filter(line -> line.chars()
      .anyMatch(c1 -> line.chars()
        .filter(c2 -> c1 == c2)
        .count() == 2))
      .count();

    long threeCount = Arrays.stream(lines).filter(line -> line.chars()
      .anyMatch(c1 -> line.chars()
        .filter(c2 -> c1 == c2)
        .count() == 3))
      .count();

    long part1 = twoCount * threeCount;
    System.out.println("Part 1: " + part1);

    // compare every line with each other, and find the two that differs by 1 character.
    List<String> results = Arrays.stream(lines)
      .filter(line1 -> Arrays.stream(lines)
      .anyMatch(line2 -> getDiff(line1, line2) == 1))
      .collect(Collectors.toList());


    String part2 = "";
    String a = results.get(0);
    String b = results.get(1);
    for(int i=0;i<a.length();i++){
      if (b.charAt(i) == a.charAt(i)) {
        part2 += a.charAt(i);
      }
    }
    System.out.println("Part 2: " + part2);
}

  // returns number of differences between a and b
  static long getDiff(String a, String b) {
    return IntStream.range(0, a.length())
      .filter(i -> a.charAt(i) != b.charAt(i))
      .count();
  }
}
