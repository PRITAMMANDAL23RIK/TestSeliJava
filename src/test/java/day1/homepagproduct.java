package day1;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class homepagproduct {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.demoblaze.com/");
		List<WebElement> web=driver.findElements(By.xpath("//*[@id=\"tbodyid\"]/div/div/div/h4/a"));
		String dg,rt;
		
		int count=0;
		for(int i=0;i<web.size();i++) {
			dg=web.get(i).getText();
			rt=web.get(i).getText().split(" ")[0];
			System.out.println(dg+"company name - "+rt);
			count++;
		}
		//List<String> prod=web.stream().map(product->product.getText()).collect(Collectors.toList());
		//String str=prod.toString();
		System.out.println(count);
		//System.out.println(prod.size());

	}

}
