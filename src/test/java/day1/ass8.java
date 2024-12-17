package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ass8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		//System.out.println(options.getFirst().getText());
		for(WebElement option:options ) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

	}

}
