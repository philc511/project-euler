package pjc.projecteuler;

import pjc.projecteuler.util.SeiveOfErasthones;

import java.util.Date;

/**
 * Project Euler Problem
 * Created by philc_000 on 24/04/2017.
 */
public class Problem046 {

    private static final int MAX = 10000;
    private int[] sieve;

    public static void main(String[] args) {
        Date startTime = new Date();
        (new Problem046()).solve(MAX);
        System.out.printf("%d ms", (new Date()).getTime() - startTime.getTime());
    }

    public Problem046() {
        sieve = SeiveOfErasthones.getArray(MAX);
    }

    private void solve(int upperSearchBound) {
        int[] flags = new int[upperSearchBound];
        flags[1]=1;
        for (int i = 0; i < upperSearchBound; i++) {
            if (isPrime(i) || i%2==0) {
                flags[i]=1;
            }
        }
        for (int i = 0; i < flags.length; i++) {
            if (isPrime(i)) {
                for (int j=0;(i+2*j*j)<upperSearchBound;j++) {
                    flags[i+2*j*j]=1;
                }
            }
        }

        for (int i = 0; i < upperSearchBound; i++) {
            if (flags[i] == 0) {
                System.out.println(i);
            }
        }

    }

    private boolean isPrime(int i) {
        return i != 0 && sieve[i-1] == 1;
    }
}
