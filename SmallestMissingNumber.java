package com.practice.codility.problems;

import java.util.HashSet;

public class SmallestMissingNumber {

	//n * (n=1)/2 won't work here due to as array can start from 2 element as well.
	public int solution(int[] A) {
		int result = 1;

		if (A.length > 0) {
			HashSet<Integer> arraySet = new HashSet<Integer>();

			int maxVal = A[0];

			for (int i = 0; i < A.length; i++) {
				arraySet.add(A[i]);

				if (maxVal < A[i])
					maxVal = A[i];
			}

			if (maxVal < 1)
				return result;

			boolean found = false;
			for (int i = 1; i <= maxVal; i++) {
				if (!arraySet.contains(i)) {
					result = i;
					found = true;
					break;
				}
			}

			if (!found)
				result = maxVal + 1;

		}

		return result;
	}

	/*
	 * Write a function: class Solution { public int solution(int[] A); } that,
	 * given an array A of N integers, returns the smallest positive integer
	 * (greater than 0) that does not occur in A. For example, given A = [1, 3, 6,
	 * 4, 1, 2], the function should return 5. Given A = [1, 2, 3], the function
	 * should return 4. Given A = [−1, −3], the function should return 1.
	 * 
	 * Write an efficient algorithm for the following assumptions: N is an integer
	 * within the range [1..100,000]; each element of array A is an integer within
	 * the range [−1,000,000..1,000,000].
	 */
	public static void main(String[] args) {
		SmallestMissingNumber obj = new SmallestMissingNumber();
		System.out.println("Output = " + obj.solution(new int[] { 1, 3, 6, 4, 1, 2 }));
		System.out.println("Output = " + obj.solution(new int[] { 1, 2, 3 }));
		System.out.println("Output = " + obj.solution(new int[] { -1, -3 }));

	}

}
