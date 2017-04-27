package pjc.projecteuler.util;

public class Fraction {
    private long numerator;
    private long denominator;
    
    public Fraction(long num, long den) {
        numerator = num;
        denominator = den;
    }
    
    public Fraction times(long n) {
        return new Fraction(n * numerator, denominator);
    }
    
    public boolean isInteger() {
        return (numerator % denominator == 0);
    }

    public long toInt() {
        return (numerator / denominator);
    }
}
