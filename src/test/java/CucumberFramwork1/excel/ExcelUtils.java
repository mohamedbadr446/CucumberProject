package CucumberFramwork1.excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	  private XSSFWorkbook workbook;
	  private XSSFSheet sheet;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelUtils excelUtils=new ExcelUtils();
		System.out.println(excelUtils.getData(1,0));
	}
	public  String getData(int row,int col)
	{
		try {
			workbook=new XSSFWorkbook("C:\\Users\\user\\eclipse-workspace\\CucumberFramwork1\\excel\\File1.xlsx");
			sheet=workbook.getSheet("Feuil1");
			String chaine=sheet.getRow(row).getCell(col).getStringCellValue();
			return chaine;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
