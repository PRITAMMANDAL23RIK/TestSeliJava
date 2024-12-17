package practiceAuto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Uploade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fruit="Apple";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		
		driver.findElement(By.id("downloadButton")).click();
		WebElement upk=driver.findElement(By.id("fileinput"));
		upk.sendKeys("C:\\Users\\Pemo\\Downloads\\download.xlsx");
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"1\"]/div[1]/div[2]")));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[2]")).getText());
		
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"1\"]/div[1]/div[2]")));
		
		String priceColumn=driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		String actualprice=driver.findElement(By.xpath("//div[text()='"+fruit+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']")).getText();
		System.out.println(actualprice);
		Assert.assertEquals("375", actualprice);
		
		

	}

}
