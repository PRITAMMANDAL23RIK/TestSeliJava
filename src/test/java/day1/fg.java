package day1;

import java.util.Arrays;

public class fg {
	
public static void main(String[] args) {
        
        //int n=1;
	int[] arr= {1,6,2,9,3};
	int y=arr.length;
	Arrays.sort(arr);
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                System.out.print("*"+" ");
                //n++;
            }
            System.out.print("\n");
           
        }
        
    }

}
