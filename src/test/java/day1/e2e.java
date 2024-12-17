package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		//driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/svg/g/circle[1]")).click();
		driver.findElement(By.cssSelector("input[type=text")).click();
		//css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n']//div[text()='Kolkata']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Passengers')]")).click();
		Thread.sleep(1000);
		//div[@data-testid='Adult-testID-plus-one-cta']
		int i=1;
		while(i<4) {
			driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
			i++;
		}
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[contains(text(), 'Family & Friends')]/preceding-sibling::div//input[@type='radio']")).click();
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
	}

}
