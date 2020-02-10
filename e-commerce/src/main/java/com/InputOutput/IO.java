package com.InputOutput;

import java.util.Scanner;




public class IO{
	
	static Scanner input=new Scanner(System.in);
	
	public static int readIntInput() {
		int n=input.nextInt();
		input.nextLine();
		return n;
	}
	
	
	public static String readStringInput() {
		return input.nextLine();
	}
	
	
	public static Double readDoubleInput() {
		
		double n=input.nextDouble();
		return n;
		
	}

}
