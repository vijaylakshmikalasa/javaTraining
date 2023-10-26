package com.valtech.training.day2;

public class SimpleInterestImpl implements SimpleInterest {
	
	private Arithmetic arithmetic;
	
	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}
	
	
	@Override
	public double computeInterest(int prin, int roi, int duration) {
		int result = arithmetic.mul(prin, roi);
		result = arithmetic.mul(result,  duration);
		return arithmetic.div(result, 100);
	}
	 
	
    public static void main(String[] args) {
		Arithmetic arithmetic = new Arithmeticimpl();
		SimpleInterest si = new SimpleInterestImpl();
		System.out.println(si.computeInterest(200,3,4));
	
    }
}