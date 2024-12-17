package practiceAuto;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fileupload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
        WebDriver driver=new ChromeDriver();
		
		driver.get("https://pdf2png.com/");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/label")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Pemo\\Desktop\\selenium\\fileupload.exe");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/button")).click();
		

	}

}
