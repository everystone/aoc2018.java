package solutions;

import common.FileUtils;
import common.Tools;

import java.util.Arrays;


public class DayTwo {

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

    var results = Arrays.stream(lines)
      .filter(line1 -> Arrays.stream(lines).anyMatch(line2 -> Tools.getDiff(line1, line2) == 1))
      .reduce("", Tools::aWithoutB);

    System.out.println("Part 2: " + results); // Part 2: revtaubfniyhsgxdoajwkqilp
  }
}



// compare every line with each other, and find the two that differs by 1 character.
//    var results = Arrays.stream(lines)
//      .filter(line1 -> Arrays.stream(lines).anyMatch(line2 -> getDiff(line1, line2) == 1))
//      .map(s -> { List<String> x = new ArrayList(); x.add(s); return x;})
//      .reduce(new ArrayList<String>(), (a, b) -> {
//        System.out.println();
//        a.addAll(b);
//      });

// answer: revtaubfniyhsgxdoajwkqilp
//         revtaubfniyhsgxdoajwkqilp
