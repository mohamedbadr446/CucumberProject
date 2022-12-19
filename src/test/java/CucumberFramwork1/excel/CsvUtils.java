package CucumberFramwork1.excel;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class CsvUtils {
        public static final char CSV_FILE_DELIMITER = ',';
        public static XSSFWorkbook workbook;
        public void convertCsvToExcel(String strSource, String strDestination, String extension)
                throws IllegalArgumentException, IOException {

            Workbook workBook = null;
            FileOutputStream fos = null;

            // Check that the source file exists.
            File sourceFile = new File(strSource);
            if (!sourceFile.exists()) {
                throw new IllegalArgumentException("The source CSV file cannot be found at " + sourceFile);
            }

            // Check that the destination folder exists to save the Excel file.
            File destination = new File(strDestination);
            if (!destination.exists()) {
                throw new IllegalArgumentException(
                        "The destination directory " + destination + " for the converted Excel file does not exist.");
            }
            if (!destination.isDirectory()) {
                throw new IllegalArgumentException(
                        "The destination " + destination + " for the Excel file is not a directory/folder.");
            }

            // Getting BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(sourceFile));

            // Getting XSSFWorkbook or HSSFWorkbook object based on excel file format
            if (extension.equals(".xlsx")) {
                workBook = new XSSFWorkbook();
            } else {
                workBook = new HSSFWorkbook();
            }

            Sheet sheet = workBook.createSheet("Sheet");

            String nextLine;
            int rowNum = 0;
            while ((nextLine = br.readLine()) != null) {
                Row currentRow = sheet.createRow(rowNum++);
                String rowData[] = nextLine.split(String.valueOf(CSV_FILE_DELIMITER));
                for (int i = 0; i < rowData.length; i++) {
                    if (NumberUtils.isDigits(rowData[i])) {
                        currentRow.createCell(i).setCellValue(Integer.parseInt(rowData[i]));
                    } else if (NumberUtils.isNumber(rowData[i])) {
                        currentRow.createCell(i).setCellValue(Double.parseDouble(rowData[i]));
                    } else {
                        currentRow.createCell(i).setCellValue(rowData[i]);
                    }
                }
            }
            String filename = sourceFile.getName();
            filename = filename.substring(0, filename.lastIndexOf('.'));
            File generatedExcel = new File(strDestination, filename + extension);
            fos = new FileOutputStream(generatedExcel);
            workBook.write(fos);

            try {
                // Closing workbook, fos, and br object
                workBook.close();
                fos.close();
                br.close();

            } catch (IOException e) {
                System.out.println("Exception While Closing I/O Objects");
                e.printStackTrace();
            }

        }

    public static String Recuperer_Valeur_Fichier_Excel(int a, int b) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\mohamine\\eclipse-workspace\\CucumberFramwork1\\excel\\File2.xlsx");
         workbook = new XSSFWorkbook(fis);
        //I have placed an excel file 'Test.xlsx' in my D Driver
        XSSFSheet sheet = workbook.getSheetAt(0);
        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
        Row row = sheet.getRow(a);
        String scope =sheet.getRow(a).getCell(b).toString();
        //System.out.println("hello"+scope);
        return scope;
    }
    public static List Recuperer_Valeur_Fichier_Excel_typStr(int a, int b) throws IOException {
        //I have placed an excel file 'Test.xlsx' in my D Driver
        CsvUtils.Recuperer_Valeur_Fichier_Excel(a,b);
        XSSFSheet sheet = workbook.getSheetAt(0);
        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
        //Row row = sheet.getRow(a);
        String s = sheet.getRow(a).getCell(b).toString();
        //String[] typeStructure = s.split(",");
        List list= Arrays.asList(s.split(";"));
        return list;
/*        for (String i : typeStructure) {
            System.out.println(i);
            //PAP.VerifierTypeStructureExcel(i);
            pParcoursCreationProjet.selectionnerTypeStructre(i);
            pApercuProjet.cliquerStructure();
            pApercuProjet.cliquerSectionDocument();
            pApercuProjet.selectTypeDocumentAssert(typeDoc);
            //verifier_nomDocument(i);
        }*/
    }
        /*
         * Testing the CSV to Excel converter program using the main method
         */
        public static void main(String[] args) {
            long startTime = System.currentTimeMillis();
            boolean converted = true;
            try {
                CsvUtils converter = new CsvUtils();
                String strSource = "C:\\Users\\mohamine\\eclipse-workspace\\CucumberFramwork1\\excel\\pagessectorielles.csv";
                String strDestination = "C:\\Users\\mohamine\\eclipse-workspace\\CucumberFramwork1\\excel";
                converter.convertCsvToExcel(strSource, strDestination, ".xlsx");
                int nbr=Recuperer_Valeur_Fichier_Excel_typStr(1,0).size();
                for (int i=0;i<nbr;i++){
                    System.out.println(Recuperer_Valeur_Fichier_Excel_typStr(1,0).get(i));
                    //System.err.println(Recuperer_Valeur_Fichier_Excel(1,0));
                }
            } catch (Exception e) {
                System.out.println("Unexpected exception");
                e.printStackTrace();
                converted = false;
            }
            if (converted) {
                System.out.println("Conversion took " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");
            }

        }


}
