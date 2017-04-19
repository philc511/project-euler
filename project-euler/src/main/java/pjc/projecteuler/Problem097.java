package pjc.projecteuler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Project Euler Problem
 * Created by philc_000 on 17/04/2017.
 */
public class Problem097 {
    public static void main(String[] args) {
        Date startTime = new Date();
        (new pjc.projecteuler.Problem097()).solve(28433, 7830457);
        System.out.printf("%d ms", (new Date()).getTime() - startTime.getTime());
    }

    private void solve(long startingVal, int powersOfTwo) {
        System.out.println(1+LongStream.range(1,powersOfTwo+1).boxed().reduce(startingVal, (a,b)->(a*2L)%10000000000L));
    }
}
