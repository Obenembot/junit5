package com.example.entities;

public class MathUtil {

	public int add(int a, int b) {

		return a + b;
	}

	public int sub(int a, int b) {

		return a - b;
	}

	public double divide(int a, int b) {

		return a / b;
	}

	public int mult(int a, int b) {

		return a * b;
	}

	public double computeCircleArea(int a) {
		
		System.out.println(Math.PI * a);
		return Math.PI * a;
	}

}
