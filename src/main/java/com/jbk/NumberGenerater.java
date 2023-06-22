package com.jbk;

import java.util.Random;

public class NumberGenerater {

	public static void main(String[] args) {

		
			Random random = new Random();
			String numbers = "123456789";
			char[] otp = new char[2];

			for (int i = 0; i < 2; i++) {

				otp[i] = numbers.charAt(random.nextInt(numbers.length()));
			}

			System.out.println( Integer.parseInt(new String(otp)));

		}

	

}
