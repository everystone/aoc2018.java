package solutions;

import common.FileUtils;
import common.Step;
import common.StepContainer;

import java.util.Arrays;

import static java.util.stream.Collectors.groupingBy;


public class DaySeven {

  public static void main(String[] args) {
    String[] lines = FileUtils.readLines("./puzzles/day7.txt");

    // TODO: loop entire list for every step to create rules.

    var steps = Arrays.stream(lines)
      .map(Step::new)
      .collect(groupingBy(step -> step.A));
    // steps: {A=[B, C], C=[B], D=[F, H, O, C, P], E=[C, W, Z, O, S], F=[E], G=[T], H=[R, Z, C], I=[C, U, Z]

    steps.entrySet().stream()
    .map(StepContainer::new)
      .sorted()
      //.map(e -> e.Value)
      //.map(Object::toString)
      //.collect(Collectors.joining("")); // ADFECGNPHJIKLMVROQUSTXYZW
   .forEach(System.out::println);


  }
}
