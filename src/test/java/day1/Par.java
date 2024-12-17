package day1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Par {
      public void doThis(){
    	  System.out.println("RIK");
      }
    @BeforeMethod
  	public void rt() {
  		System.out.println("PINKU");
  	}
    @AfterMethod
    public void etw() {
    	System.out.println("MINKU");
    }
}
