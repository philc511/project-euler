import java.util.ArrayList;
import java.util.List;

/**
 * Build up a sequence of remainders, whena remainder is repeated or is zero, sequence ends.
 * Find the longest sequence
 * @author Phil
 *
 */
public class Problem026 {
    public static void main(String[] args) {
        int longestCycle = 1;
        int soln = -1;
        for (int n = 2; n < 1001; n++) {
            int remainder = findRemainder(10, n);
            if (remainder == 0) {
                System.out.println(n + ": 0");
                continue;
            }
            List<Integer> sequence = new ArrayList<Integer>();
            sequence.add(remainder);
            remainder = findRemainder(remainder, n);
            int count = 1;
            while (!sequence.contains(remainder) && remainder != 0) {
                sequence.add(remainder);
                remainder = findRemainder(remainder, n);
                count++;
            }
            System.out.println(n + ": " + count);
            if (count > longestCycle) {
                longestCycle = count;
                soln = n;
            }
        }
        System.out.println(soln);
    }

    /**
     * find the remainder of m / n, unless m < n in which case
     * multiply m * 10 until m > n 
     * @param n
     * @param m
     * @return
     */
    private static int findRemainder(int m, int n) {
        while (m < n) {
            m = 10 * m;
        }
        return m % n;
    }
}
