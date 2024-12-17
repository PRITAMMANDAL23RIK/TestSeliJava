package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ass6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption2")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/label[2]")).getText());
		String text=driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/label[2]")).getText();
		WebElement stDrop=driver.findElement(By.id("dropdown-class-example"));
		Select dropDown=new Select(stDrop);
		dropDown.selectByVisibleText(text);
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		String act=driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		if(text.equals(act)) {
			System.out.println("Its,match with"+text);
		}
		else {
			System.out.println("Its,not match with"+text);
		}

	}

}
