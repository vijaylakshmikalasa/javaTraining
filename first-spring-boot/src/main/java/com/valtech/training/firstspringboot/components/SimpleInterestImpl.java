package com.valtech.training.firstspringboot.components;

public class SimpleInterestImpl implements SimpleInterest{

	private Airthemetic airthemetic;
	
	public SimpleInterestImpl() {
	}

	public SimpleInterestImpl(Airthemetic airthemetic) {
		this.airthemetic=airthemetic;
	}
	
	public void setAirthmetic(Airthemetic airthmetic) {
		this.airthemetic = airthmetic;
	}
	
	@Override
	public double ComputeInterest(int prin, int roi, int time) {
		int result=airthemetic.mul(prin, roi);
		result=airthemetic.mul(result,time);
		return airthemetic.div(result,100);
	}

//	public Airthemetic getAirthmetic() {
//		return airthmetic;
//	}
	public static void main(String[] args) {
		Airthemetic airthemetic = new AirthemeticImpl();
		SimpleInterest si= new SimpleInterestImpl(airthemetic);
		System.out.println(si.ComputeInterest(200, 3, 4));
	}
}
