package problems;

public class DoubleDigitNumber extends NumberWord {

    public DoubleDigitNumber(int num) {
        super(num);
    }

    @Override
    public String getNumberAsWords() {
        if (number < 21) {
            return getSimpleWord(number);
        } else {
            // split into two parts
            int little = number % 10;
            int big = (number / 10) * 10;
            String s = getSimpleWord(big) + " " + getSimpleWord(little);
            return s;
        }
    }

}
