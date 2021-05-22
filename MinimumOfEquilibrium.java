package com.practice.codility.problems;

public class MinimumOfEquilibrium {

	public static int sum(int[] A, int startIndex) {
		int sum = 0;
		for (int i = startIndex; i < A.length; i++) {
			sum = sum + A[i];
		}
		return sum;
	}

	public static int solution(int[] A) {
		int leftSum = 0;
		int rightSum = 0;
		int sumOfTape = 0;
		int tempMin = Integer.MAX_VALUE;
		int totalSum = sum(A, 0);

		for (int i = 0; i < A.length - 1; i++) {
			leftSum = leftSum + A[i];
			rightSum = totalSum - leftSum;
			sumOfTape = Math.abs(leftSum - rightSum);

			if (tempMin > sumOfTape)
				tempMin = sumOfTape;
		}

		return tempMin;
	}

	public static void main(String[] args) {
		System.out.println("Value = " + solution(new int[] { 3, 1, 2, 4, 3 }));
	}

}
