package com.practice.codility.problems;

public class ArrayEquilibramPoint {

	public static int equilibriumPoint(long arr[], int n) {

		long leftSum = 0;
		long rightSum = 0;

		for (int i = 0; i < n; i++) {
			rightSum = ArraysUtil.sum(arr, i);
			rightSum = rightSum - arr[i];
			if (rightSum == leftSum) {
				return i + 1;
			}
			leftSum = leftSum + arr[i];
		}
		return -1;
	}

	/*
	 * Given an array A of n positive numbers. The task is to find the first
	 * Equilibrium Point in the array. Equilibrium Point in an array is a position
	 * such that the sum of elements before it is equal to the sum of elements after
	 * it.
	 * 
	 * Input: n = 5 A[] = {1,3,5,2,2} Output: 3 Explanation: For second test case
	 * equilibrium point is at position 3 as elements before it (1+3) = elements
	 * after it (2+2).
	 */
	public static void main(String[] args) {

		long[] array = new long[] { 1, 3, 5, 2, 2 };
		System.out.println("Equilibram index is = " + equilibriumPoint(array, 5));

	}

}
