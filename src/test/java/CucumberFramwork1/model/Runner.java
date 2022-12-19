package CucumberFramwork1.model;

public class Runner {

    public static void main(String[] args) {
        Voiture v=new Voiture(12,"AAA 1","Renault");
        Voiture v2=new Voiture(12,"AAA 1","Renault");
        Voiture v3=new Voiture(12,"AAA 7","Renault");

        System.out.println(v.equals(v2));
        System.out.println(v.equals(v3));
    }
}
