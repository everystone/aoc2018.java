package common;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StepContainer implements Comparable<StepContainer> {
  Character Value;
  private List<Character> Waiting;
  public StepContainer(Map.Entry<Character, List<Step>> val) {
    Value = val.getKey();
    Waiting = val.getValue().stream().map(e -> e.B).collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return String.format("%s before %s", Character.toString(Value), Waiting.stream().map(Object::toString).collect(Collectors.joining(",")));
  }

  @Override
  public int compareTo(StepContainer other) {
   //System.out.println("comparing " + this.Value + " with " + other.Value);
    if (this.Waiting.contains(other.Value)) {
      System.out.println(this.Value + " is before " + other.Value);
      return -1;
    }
    if (other.Waiting.contains(this.Value)) {
      System.out.println(this.Value + " is after " + other.Value);
      return 1;
    }
    if (this.Value < other.Value) { // check if other char is before value in alphabet
      System.out.println("letter " + this.Value + " is before " + other.Value);
      return -1;
    }
    if (this.Value > other.Value) { // check if other char is before value in alphabet
      System.out.println("letter " + this.Value + " is after " + other.Value);
      return 1;
    }

    return 0;
  }
}
