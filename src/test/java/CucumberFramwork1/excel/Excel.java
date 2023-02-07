package CucumberFramwork1.excel;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

public class Excel {
    private static String defaulteFile = "C:\\Users\\mohamine\\Downloads\\Default.xlsx";

    public void dataReadTest(String fileName) throws Exception {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet sheet = xsf.getSheetAt(0);

        String cell = sheet.getRow(1).getCell(0).getStringCellValue();
        //String cell2=sheet.getRow(1).ge
        System.out.println("the data in the box is " + cell);

        xsf.close();
    }

    public void exelToCsv(String fileName) {
        // Creating a inputFile object with specific file path
        File inputFile = new File(fileName);

        // Creating a outputFile object to write excel data to csv
        File outputFile = new File("src/test/resources/FileCsvGene/fileCsv.csv");

        // For storing data into CSV files
        StringBuffer data = new StringBuffer();

        try {
            // Creating input stream
            FileInputStream fis = new FileInputStream(inputFile);
            Workbook workbook = null;

            // Get the workbook object for Excel file based on file format
            if (inputFile.getName().endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (inputFile.getName().endsWith(".xls")) {
                workbook = new HSSFWorkbook(fis);
            } else {
                fis.close();
                throw new Exception("File not supported!");
            }

            // Get first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case BOOLEAN:
                            data.append(cell.getBooleanCellValue() + "|");
                            break;

                        case NUMERIC:
                            data.append(cell.getNumericCellValue() + "|");
                            break;

                        case STRING:
                            data.append(cell.getStringCellValue() + "|");
                            break;

                        case BLANK:
                            data.append("" + ",");
                            break;

                        default:
                            data.append(cell + ",");
                    }
                }
                // appending new line after each row
                data.append('\n');
            }

            FileOutputStream fos = new FileOutputStream(outputFile);
            fos.write(data.toString().getBytes());
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Conversion of an Excel file to CSV file is done!");
    }


    public static void main(String[] args) throws Exception {
        Excel excel = new Excel();
        //excel.dataReadTest(defaulteFile);
        excel.exelToCsv(defaulteFile);
    }
}
