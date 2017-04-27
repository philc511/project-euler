package pjc.projecteuler.problems1to50;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Project Euler Problem
 * Created by philc_000 on 30/03/2017.
 */
public class Problem040 {
    public static void main(String[] args) {
        Date startTime = new Date();
        (new Problem040()).problem040();
        System.out.printf("%d ms", (new Date()).getTime() - startTime.getTime());
    }

    private void problem040() {
        // generate a string "123456789101112.....", up to number 200000 so should be more than 1 million chars long
        String s = IntStream.range(1, 200000).mapToObj(Integer::toString).collect(Collectors.joining());
        // find the 1st, 10th, 100th etc char and multiply them together
        int answer = IntStream.iterate(1,n->n*10).limit(7).
                reduce(1, (total,i)-> total*Character.getNumericValue(s.charAt(i-1)));
        System.out.println(answer);
    }
}
