package pjc.projecteuler.problems1to50;
 

import java.math.BigInteger;

import pjc.projecteuler.util.MyBigInteger;
 
public class Problem020 {

    /**
     * Uses MyBigInteger to multiply 1 to 100. 
     * Compares with java.math.BigInteger
     */
    public static void main(String[] args) {
        MyBigInteger num = new MyBigInteger();
        System.out.println(num);
        num.add(1);
        BigInteger big = BigInteger.ONE;
        for (int i = 2; i <= 100 ; i++) {
            num.multiply(i);
            big = big.multiply(BigInteger.valueOf(i));
            System.out.println(big);
            System.out.println(num);
        }
        System.out.println(num.sumDigits());
    
    }

}
