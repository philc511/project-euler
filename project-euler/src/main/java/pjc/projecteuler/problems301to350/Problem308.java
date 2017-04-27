package pjc.projecteuler.problems301to350;

public class Problem308 {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int g = 0;
        int h = 0;
        int i = 0;
        int j = 0;
        System.out.println("   a, b, c, d, e, f, g, h, i, j");
        for (int kk = 0; kk < 10000 ; kk++) {
            if (d > 0 && f > 0) {
                System.out.print("01:");
                d--;
                f--;
                g++;
            } else if (g > 0 && c > 0) {
                System.out.print("02:");
                g--;
                c--;
                a++;
                b++;
                f++;
            } else if (b > 0 && g > 0) {
                System.out.print("03:");
                g--;
                b--;
                h++;
            } else if (a > 0 && h > 0) {
                System.out.print("04:");
                a--;
                h--;
                i++;
            } else if (b > 0 && e > 0) {
                System.out.print("05:");
                b--;
                e--;
                j++;
            } else if (j > 0) {
                System.out.print("06:");
                j--;
                d++;
                e++;
            } else if (i > 0) {
                System.out.print("07:");
                i--;
                c++;
                h++;
            } else if (h > 0) {
                System.out.print("08:");
                h--;
                d++;
                e++;
            } else if (g > 0) {
                System.out.print("09:");
                g--;
            } else if (f > 0) {
                System.out.print("10:");
                f--;
                e++;
            } else if (e > 0) {
                System.out.print("11:");
                e--;
                f++;
            } else if (a > 0) {
                System.out.print("12:");
                a--;
                b++;
                c++;
            } else if (d > 0) {
                System.out.print("13:");
                d--;
            } else {
                System.out.print("14:");
                c++;
                e++;
            }
            System.out.println(a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + h + ", " + i + ", " + j);
            if (a==5 && b==0 && c==0 && d==0 && e==0 && f==0 && g==0 && h==0 && i==0 && j==0) {
                break;
            }
        }
    }
}
