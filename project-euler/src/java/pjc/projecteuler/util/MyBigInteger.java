/*
 * Created on 04-Nov-2009
 */
package pjc.projecteuler.util;

import java.util.Arrays;

/**
 * Simple version of BigInteger first used in problem 20.
 * Has methods for adding and multiplying integers, and 
 * also summing the digits
 * @author Phil
 */
public class MyBigInteger {
    
    private int[] digits = new int[1024];
    private int length = 1;
   
    public MyBigInteger() {
        Arrays.fill(digits, 0);
    }
    void add(int val, int factor) {
        int remaining = val;
        int i = factor;
        while (remaining > 0) {
            int temp = remaining % 10;
            remaining = remaining / 10;
            if ((temp + digits[i]) < 10) {
                digits[i] += temp;
                length = Math.max(length, i+1);
            } else {
                digits[i] += (temp - 10);
                digits[i+1] += 1;
                length = Math.max(length, i+2);
            }
            i++;
        }
    }
    public void multiply(int val) {
        int temps[] = new int[length + 1];
        int factor = 10;
        for (int i = 0 ; i < length + 1; i++) {
            temps[i] = val * digits[i];
        }
        zero();
        for (int i = 0 ; i < temps.length; i++) {
            add(temps[i], i);
        }
    }
    public void add(int val) {
        add(val, 0);
       
    }
    private void zero() {
        for (int i = 0 ; i < length ; i++) {
            digits[i] = 0;
        }
    }
    public int sumDigits() {
        int total = 0;
        for (int i = 0 ; i < length ; i++) {
            total += digits[i];
        }
        return total;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = length-1; i >= 0; i--) {
            s.append(digits[i]);
        }
        return s.toString();
    }
}
