package CucumberFramwork1.runner;

import java.util.Arrays;
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

    }
}
