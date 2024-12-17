package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollpages {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement> tr=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<tr.size();i++) {
			sum=sum+Integer.parseInt(tr.get(i).getText());
		}
		System.out.println(sum);
		String ar=driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
		System.out.println(ar);
		if (Integer.parseInt(ar)==sum) {
			System.out.println("Equal "+ar);
		}
		else {
			System.out.println("not Equal");
		}

	}

}
