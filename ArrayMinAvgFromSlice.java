package com.practice.codility.problems;

public class ArrayMinAvgFromSlice {

	public int solution(int[] A) {
		int index = 0;
		double curMinAvg = 0;
		double sum = 0;
		double minAvg = Integer.MAX_VALUE;
		double divBy = 1;

		for (int i = 0; i < A.length; i++) {
			sum = A[i];
			for (int j = i + 1; j < A.length; j++) {
				sum = sum + A[j];
				divBy = (j - i) + 1;
				curMinAvg = (sum) / divBy;

				if (minAvg > curMinAvg) {
					minAvg = curMinAvg;
					index = i;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
		ArrayMinAvgFromSlice obj = new ArrayMinAvgFromSlice();
		System.out.println(obj.solution(new int[] { 4, 2, 2, 5, 1, 5, 8 }));
	}

}
