package com.dsa.problems.backTracking;

public class StringOfNBits {

	/*
	 * Generate all the strings of n bits.
	 *  Assume A[0..n – 1] is an array of size n
	 * */
	
	
	static int arr[] = new int[3];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binaryString(3);
	}
	
	public static void binaryString(int n) {
		
		if(n < 1) {
			System.out.println(arr[0] + " " +arr[1] + " " + arr[2]);
		}else {
			arr[n-1] = 0;
			binaryString(n-1);
			arr[n-1]=1;
			binaryString(n-1);
		}
		
	}

}
