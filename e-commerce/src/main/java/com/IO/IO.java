package com.IO;

import java.util.Scanner;

public class IO {
	
	static Scanner input=new Scanner(System.in);
	
	public static int readIntInput() {
		return input.nextInt();
	}
	
	
	public static String readStringInput() {
		return input.next();
	}
	
	
	public static Double readDoubleInput() {
		return input.nextDouble();
	}

}
