package com.example.caseStudy4;

public class FindEvenNumbers {
	public static void main(String[] args) {
		System.out.println("Even Numbers Using For Loop ");
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\nEven Numbers Using While Loop ");
		int a = 1;
		while (a <= 100) {
			if (a % 2 == 0) {
				System.out.print(a + " ");
			}
			a++;
		}
	}

}
