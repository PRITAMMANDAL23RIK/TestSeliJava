package practiceAuto;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dataxlx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		XSSFWorkbook ExcelBook=null;
		XSSFSheet ExcelSheet;
		//XSSFRow Row;
		//XSSFCell Cell;
		
		File excellFile=new File("C:\\Users\\Pemo\\Desktop\\Test.xlsx");
		
		FileInputStream fileinpuSt=new FileInputStream(excellFile);
		
		ExcelBook = new XSSFWorkbook(fileinpuSt);
		ExcelSheet= ExcelBook.getSheetAt(1);
		
		int totalrows=ExcelSheet.getLastRowNum()+1;
		//int totalcell=ExcelSheet.getRow(0).getLastCellNum();
		
		for(int cu=1;cu<totalrows;cu++) {
			
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("https://www.saucedemo.com/");
			
			driver.findElement(By.id("user-name")).sendKeys(ExcelSheet.getRow(cu).getCell(0).toString());
			driver.findElement(By.id("password")).sendKeys(ExcelSheet.getRow(cu).getCell(1).toString());
			
			driver.findElement(By.id("login-button")).click();
			
			driver.close();
			
		}
		
		ExcelBook.close();

	}

}
