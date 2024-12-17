package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class callender_handel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String year="2027";
		String date="17";
		String month="6";
		String[] ned= {month,date,year};
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		List<WebElement> actual=driver.findElements(By.cssSelector(".react-date-picker__inputGroup_input"));
		for(int i=0;i<actual.size();i++) {
			System.out.println(actual.get(i).getAttribute("value"));
			Assert.assertEquals(actual.get(i).getAttribute("value"), ned[i]);
		}
		

	}

}
