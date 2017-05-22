import java.util.stream.IntStream;

public class TestMe {
  public static void main(String[] args) {
    int total = 0;
    for (int i = 1; i <=100; i++) {
      total += numOverMax(i, 1000000);
    }
    System.out.println(total);
  }
  public static int numOverMax(int n, int max) {
    int count = 0;
    for (int i = 1; i < n; i++) {
      if (ncr(n, i) > max) {
        count++;
      }
    }
    return count;
  }
  
  public static int ncr(int n, int r) {
    return IntStream.rangeClosed(1,n-r).reduce(1, (n1,n2)->n1*(n2+r)/n2);
  }
}
