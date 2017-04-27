package pjc.projecteuler.problems1to50;

import java.util.ArrayList;
import java.util.List;

import pjc.projecteuler.util.SeiveOfErasthones;


public class Problem050 {
    public static final int SIZE = 1000000;
    public static void main(String[] args) {
        List<Integer> primes = SeiveOfErasthones.getPrimesAsList(SIZE);
        int maxNumInSequence = 0;
        int maxSum = 0;
        
        // construct list of sums of primes, ie 2, 2+3, 2+3+5, until sum>SIZE in first iteration of i
        // then 3, 3+5, 3+5+7 in second iteration of i
        // Find the last prime sum total in each list, compare it with the current max length
        for (int i = 0; i < primes.size(); i++) {
            List<Integer> currentSums = getSums(primes, i);
            int numInSequence = currentSums.size() - i;
            if (numInSequence < maxNumInSequence) {
                break;
            }
            while (numInSequence+i >= 0) {
                if (primes.contains(currentSums.get(numInSequence+i-1))) {
                    break;
                }
                numInSequence--;
            }
            if (numInSequence > maxNumInSequence) {
                maxSum = currentSums.get(numInSequence+i-1);
                maxNumInSequence = numInSequence;
            }
        }
        System.out.println(maxSum);
        System.out.println(maxNumInSequence);
    }
    private static List<Integer> getSums(List<Integer> primes, int start) {
        int sum = 0;
        List<Integer> sums = new ArrayList<Integer>();
        for (int i = start; i < primes.size(); i++) {
            if (sum + primes.get(i) > SIZE) {
                break;
            }
            sum += primes.get(i);
            sums.add(sum);
        }
        return sums;
    }
}
