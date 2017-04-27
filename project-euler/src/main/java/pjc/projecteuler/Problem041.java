package pjc.projecteuler;

import pjc.projecteuler.util.SeiveOfErasthones;

import java.util.Date;


/**
 * Project Euler Problem
 * Created by philc_000 on 01/04/2017.
 */
public class Problem041 {
    private static final int MAX = 7654321 + 1;

    private int[] sieve;

    public static void main(String[] args) {
        Date startTime = new Date();
        (new Problem041()).solve();
        System.out.printf("%d ms", (new Date()).getTime() - startTime.getTime());
    }

    public Problem041() {
        sieve = SeiveOfErasthones.getArray(MAX);
    }

    private void solve() {
        // number with digits "12345678" and "123456789" are divisible by 3
        combine("", "7654321");
    }

    // if tail is small enough then check number for primality
    // otherwise recurse through a sub-list of the tail
    private boolean combine(String head, String tail) {
        if (tail.length() == 1) {
            int n = Integer.parseInt(head + tail);
            if (sieve[n - 1] == 1) {
                System.out.printf("%s%s\n", head, tail);
                return true;
            }
        } else {
            for (char i : tail.toCharArray()) {
                if (combine(head + i, tail.replace(Character.toString(i), ""))) {
                    return true;
                }
            }
        }
        return false;
    }
}