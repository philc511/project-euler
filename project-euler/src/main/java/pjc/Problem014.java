package pjc;

public class Problem014 {
    public static void main(String[] args) {
        int maxn = 1;
        int maxcount = 1;
        for (int i = 2; i < 101; i++) {
            int j = calc(i);
            if (j > maxcount) {
                maxn = i;
                maxcount = j;
            }
        }
        
        System.out.println(maxn + ", " + maxcount);
    }
    public static int calc(int n) {
        int i = 1;
        while (n != 1) {
            System.out.print(n + ", ");
            if (n % 2 == 0) {
                n = n/2;
            } else {
                n = 3 * n + 1;
            }
            i++;
        }
        System.out.println(n + " (" + i + ")");
        return i;
    }
}
