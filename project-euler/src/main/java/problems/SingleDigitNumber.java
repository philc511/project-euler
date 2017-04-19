package problems;

public class SingleDigitNumber extends NumberWord {
    
    public SingleDigitNumber(int num) {
        super(num);
    }

    @Override
    public String getNumberAsWords() {
        return getSimpleWord(number);
    }

}
