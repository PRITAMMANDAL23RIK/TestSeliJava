package day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;

public class first {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//WebDriver driver=new FirefoxDriver();
		//WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String pas=password(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("pritam");
		driver.findElement(By.name("inputPassword")).sendKeys("Rikprit23@");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ron");
		driver.findElement(By.cssSelector("Input[placeholder='Email']")).sendKeys("rik@gmail.com");
		driver.findElement(By.cssSelector("Input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("Input[placeholder='Email']")).sendKeys("rikmandal@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("7980718217");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("inputUsername")).sendKeys("pritam");
		driver.findElement(By.name("inputPassword")).sendKeys(pas);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		//System.out.println(driver.findElement(By.tagName("p")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText() ,"You are successfully logged in.");
		Thread.sleep(800);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button")).click();
		driver.navigate().to("https://www.google.com/");
		
		
	}
	public static String password(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String pssText=driver.findElement(By.cssSelector("form p")).getText();
		String[] passAr1=pssText.split("'");
		String passAr2=passAr1[1].split("'")[0];
		return passAr2;
		
	}

}
