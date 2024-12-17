package day1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class extralogic {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		WebElement columdriver=driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul"));
		System.out.println(columdriver.findElements(By.tagName("a")).size());
		int b=columdriver.findElements(By.tagName("a")).size();
		for(int i=1;i<b;i++) {
			String clickonlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columdriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
			Thread.sleep(5000L);
		}
		Set<String> xv=driver.getWindowHandles();
		Iterator<String> it=xv.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
        }
		

	}

}
