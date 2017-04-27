import java.util.ArrayList;
import java.util.HashSet;

import pjc.projecteuler.util.IntegerFunctions;


public class Problem023 {

    private static final int UPPER_BOUND = 28123;

    /**
     * @param args
     */
    public static void main(String[] args) {
        // first collect list of abundant numbers
        ArrayList<Integer> abNums = new ArrayList<Integer>();
        for (int i = 2; i < UPPER_BOUND ;i++) {
            if (IntegerFunctions.isAbundant(i)) {
                abNums.add(i);
            }
        }
        System.out.println(abNums.size());
        // now create a set of all numbers found from adding
        // all pairs of these numbers (which are less than  or equal 28123)
        HashSet<Integer> sumTwoAbNums = new HashSet<Integer>();
        for (int i = 0; i < abNums.size(); i++) {
            for (int j = i; j < abNums.size(); j++) {
                int sum = abNums.get(i) + abNums.get(j);
                if (sum <= UPPER_BOUND) {
                    sumTwoAbNums.add(sum);
                }
            }
        }
        System.out.println(sumTwoAbNums.size());
        // Now the sum of all numbers from 1 to 28123 minus the 
        // sum of all numbers in the previous set will be the answer
        // (ie the sum of all numbers which cannot be made by adding
        // pairs of abundant numbers)
        long sumOfSums = 0L;
        for (Integer i : sumTwoAbNums) {
            sumOfSums += i;
        }
        long sumToUpperBound = (UPPER_BOUND * (UPPER_BOUND+1)) / 2;
        System.out.println("Sum of nos which can be written as sum of abundant numbers: " + sumOfSums);
        System.out.println("Sum of nos from 1 to 28123: " + sumToUpperBound);
        System.out.println("Sum of nos which cannot be written as sum of 2 abundant nos: " + (sumToUpperBound - sumOfSums));
        
    }
    


}
