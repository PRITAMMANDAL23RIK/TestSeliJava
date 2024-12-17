package day1;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=3;
		boolean is_prime=true;
		for(int i=2;i<num;i++)
		{
			if(num%i==0) {
				is_prime=false;
				break;
			}
			   
		}
		System.out.println(is_prime);
			
		}

	}

