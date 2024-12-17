package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Rik");
		driver.findElement(By.name("email")).sendKeys("Rikprit23@gmai.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Rikprit23@");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement stDrop=driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropDown=new Select(stDrop);
		dropDown.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.name("bday")).sendKeys("23/03/2000");
		driver.findElement(By.cssSelector(".btn-success")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
	}

}
