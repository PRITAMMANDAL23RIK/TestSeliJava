package practiceAuto;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StandlPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<String> lrt = List.of("Phones", "Laptops", "Monitors");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.demoblaze.com/");
		
		List<WebElement> ListCatogry=driver.findElements(By.xpath("//*[@id=\"itemc\"]"));
	    List<String> webprod=ListCatogry.stream().map(product->product.getText()).collect(Collectors.toList());	
	    Assert.assertTrue(webprod.equals(lrt));
	    System.out.println(webprod);
	    
	    driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")).click();
	    Thread.sleep(3000L);
	    System.out.println(driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2")).getText());
	    driver.findElement(By.cssSelector("li[class='nav-item active'] a[class='nav-link']")).click();
	    Thread.sleep(2000L);
	    
	    
	    driver.findElement(By.id("login2")).click();
	    Thread.sleep(2000L);
	    driver.findElement(By.id("loginusername")).sendKeys("Rikprit");
	    driver.findElement(By.id("loginpassword")).sendKeys("Rikprit23@");
	    driver.findElement(By.cssSelector("button[onclick='logIn()']")).click();
	    Thread.sleep(5000L);
	    String str=driver.findElement(By.id("nameofuser")).getText();
	    Assert.assertEquals(str, "Welcome Rikprit");
	    System.out.println(str);
	    driver.findElement(By.id("logout2")).click();
	    Thread.sleep(3000L);
	    
	    driver.findElement(By.id("login2")).click();
	    Thread.sleep(2000L);
	    driver.findElement(By.id("loginusername")).sendKeys("prit");
	    driver.findElement(By.id("loginpassword")).sendKeys("Rikprit23@");
	    driver.findElement(By.cssSelector("button[onclick='logIn()']")).click();
	    Thread.sleep(3000L);
	    System.out.println(driver.switchTo().alert().getText());
	    driver.switchTo().alert().accept();
	      
	    driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]")).click();
	    Thread.sleep(1000L);
	    driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")).click();
	    Thread.sleep(2000L);
	    driver.findElement(By.cssSelector(".btn.btn-success.btn-lg")).click();
	    Thread.sleep(1000L);
	    System.out.println(driver.switchTo().alert().getText());
	    driver.switchTo().alert().accept();
	    
	    driver.findElement(By.cssSelector("#cartur")).click();
	    System.out.println(driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")).getText());
	    
	    
	    
	    
	
		
		

	}

}
