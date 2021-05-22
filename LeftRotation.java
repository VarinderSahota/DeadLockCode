package com.practice.hackerrank;

import com.practice.codility.problems.ArraysUtil;

public class LeftRotation {

	static int[] rotLeft(int[] a, int d) {
		int arr[] = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			int newPosition = (i + (a.length - d)) % a.length;
			arr[newPosition] = a[i];
		}
		return arr;
	}
/**
 * rotation d = 4
arr {1 2 3 4 5}
output {5 1 2 3 4}
 * @param args
 */
	public static void main(String[] args) {
		ArraysUtil.display(rotLeft(new int[] { 1, 2, 3, 4, 5 }, 2));
	}
}
