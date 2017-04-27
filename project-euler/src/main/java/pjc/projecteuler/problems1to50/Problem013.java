package pjc.projecteuler.problems1to50;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem013 {
    
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("c:\\temp\\temp.dat"));
            String s = reader.readLine();
            int[] sum = stringToIntArray(s);
            while ((s = reader.readLine()) != null) {
                sum = add(sum, stringToIntArray(s));
            }
            for (int i : sum) {
                System.out.print(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] stringToIntArray(String s) {
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        return a;
    }

    /**
     * assume a is same length or longer than b
     * @param a
     * @param b
     * @return
     */
    private static int[] add(int[] a, int[] b) {
        int[] c = new int[a.length + 1];
        int carry = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = a[a.length-1-i] + carry;
            if (i < b.length) {
                sum += b[b.length-1-i];
            }
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            c[c.length-1-i] = sum;
        }
        c[0] = carry;
        return c;
    }
}
