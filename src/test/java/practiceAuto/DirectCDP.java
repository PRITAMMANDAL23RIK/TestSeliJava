package practiceAuto;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.emulation.Emulation;

public class DirectCDP {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		Map devm=new HashMap();
		devm.put("width", 600);
		devm.put("height", 1000);
		devm.put("deviceScaleFactor", 50);
		devm.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", devm);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.className("navbar-toggler-icon")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();


	}

}
