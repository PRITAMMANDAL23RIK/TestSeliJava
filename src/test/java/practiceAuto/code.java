package practiceAuto;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Arrays;

public class code {

	public static void main(String[] args) {
		
		int[] arr= {1,4,8,4,9};
		
		int[] uncom= Arrays.stream(arr).distinct().toArray();
		
		System.out.println(Arrays.toString(uncom));
		
		
	}
}
