package problems;

import java.math.BigInteger;

/**
 * Solution to problem 16
 */
public class Problem016 {
    /**
     * Main method
     * @param args not used
     */
    public static void main(String[] args) {
        BigInteger a = BigInteger.ONE;
        String s = a.shiftLeft(1000).toString();
        System.out.println(s);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer intValue = Integer.valueOf(s.substring(i, i+1));
            sum += intValue.intValue();
        }
        System.out.println(sum);
    }
}
