package CucumberFramwork1.runner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateBetwen {

    public static boolean getBeetwenYears(String yearObs) {

        //Create calendar instance2
        Calendar instance2 = Calendar.getInstance();
        Calendar instance = Calendar.getInstance();
        Locale localeFr = new Locale("fr", "FR");

        //Set your date to it
        instance2.setTime(new Date());
        instance.setTime(new Date());

        //Substract one year from it
        instance2.add(Calendar.YEAR, -3);

        //Use the pattern you wish to display the date
        SimpleDateFormat isoFormat2 = new SimpleDateFormat("yyyy", localeFr);
        SimpleDateFormat isFormat = new SimpleDateFormat("yyyy", localeFr);

        // Convert the date to string using format method
        String previousYearDate = isoFormat2.format(instance2.getTime());
        String currentYearDate = isFormat.format(instance.getTime());


        if (Integer.parseInt(yearObs) >= Integer.parseInt(previousYearDate) && Integer.parseInt(yearObs) <= Integer.parseInt(currentYearDate)) {
            System.out.println("l'année de l'Obs " + yearObs + " est entre les deux année " + previousYearDate + " & " + currentYearDate);
            return true;
        } else {
            System.err.println("l'année de l'Obs " + yearObs + " n'est pas entre les deux année " + previousYearDate + " & " + currentYearDate);
            return false;
        }
    }

    public static Date getConvertDate(String date1) throws Exception {


        Date date = null;
        Locale localeFr = new Locale("fr", "FR");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", localeFr);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy", localeFr);

         date = simpleDateFormat.parse(date1);
         return date;
    }

    public static boolean getBeforDate(String date) throws Exception {


        Calendar endDate = Calendar.getInstance();
        Calendar currentDate = Calendar.getInstance();
        Locale localeFr = new Locale("fr", "FR");


        endDate.setTime(getConvertDate(date));
        currentDate.setTime(new Date());


        SimpleDateFormat isoFormat2 = new SimpleDateFormat("yyyy-MM-dd", localeFr);
        SimpleDateFormat isFormat = new SimpleDateFormat("yyyy-MM-dd", localeFr);


        String endDateString = isoFormat2.format(endDate.getTime());
        String currentDateString = isFormat.format(currentDate.getTime());


        if(currentDate.before(endDate) || currentDateString.equals(endDateString)){
            System.out.println("la date d'aujourd'huit "+currentDateString+" est inferieur de la date de fin "+endDateString);
            return true;
        }else {
            System.err.println("la date d'aujourd'huit "+currentDateString+" est supérieur de la date de fin "+endDateString);
            return false;
        }

    }




    public static void main(String[] args) throws Exception {

        //System.out.println(getBeetwenYears("2020"));
       // getConvertDate("2020-12-01");
        System.out.println(getBeforDate("2023-01-18"));
    }

}