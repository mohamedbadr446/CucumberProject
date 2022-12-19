package CucumberFramwork1.excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Excel {

    public void dataReadTest() throws Exception {
        File file = new File("C:\\Users\\mohamine\\eclipse-workspace\\CucumberFramwork1\\excel\\File2.xlsx");
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet sheet = xsf.getSheetAt(0);

        String cell = sheet.getRow(1).getCell(0).getStringCellValue();
        //String cell2=sheet.getRow(1).ge
        System.out.println("the data in the box is " + cell);

        xsf.close();
    }

    public static void main(String[] args) throws Exception {
        Excel excel=new Excel();
        excel.dataReadTest();
    }
}
