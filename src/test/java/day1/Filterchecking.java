package day1;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filterchecking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> vegs=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> ver=vegs.stream().filter(veg->veg.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(vegs.size(), ver.size());

	}

}
