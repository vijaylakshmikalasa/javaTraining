package com.valtech.training;

public class Ascedesc {
	
	
	public static void main(String[] args) {
		Ascedesc ad = new Ascedesc();
	    System.out.println(ad.isMountain(4,5,3,2,1));
	}

	private boolean isMountain(int ... i) {
		int peak = identifyPeak(i);
		if(peak == 0 || peak == i.length-1)
			return false;
		boolean asc = checkAscending(i,peak);
		boolean des = checkDescending(i,peak);
		
		return false;
	}
}
	

//	public static int checkAscedesc(int[] arr) {
//	    int n = arr.length;
////	    if (n <= 1) {
////	        return -1;
////	    }
//	 
//	    
//	    boolean Asce = true;
//	    for (int i = 1; i < n; i++) {
//	        if (arr[i] < arr[i - 1]) {
//	            Asce = false;
//	        }
//	    }
//	           
//	    
//	    boolean Desc = true;
//	    for (int i = 1; i < n; i++) {
//	        if (arr[i] > arr[i - 1]) {
//	            Desc = false;
//	           
//	        }
//	    }
//	   
//	    if (Asce && Desc) {
//	        return 1;
//	    } else 
//	        return -1;
//	    
//	}
//	
//	 
//	public static void main(String[] args) {
//	    int[] arr = {4,5,1,2,3};
//	    int result = checkAscedesc(arr);
//	    System.out.println(result);
//	}
//	
//}

	
