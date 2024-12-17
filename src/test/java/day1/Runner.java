package day1;

public class Runner extends mul {
	int a;
    public Runner(int b) {
    	super(b);
		this.a=b;
	}
	public int incre() {
    	 a=a+1;
    	 return a;
    }
    public int decre() {
    	  a=a-1;
    	  return a;
    }
}
