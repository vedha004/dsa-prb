package com.dsa.problems.recursion;

public class IsArraySortedOrder {

	
	
	public static void main(String[] args) {
		int arr[] = {20,30,40};
		System.out.println(isArraySortedOrder(4,arr));
	}
	
	public static int isArraySortedOrder(int index, int[] arr) {
		
		if(arr.length == 1) {
			return 1;
		}
		
		return (arr[index-1] < arr[index -2])?0:isArraySortedOrder(index-1, arr);
	}

}
