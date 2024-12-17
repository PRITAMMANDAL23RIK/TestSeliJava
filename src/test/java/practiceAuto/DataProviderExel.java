package practiceAuto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DataProviderExel {
	
	WebDriver driver;
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	@DataProvider(name = "searchDataXlx")
	public Object[][] datali() throws IOException{
		
		String file = "C:\\Users\\Pemo\\Desktop\\Test.xlsx";
		
		Object[][] search= getExcelData(file,"figo");
		
		return search;
	}
	
	public String[][] getExcelData(String File,String sheet) throws IOException {
		
		String[][] data=null;
		
		XSSFWorkbook ExcelBook=null;
		XSSFSheet ExcelSheet;
		
        File excellFile=new File("C:\\Users\\Pemo\\Desktop\\Test.xlsx");
		
		FileInputStream fileinpuSt=new FileInputStream(excellFile);
		
		ExcelBook = new XSSFWorkbook(fileinpuSt);
		ExcelSheet= ExcelBook.getSheetAt(2);
		
		int totalrows=ExcelSheet.getLastRowNum()+1;
		int totalcell=ExcelSheet.getRow(0).getLastCellNum();
		
		data=new String[totalrows-1][totalcell];
		
		for(int cu=1;cu<totalrows;cu++) {
			
			for(int cc=0;cc<totalcell;cc++) {
				
				data[cu-1][cc]=ExcelSheet.getRow(cu).getCell(0).toString();
				
			}
			
		}
		
		ExcelBook.close();
		return data;
	}
	
	
	
	@BeforeTest
	public void startReport() {
		htmlReporter=new ExtentSparkReporter("ExtentReport.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("OS", "windows11");
		reports.setSystemInfo("Tester", "rik");
		
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setReportName("Test report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM d, yyyy, hh:mm a '('zzz')'");
	}
	
	
	
	@Test(dataProvider="searchDataXlx")
	public void search(String keyword) throws InterruptedException {
		
		test = reports.createTest("Search Test with Keyword: " + keyword);
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		test.log(Status.INFO, "Opening Google Page");
        driver.get("https://www.google.com/");
		
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.sendKeys(keyword);
		searchbox.sendKeys(Keys.ENTER);
		
		test.log(Status.INFO, "Searching for keyword: " + keyword);
		Thread.sleep(3000);
		driver.close();
		test.log(Status.PASS, "Test Passed Successfully");
		//Assert.assertTrue(true);
		
	}
	
	
	
	
	@AfterMethod
	public void getTestResult(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "FAIL", ExtentColor.RED));
		}
		
		else if(result.getStatus() == ITestResult.SUCCESS) {
			
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "PASSED", ExtentColor.GREEN));
		}
		
        else if(result.getStatus() == ITestResult.SKIP) {
			
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIPED", ExtentColor.YELLOW));
		}
		
	}
	
	@AfterTest
	public void reportcollect() {
		
		reports.flush();
		
	}

}
