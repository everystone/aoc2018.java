package solutions;

import common.FileUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.function.IntConsumer;

class Frequencer implements IntConsumer {
  int firstDuplicate = 0;
  private int total = 0;
  private HashSet<Integer> frequencies = new HashSet<>();

  @Override
  public void accept(int value) {
    total += value;
    if (frequencies.contains(total)) {
      //System.out.println("Part 2: " + total);
      if (firstDuplicate == 0) {
        firstDuplicate = total;
      }
    }
    frequencies.add(total);
  }
  void combine(Frequencer other) {
    total += other.total;
  }
}

// https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html#collect
public class DayOne {

  public static void main(String[] args) {
    String[] lines = FileUtils.readLines("./puzzles/day1.txt");

    int part1 = Arrays.stream(lines)
      .mapToInt(Integer::parseInt) // e -> Integer.parseInt(e)
      .sum();

    System.out.println("Part 1: " + part1);


    int part2 = Collections.nCopies(141, lines)
      .stream()
      .flatMap(Arrays::stream)
      .mapToInt(Integer::parseInt)
      .collect(Frequencer::new, Frequencer::accept, Frequencer::combine)
      .firstDuplicate;

    System.out.println("Part 2: " + part2);
//    HashSet<Integer> frequencies = new HashSet<>();
//    Collections.nCopies(1000, lines)
//      .stream()
//      .flatMap(Arrays::stream)
//      .mapToInt(Integer::parseInt)
//      .reduce(0, (a, b) -> {
//        int sum = a+b;
//        System.out.println(sum);
//        if (frequencies.contains(sum)) {
//          System.out.println("Part 2: " + sum);
//        }
//        frequencies.add(sum);
//        return sum;
//      });
  }

}
