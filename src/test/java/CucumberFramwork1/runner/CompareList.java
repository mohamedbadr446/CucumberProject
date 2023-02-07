package CucumberFramwork1.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CompareList {
    public static void main(String[] args) {


         List listOne = Arrays.asList("AAA", "BBB", "CCC");
         List listTwo = Arrays.asList("AAA", "BBB", "CCC", "DDD", "EEE");

        List<String> differences = (List<String>) listTwo.stream()
                .filter(element -> !listOne.contains(element))
                .collect(Collectors.toList());

        differences.forEach(e-> System.out.println(e.toString()));
        System.out.println(differences.size());
        List listEmpty=Arrays.asList("AAA", "BBB","DDD", "CCC");
        List list=new ArrayList();
        System.out.println(list.isEmpty());
        Collections.sort(listEmpty, Collections.reverseOrder());
       // listEmpty.removeAll(Arrays.asList("", null));
        listEmpty.stream().filter(empty->(!empty.equals(""))).collect(Collectors.toList());
        System.out.println(listEmpty);


    }
}
