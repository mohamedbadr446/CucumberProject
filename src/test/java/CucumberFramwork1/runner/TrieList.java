package CucumberFramwork1.runner;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.util.ArrayUtil;

import java.util.*;

public class TrieList {
    public static void main2(String[] args) {

        List<String> list=new ArrayList();
        list.add("ACCÉLÉRATEUR");
        list.add("GREENTECH");
        list.add("ÉNERGIE");
        list.add("ETUDE");
        list.add("INDUSTRIE");
        list.add("FINTECH");

        List<String> list2=new ArrayList();
        list2.add("FINTECH");
        list2.add("GREENTECH");
        list2.add("ETUDE");
        list2.add("ÉNERGIE");
        list2.add("ACCÉLÉRATEUR");
        list2.add("INDUSTRIE");

        System.out.println(list2.get(1));
        System.out.println("compare => "+list2.toString().contains(list.toString()));

        System.out.println("Before => "+list);
       //  list.stream().sorted();
        Collections.sort(list);
        System.out.println("After  => "+list);
    }

    public static void main(String[] args) {
        List listOne = Arrays.asList("AAA", "BBB", "DDD", "CCC");
        List listTwo=new ArrayList(listOne);
        Collections.sort(listOne,Collections.reverseOrder());
        System.out.println("listOne => "+listOne);
        System.out.println("listTwo => "+listTwo);
        System.out.println("Hello");
    }
}
