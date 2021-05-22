package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HourGlass2DArray {

	static int hourglassSum(int[][] arr) {
		int n = 6;
		List<Integer> sums = new ArrayList<>();

		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < n - 2; j++) {
				sumOf3By3(sums, i, j, arr);
			}
		}
		return Collections.max(sums);
	}

	private static void sumOf3By3(List<Integer> sums, int k, int l, int[][] arr) {
		int sum = 0;
		int skipIJPos1 = arr[k + 1][l];
		int skipIJPos2 = arr[k + 1][l + 2];

		for (int i = k; i < k + 3; i++) {
			for (int j = l; j < l + 3; j++) {
				sum = sum + arr[i][j];
			}
		}

		sum = sum - (skipIJPos1 + skipIJPos2);
		System.out.println(sum);
		sums.add(sum);
	}

	/**
	 * Print the largest (maximum) hourglass sum found in .
Sample Input
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Sample Output
19

Explanation
contains the following hourglasses:
1 1 1  1 1 0  1 0 0  0 0 0
  1      0      0      0
1 1 1  1 1 0  1 0 0  0 0 0

0 1 0  1 0 0  0 0 0  0 0 0
  1      1      0      0
0 0 2  0 2 4  2 4 4  4 4 0

1 1 1  1 1 0  1 0 0  0 0 0
  0      2      4      4
0 0 0  0 0 2  0 2 0  2 0 0

0 0 2  0 2 4  2 4 4  4 4 0
  0      0      2      0
0 0 1  0 1 2  1 2 4  2 4 0

The hourglass with the maximum sum ( ) is:
2 4 4
  2
1 2 4

	 * @param args
	 */
	public static void main(String[] args) {
		int[][] array = { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 }, { 0, 0, 2, 4, 4, 0 },
				{ 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };

		System.out.println(hourglassSum(array));
	}

}
