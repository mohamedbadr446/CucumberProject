package CucumberFramwork1.excel;

import java.io.IOException;
import java.util.Objects;

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
			workbook=new XSSFWorkbook("C:\\Users\\mohamine\\eclipse-workspace\\CucumberFramwork1\\excel\\File1.xlsx");
			sheet=workbook.getSheet("Feuil1");
			String chaine=sheet.getRow(row).getCell(col).getStringCellValue();
			return chaine;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExcelUtils that = (ExcelUtils) o;
		return Objects.equals(workbook, that.workbook) && Objects.equals(sheet, that.sheet);
	}

	@Override
	public int hashCode() {
		return Objects.hash(workbook, sheet);
	}
}
