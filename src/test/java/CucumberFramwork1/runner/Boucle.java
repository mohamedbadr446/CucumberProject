package CucumberFramwork1.runner;

import CucumberFramwork1.model.Voiture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boucle {

    public List a(){
        Voiture v;
        List list=new ArrayList<Voiture>();
        List list1=new ArrayList<String>();
        list1.add("AAA");
        list1.add("BBB");
        for (int i=0;i<5;i++) {
            v=new Voiture();
            v.setId(i);
            v.setMatricule("Matricule v"+i);
            v.setModel("null");
            v.setList(list1);
            list.add(v);
        }

        return list;
    }

    public void b(){
        Voiture v;
        List list=new ArrayList<Voiture>();
        List listV=a();
        List list1=new ArrayList<String>();
        list1.add("AAA");
        list1.add("BBB");
        for (int i=0;i<5;i++) {
            v=new Voiture();
            v.setId(i);
            v.setMatricule("Matricule v"+i);
            v.setModel("null");
            v.setList(list1);
            list.add(v);
        }

        for (int i=0;i<list.size();i++)
        {
            Voiture v1=new Voiture();
            Voiture v2=new Voiture();
            v1= (Voiture) list.get(i);
            v2= (Voiture) listV.get(i);

            if(v1.equals(v2)){
                System.out.println("OK");
            }else {
                System.out.println("KO");
            }
        }

    }
    public List replaceNull(){
        List list;
        list=a();
        a().forEach(e-> System.err.println(e.toString()));
        System.out.println("----------------------");

        return list;
    }

    public static void main(String[] args) {
        Boucle b=new Boucle();
       // b.b();

       // Collections.sort(list);

        //b.replaceNull().forEach(e-> System.out.println(e.toString()));
        b.replaceNull().forEach(e-> System.out.println(e.toString()));



    }

}
