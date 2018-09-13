package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelUsingarray {
	public static WebDriver driver;
	public static String FilePath = "G:\\TestData.xlsx";
	public static XSSFSheet SheetName;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileInputStream fis;
	public static Object[][] data;

	@Test(dataProvider = "getdata")
	public void loadtest(String Username, String Password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G:\\java_workspace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Launch the URL
		Thread.sleep(3000);
		driver.get("http://demo.guru99.com/V4/");
		// Find user name
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.name("uid"));
		// Fill user name
		userName.sendKeys(Username);
		// Find password
		WebElement password = driver.findElement(By.name("password"));
		// Fill password
		password.sendKeys(Password);
		Thread.sleep(2000);
		driver.close();
	}

	@DataProvider
	public Object[][] getdata() throws Exception {

		try {
			File file = new File(FilePath);
			 fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			SheetName = workbook.getSheet("Sheet1");
			int rowcount = SheetName.getLastRowNum();
			int cellcount = SheetName.getRow(rowcount).getLastCellNum();
			 data = new Object[rowcount + 1][cellcount];

			for (int i = 0; i < rowcount + 1; i++) {
				for (int j = 0; j < cellcount; j++) {
					XSSFRow row = SheetName.getRow(i);
					DataFormatter formatter = new DataFormatter();

					XSSFCell uname = row.getCell(j);
					String newname=formatter.formatCellValue(uname);
					data[i][j] = newname;

					/*
					 * XSSFCell pwd= row.getCell(1); data[i][1]=pwd.getStringCellValue();
					 */

				}
			}
			
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			fis.close();
		}
		return data;
		

	}
}
