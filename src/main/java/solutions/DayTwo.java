package solutions;


import common.FileUtils;

import java.util.Arrays;


// revtoubfniyhzsgxdowjwkqglp
class BoxID {
  public boolean hasTwo;
  public boolean hasThree;
  private String[] letters;
  BoxID(String str) {
    this.letters = str.split("");
    this.hasTwo = Arrays.stream(letters)
      .anyMatch(c -> count(c) == 2);

    this.hasThree = Arrays.stream(letters)
      .anyMatch(c -> count(c) == 3);
  }
  private long count(String c) {
    return Arrays.stream(this.letters).filter(l -> l.equals(c)).count();
  }
}

public class DayTwo {
  private long charCount(String c, String[] src) {
    return Arrays.stream(src).filter(l -> l.equals(c)).count();
  }
  public static void main(String[] args) {
    String[] lines = FileUtils.ReadLines("./puzzles/day2.txt");

    long twoCount = Arrays.stream(lines)
      .map(BoxID::new)
      .filter(l -> l.hasTwo)
      .count();

    long threeCount = Arrays.stream(lines)
      .map(BoxID::new)
      .filter(i -> i.hasThree)
      .count();

    long part1 = twoCount * threeCount;
    System.out.println("Part 1: " + part1);
  }
}
