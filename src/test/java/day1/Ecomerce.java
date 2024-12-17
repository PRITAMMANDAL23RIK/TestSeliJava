package day1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecomerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		String[] iteamsneed= {"Cucumber","Brocolli","Tomato"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		select(driver,iteamsneed);
		driver.findElement(By.cssSelector("img[alt='Cart'")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		

	}
	public static void select(WebDriver driver,String[] iteamsneed) {
		int j=0;
		List lr=Arrays.asList(iteamsneed);
		List<WebElement> elm=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<elm.size();i++) {
			String[] sr=elm.get(i).getText().split("-");
			String rt=sr[0].trim();
			if(lr.contains(rt)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==iteamsneed.length) {
					break;
				}
			}
		}
	}

}
