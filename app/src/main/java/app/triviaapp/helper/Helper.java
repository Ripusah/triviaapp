package app.triviaapp.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static androidx.core.util.Preconditions.checkArgument;

public class Helper {

    //this method will return the current data and time in required formate
    public static String getCurrentDate() {
        String dayNumberSuffix = getDayOfMonthSuffix(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        DateFormat dateFormat = new SimpleDateFormat(" d'" + dayNumberSuffix + "' MMMM hh:mm aaa");
        return dateFormat.format(Calendar.getInstance().getTime());

    }
    public static String getDayOfMonthSuffix(final int n) {
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }
}
