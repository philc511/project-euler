package pjc.projecteuler.problems1to50;

public class Problem019 {
    public static void main(String[] args) {
           
            int dayPrevMonth = 1;
            for (int j = 2 ; j < 13 ; j++) {
                dayPrevMonth = dayOfMonth(dayPrevMonth, j-1, 1900);
            }
            int sundays = 0;
            for (int i = 1901; i < 2001; i++) {
                for (int j = 1 ; j < 13 ; j++) {
                    dayPrevMonth = dayOfMonth(dayPrevMonth, j-1, i);
                    if (dayPrevMonth == 0) {
                        sundays++;
                    }
                }
            }
            System.out.println(sundays++);
        }
        
        static int dayOfMonth(int dayPrevMonth, int month, int year) {
            int day = -1;
            switch (month) {
                case 4:
                case 6:
                case 9:
                case 11:
                    day = (dayPrevMonth + 2) % 7;
                    break;
                case 2:
                    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                        day = (dayPrevMonth + 1) % 7;
                    } else {
                        day = dayPrevMonth;
                    }
                default:
                    day = (dayPrevMonth + 3) % 7;
                    break;
            }
            return day;
        }
}