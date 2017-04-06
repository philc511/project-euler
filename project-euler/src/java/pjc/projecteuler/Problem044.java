package pjc.projecteuler;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by philc_000 on 04/04/2017.
 */
public class Problem044 {
    public static void main(String[] args) {
        Date startTime = new Date();
        (new Problem044()).solve();
        System.out.printf("%d ms", (new Date()).getTime() - startTime.getTime());
    }

    private void solve() {
        List<Integer> p = IntStream.range(1, 10000).boxed().map(n -> n*(3*n-1)/2).collect(Collectors.toList());

        for(int i = 0; i < 5000; i++) {
            for (int j = 0; j < i; j++) {
                if (isPentagonal(p.get(i) - p.get(j)) && isPentagonal(p.get(i) + p.get(j))) {
                    System.out.printf("%d, %d, %d\n", i+1, j+1, p.get(i) - p.get(j));
                }
            }
        }
    }

    private boolean isPentagonal(int p) {
        int n = (1 + (int)Math.sqrt(1+24*p))/6;
        return n*(3*n-1)/2 == p;
    }
}
