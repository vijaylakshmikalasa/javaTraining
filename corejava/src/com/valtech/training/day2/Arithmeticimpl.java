package com.valtech.training.day2;

public class Arithmeticimpl implements Arithmetic {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		return a * b;
	}

	@Override
	public int div(int a, int b) throws DivideByZeroException{
			if(b == 0) {
				throw new DivideByZeroException("Zero cannot be used as denominator");
			}	
		return a / b;
	}
	
	public static void main(String[] args) {
		Arithmetic a = new Arithmeticimpl();
		System.out.println(a.add(2,3));
		try {
			System.out.println(a.div(5,1));
			System.out.println(a.div(5,5));
		} catch (DivideByZeroException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println("will tihs been seen...");
	}
		finally {
			System.out.println("seen always");
		}
		System.out.println(a.mul(4,2));
}
}

