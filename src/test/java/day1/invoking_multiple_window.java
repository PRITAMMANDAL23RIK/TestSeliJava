package day1;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class invoking_multiple_window {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> win=driver.getWindowHandles();
		Iterator<String> it=win.iterator();
		String parentid=it.next();
		String childid=it.next();
		driver.switchTo().window(childid);
		driver.get("https://rahulshettyacademy.com/");
		String str=driver.findElement(By.xpath("//*[@id=\"courses-block\"]/div[1]/div/div[2]/div[1]/h2/a")).getText();
		driver.switchTo().window(parentid);
		WebElement nm=driver.findElement(By.name("name"));
		nm.sendKeys(str);
		File file=nm.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("D:\\scc\\fg.png"));
	}

}
