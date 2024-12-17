package day1;

import java.util.Scanner;

import org.checkerframework.checker.units.qual.s;

public class pract {
	public static void main(String[] args) {
		String num="145";
		int yu=Integer.parseInt(num);
		//System.out.println(yu);
		int su=0;
		for(int i=0;i<num.length();i++) {
			int a=yu%10;
			//System.out.println(a);
			su=(su*10)+a;
			//System.out.println(su);
			yu=yu/10;
		}
		System.out.println(su);
	}

}
