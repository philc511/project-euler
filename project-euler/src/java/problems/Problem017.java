package problems;

public class Problem017 {
    public static void main(String[] someArgs) {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            NumberWord n = numberFactory(i+1);
            System.out.println(n.getNumberAsWords());
            sum += n.getLetterCount(); 
        }
        System.out.println(sum);
    }

    public static NumberWord numberFactory(int n) {
        if (n < 10) {
            return new SingleDigitNumber(n);
        } else if (n < 100) {
            return new DoubleDigitNumber(n);
        } else {
            return new TripleDigitNumber(n);
        }
    }
}
