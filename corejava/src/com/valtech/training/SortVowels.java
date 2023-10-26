package com.valtech.training;

public class SortVowels {
	
	public static void main(String[] args) {
		String a ="Hello how are you";
		String[] words = a.split(" ");
		System.out.println(words);	
	}
	static int countVowels(String str)
	{
	    int count = 0;
	    for(int i = 0; i < str.length(); i++)
	        if (a(str.charAt(i))) 
	            ++count;
	    return count;
	}
	private static boolean a(char charAt) {
		
		return false;
	}
	public static int sortVowels(String word)
    {
        String vowels = "aeiouAEIOU";
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

}
