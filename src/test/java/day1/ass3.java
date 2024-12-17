package day1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ass3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		String[] iteamsneed= {"iphone","Samsung","Nokia","Blackberry"};
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div/label[2]/span[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement stDrop=driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[5]/select"));
		Select dropDown=new Select(stDrop);
		dropDown.selectByValue("teach");
		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.card-title")));
		select(driver,iteamsneed);
		
		
		

	}
	public static void select(WebDriver driver,String[] iteamsneed) {
		int j=0;
		List lr=Arrays.asList(iteamsneed);
		List<WebElement> elm=driver.findElements(By.cssSelector("h4.card-title"));
		for(int i=0;i<elm.size();i++) {
			String[] sr=elm.get(i).getText().split(" ");
			String rt=sr[0].trim();
			if(lr.contains(rt)) {
				j++;
				driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
				if(j==iteamsneed.length) {
					break;
				}
			}
		}
	}

}
