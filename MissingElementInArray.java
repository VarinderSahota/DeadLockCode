package com.practice.codility.problems;

public class MissingElementInArray {

	public static int solution(int[] A) {
		int result = 1;
		if (A.length <= 0) {
			return result;
		}

		int n = A.length + 1;
		int sum = (n * (n + 1)) / 2;
		int calcSum = 0;

		for (int i = 0; i < A.length; i++) {
			calcSum = calcSum + A[i];
		}

		return sum - calcSum;

	}

	public static void main(String[] args) {
		System.out.println("Value = " + solution(new int[] { 1, 3, 2, 5 }));
		//important use case
		System.out.println("Value = " + solution(new int[] { 1 }));

	}

}
