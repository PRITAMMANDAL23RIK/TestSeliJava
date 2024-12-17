package day1;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebtableSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> ele=driver.findElements(By.xpath("//tr/td[1]"));
        List<String> orgele=ele.stream().map(a->a.getText()).collect(Collectors.toList());
        List<String> srele=orgele.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(orgele.equals(srele));
        List<String> price;
        do {
        	List<WebElement> elem=driver.findElements(By.xpath("//tr/td[1]"));
            price=elem.stream().filter(s->s.getText().contains("Rice")).map(a->getPrice(a)).collect(Collectors.toList());
            price.forEach(a->System.out.println(a));
            if(price.size()<1) {
            	driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }
        while(price.size()<1);
	}
	public static String getPrice(WebElement s) {
		String pricev=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricev;
		
	}

}
