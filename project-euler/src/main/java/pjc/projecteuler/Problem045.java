package pjc.projecteuler;

import java.util.Date;
import java.util.stream.LongStream;


/**
 * Had to use longs as ints not big enough
 */

public class Problem045 {

    public static void main(String[] args) {
        Date startTime = new Date();
        (new Problem045()).problem045();
        System.out.printf("%d ms", (new Date()).getTime() - startTime.getTime());
    }

    private void problem045() {
        // start from 286 as example given is 285 - need to find next one after that
        System.out.println(LongStream.iterate(286,  i->i+1)
                .map(i->triangular(i))
                .filter(t -> isPentagonal(t) && isHexagonal(t))
                .findFirst().getAsLong());
    }

    private Long triangular(Long n) {
        return n*(n+1)/2;
    }

    private boolean isHexagonal(Long t) {
        long n = (1 + (long)Math.sqrt(1+8*t))/4;
        return n*(2*n-1) == t;
    }

    private boolean isPentagonal(Long p) {
        long n = (1 + (long)Math.sqrt(1+24*p))/6;
        return n*(3*n-1)/2 == p;
    }

}
