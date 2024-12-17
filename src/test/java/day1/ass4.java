package day1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ass4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.className("example")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText());
		

	}

}
