package pjc.projecteuler.util;

import java.util.ArrayList;
import java.util.List;


public class SieveOfEratosthenes {
    public static int[] getArray(int size) {
        int max = size;
        int a[] = new int[max];
        for (int i = 0; i < max ; i++) {
            a[i] = 1;
        }
        a[0] = 0;
        for (int j = 2; j*j <= max; j++) {
            for (int k = j*j; k <= max; k+=j) {
                a[k-1] = 0;
            }
        }
        return a;
    }

    public static List<Integer> getPrimesAsList(int size) {
        int[] a = getArray(size);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                list.add(i+1);
            }
        }
        return list;
    }
}
