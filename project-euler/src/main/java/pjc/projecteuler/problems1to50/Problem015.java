package pjc.projecteuler.problems1to50;

public class Problem015 {
    public static void main(String[] args) {
        int maxCount = 0;
        int maxValue = 0;
        for (int i = 910107; i <= 910107; i++) {
            int c = count(i);
            if (c > maxCount) {
                System.out.println("Value = " + maxValue);
                System.out.println("Count = " + maxCount);
                maxCount = c;
                maxValue = i;
            }
            //System.out.println(c);
        }
        System.out.println("Value = " + maxValue);
        System.out.println("Count = " + maxCount);
    }

    private static int count(int i) {
        int n = i; 
        int counter = 1;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            counter++;
            System.out.print(n);
            System.out.print(", ");
        }
        return counter;
    }
}
