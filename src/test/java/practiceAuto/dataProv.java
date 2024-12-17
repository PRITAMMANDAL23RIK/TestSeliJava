package practiceAuto;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProv {
	
	@DataProvider
	public Object[][]dataprov() {
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("cou", "India");
		map1.put("mou", "Qutub Minar");

		HashMap<String,String> map2=new HashMap<String,String>();
		map2.put("cou", "Agra");
		map2.put("mou", "Taj mahal");
		
		return new Object[][] {{map1},{map2}};
		
	}
	
	
	@Test(dataProvider ="dataprov")
	public void googlrSearch(HashMap<String,String> input) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
		WebElement search=driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")) ;
		
		search.sendKeys(input.get("cou") + " " + input.get("mou"));
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[4]/div[6]/center/input[1]")).submit();
		
		
	}

}
