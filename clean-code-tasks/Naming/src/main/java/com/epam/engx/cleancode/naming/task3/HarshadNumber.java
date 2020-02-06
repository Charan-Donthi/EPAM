package com.epam.engx.cleancode.naming.task3;

public class HarshadNumber {


	public static void main(String[] args) {
		long limit = 1000; // limit the seq of Harshad numbers
		for (int numbers = 1; numbers <= limit; numbers++) {
			if (numbers % sumOfDigits(numbers) == 0) {
				System.out.println(numbers);
			}
		}
	}

	private static int sumOfDigits(int number) {
		int sum = 0;
		while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
		return sum;
	}

}
