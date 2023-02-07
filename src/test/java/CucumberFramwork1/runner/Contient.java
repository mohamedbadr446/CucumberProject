package CucumberFramwork1.runner;

import java.io.IOException;

public class Contient {

    public String rr(String str)
    {
        if (str.equals("null")){
            str="";
        }
        return str;
    }
    public static void main(String[] args) throws IOException {
        String nom="SyntheseBarometreJeunesChercheursetEntrepreneuriatPhDTalentBpifrance2022Versionlongue";
        String nom2="SyntheseBarometreJeunesChercheursetEntrepreneuriatPhDTalentBpifrance2022Versionlongued652aeca51";

        System.out.println((nom2.contains(nom)));
       // System.out.println(nom.toUpperCase());
        //System.out.println(nom.replace("\n",""));
        
        String str = "null ";
        Contient c=new Contient();

        System.out.println(c.rr(str.trim()));

        String command ="netstat";
        Process process = Runtime.getRuntime().exec(command);
      //  process.getInputStream();
        System.out.println(process.getOutputStream().toString());
        System.out.println("jjj");
    }
}