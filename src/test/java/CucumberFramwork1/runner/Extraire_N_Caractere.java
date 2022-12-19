package CucumberFramwork1.runner;

import CucumberFramwork1.excel.ExcelUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Extraire_N_Caractere {


    ExcelUtils e;

    public void ele() {
        while (e == null) {
            if (e != null) {
                break;
            }
            e = new ExcelUtils();
            System.out.println("not null");
        }

        if (e != null) {
            System.out.println("not null----not null !!!");
        } else {
            System.out.println("null------null !!!");
        }
    }

    public void getInnt(int n, String nn) throws Exception {
        int nbr = 6;
        String nbrn = "8";
        if (n != nbr || Integer.parseInt(nbrn) != Integer.parseInt(nn)) {
            throw new Exception();
        }
    }

   /* public static void main(String[] args) {
        String str="1100 actualités sur 53009";
        System.out.println("----------"+StringUtils.substring(str,0,2)+"---------");
        System.out.println("----------"+StringUtils.substring(str,17,20)+"---------");
        System.out.println(StringUtils.substringAfter(str,"sur").trim());
        System.out.println(StringUtils.substringBefore(str,"act").trim());
        Extraire_N_Caractere caractere=new Extraire_N_Caractere();
        try {
            caractere.getInnt(6,"8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MMMM-yyyy");
        String stringDate= DateFor.format(date);
        System.out.println(stringDate);

            String dateForm=stringDate.replace("-"," ");

            System.out.println(dateForm);

    }*/

    public static void main(String[] args) {
        Extraire_N_Caractere ex = new Extraire_N_Caractere();
       // ex.ele();
        int nbr=4;
        nbr=nbr-(nbr-4);
        System.out.println("Le nombre d'éléments par page est => "+nbr);

        List list=new ArrayList<>();
        list.add("AAA");
        list.add("");
        list.add("BBB");

        for (int i=0;i<list.size();i++){
            if(list.get(i).equals(""))
            {
                list.remove(i);
            }

        }

       // list.removeIf(Objects::isNull);
        list.forEach(e-> System.out.println(e.toString()));



    }

}
