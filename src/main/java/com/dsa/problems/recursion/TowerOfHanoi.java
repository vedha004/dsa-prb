package com.dsa.problems.recursion;

public class TowerOfHanoi {

	int arr[] = new int[3];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 towerOfHanoi(4,'A', 'B', 'C');
	}
	
	public static void towerOfHanoi(int n,char frompeg,char topeg, char auxpeg ) {
		
		if(n == 1) {
			System.out.println("Move disk 1 from peg " + frompeg + " to " + topeg);
			return;
		}
		
		towerOfHanoi(n-1,frompeg , auxpeg, topeg);
		
		System.out.println("Move disk from peg " + frompeg + " to " + topeg);
		
		towerOfHanoi(n-1,auxpeg , topeg, frompeg);
		
	}

}
