package CucumberFramwork1.runner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ListCintains {

    public static void main(String[] args) throws ParseException {
        List listA=new ArrayList<>();
        listA.add("AAA");
        listA.add("BBB");
        listA.add("CCC");
        listA.add("DDD");
        listA.add("EEE");

        List listB=new ArrayList<>();
        listB.add("AAA");
        listB.add("BBB");
        listB.add("CCC");

        for (int i=0;i< listB.size();i++){
            System.out.println(listA.contains(listB.get(i)));
        }
        /*String nbr="500000000";
        System.out.println(Math.round(Math.random()*Integer.parseInt(nbr)));*/

        Date date1 = new Date();
        Date dateFinal = new Date();
        Date date = new Date();
        System.out.println(date1.getTime());

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        date=simpleDateFormat.parse("12/10/2022");
        date1=simpleDateFormat.parse("12/12/2022");

      //  System.out.println("Date = "+(date1.getDay()-date.getDay()));

        Locale localeFr = new Locale("fr", "FR");
        Date dateConvert = new Date((date.getTime()-date1.getTime())* 1000L);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", localeFr);
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        SimpleDateFormat originalFormat = new SimpleDateFormat("d MMM yyyy", localeFr);

        System.out.println("originalFormat = "+originalFormat.format(dateConvert));

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    //    System.out.println(Calendar.getAvailableLocales().length-);
     //   calendar.add(Calendar.getAvailableLocales().length, );

        //Afficher la date du joru
        System.out.println("Aujourd'hui, nous sommes le: "+sdf.format(calendar.getTime()));


    }
}
