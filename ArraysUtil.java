package com.practice.codility.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ArraysUtil {

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int temp = 0;
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static long sum(long[] arr, int startIndex) {

		long totalsum = 0;
		for (int i = startIndex; i < arr.length; i++) {
			totalsum = totalsum + arr[i];
		}

		return totalsum;

	}
	
	public static void display(List<Integer> array, int startIndex, int endIndex) {
		for (int i = startIndex; i <= endIndex; i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
	}
	

	public static void display(List<String> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
	}
	
	
	public static void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void display(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void display(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void display(ArrayList<?> arrayList) {
		ListIterator<?> its = arrayList.listIterator();

		while (its.hasNext()) {
			System.out.print(its.next() + ",");
		}
		System.out.println();
	}

	public static int findMin(int[] A) {
		int tempMin = A[0];
		for (int i = 0; i < A.length; i++) {
			if (tempMin > A[i]) {
				tempMin = A[i];
			}
		}
		return tempMin;
	}

	public static int findMax(int[] A) {
		int tempMax = A[0];
		for (int i = 0; i < A.length; i++) {
			if (tempMax < A[i]) {
				tempMax = A[i];
			}
		}
		
		return tempMax;
	}

	public static int findValueInSortedArray(int[] sortedArray, int value) {
		return Arrays.binarySearch(sortedArray, value);
	}

}
