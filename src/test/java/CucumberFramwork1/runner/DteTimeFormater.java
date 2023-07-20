package CucumberFramwork1.runner;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DteTimeFormater {
    public static void main(String[] args) throws Exception {
        Date date = new Date(1675780620 * 1000L);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String formatted = format.format(date);
        System.err.println(formatted);
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MMMM-dd");
       // Date date = originalFormat.parse(value.toString());
        System.out.println(date);
        System.out.println("Default Date: "+originalFormat.format(date));

    }
}
