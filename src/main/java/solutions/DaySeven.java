package solutions;

import common.FileUtils;

import java.util.Arrays;
import java.util.stream.Collectors;


class Step implements Comparable {
  char A;
  char B;
  Step(String line) {
    A = line.charAt(5);
    B = line.charAt(36);
  }

  @Override
  public String toString() {
    return String.format("%s -> %s", Character.toString(A), Character.toString(B));
  }

  @Override
  public int compareTo(Object o) {
    Step other = (Step)o;
    if (other.A == this.B) {
      return -1;
    }
    if (other.B == this.A) {
      return 1;
    }
    return 0;
  }
}
public class DaySeven {



  public static void main(String[] args) {
    String[] lines = FileUtils.readLines("./puzzles/day7.txt");


    // TODO: loop entiry thing for every step to create rules.
    var result = Arrays.stream(lines)
      .map(Step::new)
      .sorted()
      .map(s -> s.A)
      .map(Object::toString)
      .collect(Collectors.joining(""));
    System.out.println(result);


  }
}
