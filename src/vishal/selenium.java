package vishal;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class selenium {

	public static XSSFWorkbook example1;
	public static org.apache.poi.ss.usermodel.Cell Cell;

	public void readExcel(String filePath, String fileName, String sheetName)
			throws IOException {

		FileInputStream inputStream = new FileInputStream(filePath);

		example1 = new XSSFWorkbook(inputStream);
		
		Sheet exampleSheet = example1.getSheet(sheetName);

		// Find number of rows in excel file

		int rowCount = exampleSheet.getLastRowNum()
				- exampleSheet.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it

		for (int i = 0; i < rowCount + 1; i++) {

			Row row = exampleSheet.getRow(i);

			// Create a loop to print cell values in a row
for(int j=0;j<row.getLastCellNum();j++)
			
{

				// Print Excel data in console
				Cell = exampleSheet.getRow(i).getCell(j);
				System.out.print(Cell.getStringCellValue() + " ");

		}

			System.out.println();

		}

	}

	// Main function is calling readExcel function to read data from excel file

	public static void main(String args[]) throws IOException {

		// Create an object of ReadGuru99ExcelFile class

		selenium objExcelFile = new selenium();

		// Prepare the path of excel file

		String filePath = "G:\\java_workspace\\vishal\\example.xlsx";

		// Call read file method of the class to read data

		objExcelFile.readExcel(filePath, "example.xlsx", "java");

	}

	
}