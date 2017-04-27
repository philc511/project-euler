package pjc.projecteuler.problems1to50;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by philc_000 on 21/03/2017.
 * Pythagoran triples obtained via https://en.wikipedia.org/wiki/Pythagorean_triple#Generating_a_triple
 * a+b+c = mn + (m^2-n^2)/2 +(m^2+n^2)/2 = m(n+m)  for m,n odd and co-prime, m>n
 * So for a+b+c < 1000, m has to be < 33
 * Each co-prime generates a unique primitive triple
 * So for that primitive scale it by integer factor  (eg 6,8,10 from 3,4,5)
 * Recursion to get the co-primes, and build up a stream of perimeters, then get the most common perimeter
 */
public class Problem039 {
    private int maxPerimeter;

    public Problem039(int maxPerimeter) {
        this.maxPerimeter = maxPerimeter;
    }

    public static void main(String[] args) {
        Date startTime = new Date();

        // odd co=primes:
        Problem039 p = new Problem039(1000);
        p.getCoPrimes(3,1).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(System.out::println);

        System.out.println((new Date()).getTime() - startTime.getTime());
    }

    private IntStream getCoPrimes(int m, int n) {
        IntStream is = IntStream.iterate(m*(m+n), i -> i+m*(m+n)).limit(maxPerimeter/(m*(m+n)));
        if (m < 33) {
            is = IntStream.concat(is, getCoPrimes(2*m-n, m));
            is = IntStream.concat(is, getCoPrimes(2*m+n, m));
            is = IntStream.concat(is, getCoPrimes(2*n+m, n));
        }
        return is;
    }

}
//import unittest
//#import Euler
//#import time
//
//# Pythagoran triples obtained via https://en.wikipedia.org/wiki/Pythagorean_triple#Generating_a_triple
//            # a+b+c = k*((m2 - n2) + 2mn + (m2 + n2)) = 2km(m+n)
//    buckets = [0] * 1001
//            for k in range(1,100):
//            for m in range(2,  1000):
//            for n in range(1,m):
//    p = k*m*2*(m+n)
//            if p==120:
//    print k, m,n, k*(m*m-n*n), k*2*m*n, k*(m*m+n*n)
//            if p<=1000:
//    buckets[p]=buckets[p]+1
//            else:
//            break
//
//    print buckets[120]
//    max=0
//            for i in range(0,1000):
//            if(buckets[i] > max):
//    max=buckets[i]
//    print i,max
//
//    print 'donee'
//}
