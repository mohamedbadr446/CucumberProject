package CucumberFramwork1.excel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestReader {

    public static void main(String args[]) {

        String fileName = "C:\\Users\\mohamine\\eclipse-workspace\\CucumberFramwork1\\excel\\pagessectorielles.csv";
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        //list.forEach(System.out::println);
        String str = String.join("\n", list);
        str.replace("|",",");
        System.out.println(str);



    }
}




