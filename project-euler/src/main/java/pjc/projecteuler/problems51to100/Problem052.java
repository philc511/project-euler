package pjc.projecteuler.problems51to100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * finding x where digits of 2x, 3x, 4x, 5x, 6x are same. Look for 2x (this is i below), which must be 
 * multiple of 6 (sum of 3x must be divisible by 3, 2x will have same sum so also divisbl by 3. Also 2x
 * is even).  Then compare 2x with 3x, 4x etc by compaing list of sorted digits of each
 * @author Phil
 *
 */
public class Problem052 {
    public static void main(String[] args) {
        for (int i = 100002; i < 500000; i=i+6) {
            if (match(i, 2*i) && match(i, 3*i/2) && match(i, 5*i/2) && match(i, 3*i)) {
                System.out.println(i/2 + ", " + i + ", " + 3*i/2 + ", " + 2*i + ", " + 5*i/2 + ", " + 3*i);
            }
        }
    }
    
    public static boolean match(int a, int b) {
        List<Integer> aList = getAsList(a);
        List<Integer> bList = getAsList(b);
        return (aList.equals(bList));
    }

    private static List<Integer> getAsList(int a) {
        List<Integer> aList = new ArrayList<Integer>();
        int i = a;
        while (i > 0) {
            aList.add(i % 10);
            i = i / 10;
        }
        Collections.sort(aList);
        return aList;
    }
}
