package day1;


import org.testng.annotations.Test;

public class child extends Par{

	
	@Test
	public void ert() {
		doThis();
		int b=3;
		Runner rn=new Runner(b);
		System.out.println(rn.incre());
		System.out.println(rn.decre());
		System.out.println(rn.ty());
		System.out.println(rn.erq());

	}
	
}
