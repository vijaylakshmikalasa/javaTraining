package com.valtech.training.day1;

public class HelloWorld {


	public static void main(String[] args) {
		String s = "hello world";
		String s1 = "hello world";
		System.out.println(s == s1);
		final String s2 = "hello";
		String s3 = s2 + " world";
		System.out.println(s==s3);
	}
}
 