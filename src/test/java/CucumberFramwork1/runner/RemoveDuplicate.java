package CucumberFramwork1.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicate {

    public static void main(String[] args) {
        List<String> list=new ArrayList();

        list.add("AAA");
        list.add("BBB");
        list.add("AAA");
        list.add("CCC");
        list.add("DDD");
        System.out.println("First List +>"+list);
        System.out.println("Size the First List +> "+list.size());
        List<String> deduped = list.stream().distinct().collect(Collectors.toList());
        System.out.println("Second List +>"+deduped);
        System.out.println("Size the Second List +> "+deduped.size());
    }
}
