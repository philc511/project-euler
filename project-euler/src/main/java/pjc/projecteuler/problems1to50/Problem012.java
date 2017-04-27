package pjc.projecteuler.problems1to50;

public class Problem012 {

    /**
     * Sum of 1...n is n*(n+1)/2. So need to find num divisors in n*(n+1)/2. 
     * Works on the basis that n consists of some divisors, and n+1 will consist of a completely
     * separate set of divisors (1 is the only common divisor). So can get total number of divisors
     * by adding these together, adding 1 for 1 as the common divisor, and the additional combos
     * from multiplying the numbers together (eg for 7*8, divisors are 7, 2, 4, 8 and 1 and 7*2, 7*4, 7*8).
     * Need to do some extra work to account for 1/2 in the summation formula. 
     * @param args
     */
    public static void main(String[] args) {
        long minDivisorsNeeded = 500;

        long n = 3;
        long numDivisorsCur = 1;
        long numDivisorsNext = 1;

        boolean found = false;
        while (!found) {
            // account for 1/2 in summation formula by calculating num of divisors in half of which of 
            // n and n+1 is even
            if ((n+1) %2 == 0) {
                numDivisorsNext = numFactors((n+1)/2);
            } else {
                numDivisorsNext = numFactors(n+1);
            }
            if ((numDivisorsCur + numDivisorsNext + 1 + (numDivisorsCur * numDivisorsNext)) > minDivisorsNeeded) {
                found = true;
            } else {
                n++;
                numDivisorsCur = numDivisorsNext;
            }
        }
        System.out.println(n);
        System.out.println(n*(n+1)/2);
        System.out.println(1 + numFactors(n * (n+1) / 2));
    }
    /**
     * Number of divisors in n.
     * exclude 1 as a divisor
     */
    public static long numFactors(long n)
    {
        long m = (long)Math.sqrt(n);
        long factors = 1; // n
        for (long j = 2; j < m+1; j++)
        {
            if (n % j == 0)
            {
                factors+=2; // j and n/j
            }
        }
        // need to account for squares, ie take one back off if m is srqt
        if ((m * m) == n)
        {
            factors--;
        }
        return factors;
    }


}
