package com.practice.codility.problems;

public class ArrayRearrange {

	public static void arrayRearrange(int arr[], int n) {

		int temp = 0;
		int j = n - 1;
		for (int i = 0; i < n; i = i + 2) {
			temp = arr[j];

			for (int k = n - 1; k > i; k--) {
				arr[k] = arr[k - 1];
			}
			arr[i] = temp;
		}
	}
	
	/*
	 * Case : Re arrange sorted array : 
	 * Input : {1, 2, 3, 4, 5, 6} 
	 * Output : {6, 1, 5, 2, 4, 3}
	 */
	
	public static void main(String[] args) {

		int[] array = new int[] {1969, 2677, 3142, 4631, 4764, 5748, 6476, 6487};
		int n = 8;
		arrayRearrange(array, n);
		ArraysUtil.display(array);
	}

}
