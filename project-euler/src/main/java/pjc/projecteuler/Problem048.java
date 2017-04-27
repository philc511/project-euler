package pjc.projecteuler;

import java.util.Date;
import java.util.stream.LongStream;

/**
 * Project Euler Problem
 * Created by philc_000 on 25/04/2017.
 */
public class Problem048 {
    public static void main(String[] args) {
        Date startTime = new Date();
        Problem048 my =new Problem048();
        long moduleVal = 10000000000L;
        System.out.println(LongStream.rangeClosed(1,  1000)
                .reduce(0, (n,m)->(n+my.powerModulo((int)m, moduleVal))%moduleVal));
        System.out.printf("%d ms", (new Date()).getTime() - startTime.getTime());
    }

    private long powerModulo(int power, long moduloVal) {
        return LongStream.rangeClosed(1L,  power).reduce(1, (n, m)->(n*power)%moduloVal);
    }
}
