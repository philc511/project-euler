package problems;

public class TripleDigitNumber extends NumberWord {

    public TripleDigitNumber(int num) {
        super(num);
    }

    @Override
    public String getNumberAsWords() {
        if (number == 100 || number == 1000) {
            return getSimpleWord(number);
        } else {
            // split into two parts
            int little = number % 100;
            int big = (number / 100);
            String s;
            if (little == 0) {
                s = getSimpleWord(big) + " hundred";
            } else {
                s = getSimpleWord(big) + " hundred and " + (new DoubleDigitNumber(little)).getNumberAsWords();
            }
            return s;
        }
    }

}
