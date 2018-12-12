package solutions;

import common.FileUtils;

import java.util.Arrays;
import java.util.Stack;

public class DayFIve {
  static String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    var polymers = FileUtils.readLines("./puzzles/day5.txt")[0];

    var part1 = react("", polymers);
    System.out.println("Part 1: " + part1);

    var part2 = Arrays.stream(letters)
      .mapToInt(l -> react(l, polymers))
      .sorted()
      .findFirst();

    System.out.println("Part 2: " + part2);
    System.out.println("Done ine " + (System.currentTimeMillis() - startTime) + " ms");
  }

  private static int react(String letter, String data) {
    var stack = new Stack<String>();
    data = data.replace(letter.toLowerCase(), "");
    data = data.replace(letter.toUpperCase(), "");
    Arrays.stream(data.split(""))
      .forEach(c -> {
        if (stack.size() == 0) {
          stack.add(c);
        } else {
          var last = stack.peek();
          if (last.equals(c.toLowerCase()) && c.equals(c.toUpperCase()) || last.equals(c.toUpperCase()) && c.equals(c.toLowerCase())) {
            stack.pop();
          } else {
            stack.push(c);
          }
        }
      });
    return stack.size();
  }
}
