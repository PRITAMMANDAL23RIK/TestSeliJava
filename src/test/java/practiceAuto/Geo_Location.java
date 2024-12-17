package practiceAuto;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class Geo_Location {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		Map<String,Object> devm=new HashMap<String,Object>();
		devm.put("latitude", 40);
		devm.put("longitude", 3);
		devm.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", devm);
		driver.get("http:/google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElement(By.xpath("(//div[1]/div/span/a/h3)[1]")).click();

	}

}
