package practiceAuto;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Exerc {

	@Test
	public static void bght() throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		//String country="India";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/dropdown");
	    Thread.sleep(3000);
	    WebElement st=driver.findElement(By.id("dropdown"));
	   // st.click();
	    Thread.sleep(1000);
	    
	   
	    Select drop=new Select(st);
	    drop.selectByVisibleText("Option 1");
	    
		
	   

	}

}
