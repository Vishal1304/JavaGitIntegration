package vishal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datatowrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Datatowrite objExcelFile = new Datatowrite();

	    //Prepare the path of excel file

	    String filePath ="G:/java_workspace/vishal";
	    String[] valueToWrite = {"Mr. E","delhi"};

	    //Call read file method of the class to read data

	    objExcelFile.writeexcel(filePath,"example.xlsx","java",valueToWrite);

	}
	
	public void writeexcel(String filePath,String fileName,String sheetName,String[] valueToWrite) throws IOException{

	    //Create an object of File class to open xlsx file

	    File file =    new File(filePath+"\\"+fileName);
boolean a=file.canWrite();
System.out.println(a);
	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(filePath);

	    Workbook example1 = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	     example1 = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class

	         example1 = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet exampleSheet = example1.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = exampleSheet.getLastRowNum()-exampleSheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	    

	    	Row row = exampleSheet.getRow(0);

	    	//Create a new row and append it at last of sheet

	        Row newRow = exampleSheet.createRow(rowCount+1);
	      //Create a loop over the cell of newly created Row

	        for(int j = 0; j < row.getLastCellNum(); j++){

	            //Fill data in row

	            Cell cell = newRow.createCell(j);

	            cell.setCellValue(valueToWrite[j]);

	        }

	        //Close input stream

	        inputStream.close();

	        //Create an object of FileOutputStream class to create write data in excel file

	        FileOutputStream outputStream = new FileOutputStream(file);

	        //write data in the excel file

	        example1.write(outputStream);

	        //close output stream

	        outputStream.close();

	        
}}