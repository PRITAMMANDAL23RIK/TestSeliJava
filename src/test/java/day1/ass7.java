package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ass7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		WebElement table = driver.findElement(By.id("product"));
		List<WebElement> columns = table.findElements(By.tagName("tr"));
        int totalcoulms = columns.size();
        System.out.println("Total columns: " + totalcoulms);
        WebElement firstcolum = columns.get(0);
        List<WebElement> rows = firstcolum.findElements(By.tagName("th"));
        int totalrows = rows.size();
        System.out.println("Total rows: " + totalrows);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"product\"]/tbody/tr[3]")).getText());
        		

	}

}
