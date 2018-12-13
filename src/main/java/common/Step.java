package common;

public class Step implements Comparable{
  public Character A,B;
  public Step(String str) {
    this.A = str.charAt(5);
    this.B = str.charAt(36);
  }

  @Override
  public String toString() {
    return B.toString();
  }

  @Override
  public int compareTo(Object o) {
    Step other = (Step)o;
    if (other.A == this.B) {
      return -1;
    } else if (other.A < this.A) { // check if other char is before value in alphabet
      return 1;
    }
    return 0;
  }
}
