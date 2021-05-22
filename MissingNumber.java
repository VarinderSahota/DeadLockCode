package com.practice.codility.problems;

import java.util.HashSet;

public class MissingNumber {

	public int solution(int[] A) {

		int result = 0;

		if (A.length > 0) {
			HashSet<Integer> arraySet = new HashSet<Integer>();

			int maxVal = A[0];
			int calcSum = 0;

			for (int i = 0; i < A.length; i++) {
				if (arraySet.add(A[i])) {
					if (maxVal < A[i])
						maxVal = A[i];

					calcSum = calcSum + A[i];
				} else {
					return result;
				}
			}

			int n = maxVal;
			int totalSum = (n * (n + 1) / 2);

			if ((totalSum - calcSum) == 0)
				result = 1;

		}
		return result;
	}

	public static void main(String[] args) {
		MissingNumber obj = new MissingNumber();
		System.out.println("Output = " + obj.solution(new int[] { 4, 1, 3, 2 }));
		System.out.println("Output = " + obj.solution(new int[] { 4, 1, 3 }));
		System.out.println("Output = " + obj.solution(new int[] { 1, 1 }));
	}
}
