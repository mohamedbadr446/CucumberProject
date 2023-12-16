package CucumberFramwork1.runner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter {

    /**
     * Utility function to convert java Date to TimeZone format
     *
     * @param date
     * @param format
     * @param timeZone
     * @return
     */
    public static String formatDateToString(Date date, String format,
                                            String timeZone) {
        // null check
        if (date == null) return null;
        // create SimpleDateFormat object with input format
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        // default system timezone if passed null or empty
        if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
            timeZone = Calendar.getInstance().getTimeZone().getID();
        }
        // set timezone to SimpleDateFormat
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        // return Date in required format with timezone as String
        return sdf.format(date);
    }

    public static void main(String[] args) throws ParseException {
        //Test formatDateToString method
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = simpleDateFormat.parse("12/08/2022");
        System.out.println("Default Date:" + simpleDateFormat.format(date));
        System.out.println("System Date: " + formatDateToString(date, "dd MMM yyyy", null));
        System.out.println("System Date in PST: " + formatDateToString(date, "dd MMMM yyyy", "PST"));
        System.out.println("System Date in IST: " + formatDateToString(date, "dd MMMM yyyy", "IST"));
        System.out.println("System Date in GMT: " + formatDateToString(date, "dd MMMM yyyy", "GMT"));




    }


}
