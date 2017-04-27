package pjc.projecteuler.problems301to350;

import pjc.projecteuler.util.Fraction;


public class Problem308a {
    public static Fraction[] code = new Fraction[] {
        new Fraction(17,91),
        new Fraction(78,85),
        new Fraction(19,51),
        new Fraction(23,38),
        new Fraction(29,33),
        new Fraction(77,29),
        new Fraction(95,23),
        new Fraction(77,19),
        new Fraction(1,17),
        new Fraction(11,13),
        new Fraction(13,11),
        new Fraction(15,2),
        new Fraction(1,7),
        new Fraction(55,1)    };
    public static void main(String[] args) {
        long seed = 2;
        long val = seed;
        System.out.println(val);
        for (int i = 0; i < 1000; i++) {
            for (Fraction f : code) {
                if (f.times(val).isInteger()) {
                    val = f.times(val).toInt();
                    break;
                }
            }
            System.out.println(val + ", " + powersOfTwo(val));
            if (val == 4 || val == 8 || val == 16 || val == 32 || val == 128 || val == 2048) {
//                System.out.println(i + ", " + val);
            }
        }
    }
    private static int powersOfTwo(long val) {
        int count = 0;
        long tmp = val;
        while (tmp % 2 == 0) {
            count++;
            tmp = tmp / 2;
        }
        return count;
    }
}