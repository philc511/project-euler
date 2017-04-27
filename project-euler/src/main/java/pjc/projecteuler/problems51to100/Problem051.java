package pjc.projecteuler.problems51to100;

import pjc.projecteuler.util.SieveOfEratosthenes;

/**
 * 
 * @author Phil
 *
 */
public class Problem051 {
    public static final int MAX = 10000000;
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        int[] a = SieveOfEratosthenes.getArray(MAX);
        for (int i = 0; i < MAX; i++) {
            // k is the first set of digits, either 0, 1 or 2 
            for (int k = 0; k < 3; k++) {
                if (a[i] == 1) {
                    int count = countDigits(i+1, k);
                    // looking for 3 recurring digits
                    if (count > 2) {
                        //System.out.println((i + 1) + ", " + countDigits(i+1, 0));
                        // get family of numbers
                        int[] list = getSimilarNumbers(i+1, k);
                        // count how many are prime
                        int numPrime = countPrimes(list, a);
                        if (numPrime > 7) {
                            System.out.println("Found: " + list[0] + ", " + numPrime);
                        }
                    }
                }
            }
        }
    }
    
    private static int countPrimes(int[] list, int[] a) {
        int result = 0;
        for (int i : list) {
            if (a[i-1] == 1) {
                result++;
            }
        }
        return result;
    }

    public static int[] getSimilarNumbers(int n, int digit) {
        int i = n;
        int inc = 0;
        int factor = 1;
        while (i > 0) {
            if (i % 10 == digit) {
                inc = inc + factor;
            }
            i = i / 10;
            factor = 10 * factor;
        }
        int[] list = new int[10 - digit];
        list[0] = n;
        for (int j = 1; j < (10 - digit); j++) {
            list[j] = list[j-1] + inc;
        }
        return list;
        
    }

    public static int countDigits(int n, int digit) {
        int i = n;
        int count = 0;
        while (i > 0) {
            if (i % 10 == digit) {
                count++;
            }
            i = i / 10;
        }
        return count;
    }

}
