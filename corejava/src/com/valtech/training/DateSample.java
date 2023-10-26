package com.valtech.training;

import java.sql.Date;
import java.time.LocalDate;

public class DateSample {

	public static void main(String[] args) {
		
		//index the year for 1900
//		month index with 0
//		day with 1
		Date date = new Date(47,7,15);
		System.out.println(date);
		LocalDate now =  LocalDate.of(1947,8,15);
		System.out.println(now);

	}

}
