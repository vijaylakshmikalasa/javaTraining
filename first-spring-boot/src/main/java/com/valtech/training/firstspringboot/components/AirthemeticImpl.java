package com.valtech.training.firstspringboot.components;

public class AirthemeticImpl implements Airthemetic {
	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

	@Override
	public int mul(int a, int b) {
		return a * b;
	}

	public static void main(String[] args) {// throws DivideByZeroException
		Airthemetic a = new AirthemeticImpl();
		System.out.println(a.add(2, 3));
		try {
			System.out.println(a.div(5, 0));
		} catch (Exception e) {
			System.out.println("This will not be executed");
		} finally {
			System.out.println("This will be seen irrespectively");
		}
		System.out.println(a.add(2, 3));
	}

	@Override
	public int div(int a, int b) {
		return a/b;
	}
}
