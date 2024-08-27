package utils;

public class DateValidator {

    public static boolean isValidDate(String date) {
        if (date == null || date.length() != 6) {
            return false;
        }

        int year, month, day;
        try {
            year = Integer.parseInt(date.substring(0, 2));
            month = Integer.parseInt(date.substring(2, 4));
            day = Integer.parseInt(date.substring(4, 6));
        } catch (NumberFormatException e) {
            return false;
        }

        if (year < 0 || year > 99) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        if (day < 1 || day > daysInMonth[month - 1]) {
            return false;
        }
        return true;
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }
}

