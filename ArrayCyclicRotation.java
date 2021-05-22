package com.practice.codility.problems;

public class ArrayCyclicRotation {

	// On existing array
	public static int[] cyclicRotation(int[] array, int rotationCount) {

		if (array.length > 0) {
			if (array.length == 1) {
				return array;
			}

			int lastPosition = array.length - 1;
			int temp = 0;

			for (int indx = 0; indx < rotationCount; indx++) {
				temp = array[lastPosition];
				for (int index = lastPosition; index > 0; index--) {
					array[index] = array[index - 1];
				}
				array[0] = temp;
			}
		}
		return array;
	}

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4, 5, 6 };
		int rotation = 2;

		long t = System.currentTimeMillis();
		ArraysUtil.display(cyclicRotation(array, rotation));
		System.out.println("Time taken by cyclicRotation = " + (System.currentTimeMillis() - t));
		int[] array1 = new int[] { 1, 2, 3, 4, 5, 6 };
		long t1 = System.currentTimeMillis();
		ArraysUtil.display(solution(array1, rotation));
		System.out.println("Time taken by solution = " + (System.currentTimeMillis() - t1));

	}

	// With new array
	public static int[] solution(int[] A, int K) {
		int[] new_array = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			int new_position = (i + K) % A.length;
			new_array[new_position] = A[i];
		}

		return new_array;
	}

	public static void antiClockRotation(int[] arr, int d, int n) {

		if (n > 0) {
			if (d == n)
				return;

			int position = 0;
			int temp = 0;

			for (int index = 0; index < d; index++) {
				temp = arr[position];

				for (int i = 0; i < n - 1; i++) {
					arr[i] = arr[i + 1];
				}

				arr[n - 1] = temp;

			}
		}

	}

}
