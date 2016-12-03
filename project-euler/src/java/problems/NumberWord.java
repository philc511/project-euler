package problems;

import java.util.HashMap;
import java.util.Map;

public abstract class NumberWord {
    protected int number;
    
    private static Map<Integer, String> digits = new HashMap<Integer, String>();
    static {
        digits.put(1, "one");
        digits.put(2, "two");
        digits.put(3, "three");
        digits.put(4, "four");
        digits.put(5, "five");
        digits.put(6, "six");
        digits.put(7, "seven");
        digits.put(8, "eight");
        digits.put(9, "nine");
        digits.put(10, "ten");
        digits.put(11, "eleven");
        digits.put(12, "twelve");
        digits.put(13, "thirteen");
        digits.put(14, "fourteen");
        digits.put(15, "fifteen");
        digits.put(16, "sixteen");
        digits.put(17, "seventeen");
        digits.put(18, "eighteen");
        digits.put(19, "nineteen");
        digits.put(20, "twenty");
        digits.put(30, "thirty");
        digits.put(40, "forty");
        digits.put(50, "fifty");
        digits.put(60, "sixty");
        digits.put(70, "seventy");
        digits.put(80, "eighty");
        digits.put(90, "ninety");
        digits.put(100, "one hundred");
        digits.put(1000, "one thousand");
    }
    public NumberWord(int num) {
        number = num;
    }
    public abstract String getNumberAsWords();

    public int getLetterCount() {
        return count(getNumberAsWords());
    }
    
    protected int count(String string) {
        int i = 0; 
        for(char c: string.toCharArray()) {
            if (Character.isLetter(c)) {
                i++;
            }
        }
        return i;
    }  
    protected String getSimpleWord(int n) {
        if (digits.containsKey(n)) {
            return digits.get(n);
        } else {
            return "";
        }
    }
}
