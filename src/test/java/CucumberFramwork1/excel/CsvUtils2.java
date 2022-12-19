package CucumberFramwork1.excel;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CsvUtils2 {

     CSVReader reader=null;

    public  void setReader() throws Exception {
       // reader=new CSVReader(new FileReader("C:\\Users\\mohamine\\eclipse-workspace\\CucumberFramwork1\\excel\\File2.csv"));
        reader=new CSVReader(new FileReader("C:\\Users\\mohamine\\eclipse-workspace\\CucumberFramwork1\\excel\\pagessectorielles.csv"));

        String[] cell;
        String keyword="=>";
        while ((cell= reader.readNext())!=null){
             keyword=cell[0];
        }
        System.out.println(keyword);
    }

    public static void main(String[] args) throws Exception {

        CsvUtils2 c=new CsvUtils2();
                c.setReader();
    }
}
