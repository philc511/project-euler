package pjc.projecteuler.util;

public class IntegerFunctions {
    public static boolean isAbundant(int n) {
        int sum = 1;
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return (sum > n);
    }
}
