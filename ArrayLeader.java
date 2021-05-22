package com.practice.codility.problems;

import java.util.ArrayList;

public class ArrayLeader {

	public static ArrayList<Integer> arrayLeader(int arr[], int n) {
		ArrayList<Integer> leaders = new ArrayList<Integer>();
		ArrayList<Integer> newLeaders = new ArrayList<Integer>();
		int leader = arr[n - 1];

		for (int i = n - 1; i >= 0; i--) {

			if (i == n - 1) {
				leaders.add(arr[i]);
				leader = arr[i];
			}
			if (i < n - 1) {
				if (arr[i] >= leader) {
					leaders.add(arr[i]);
					leader = arr[i];
				}
			}
		}

		for (int i = leaders.size() - 1; i >= 0; i--) {
			newLeaders.add(leaders.get(i));
		}

		return newLeaders;
	}

	/*
	 * Input: n = 6 A[] = {16,17,4,3,5,2} Output: 17 5 2 Explanation: The first
	 * leader is 17 as it is greater than all the elements to its right. Similarly,
	 * the next leader is 5. The right most element is always a leader so it is also
	 * included.
	 */
	
	public static void main(String[] args) {
		ArrayList<Integer> leaders = arrayLeader(new int[] { 16, 17, 4, 3, 5, 2 }, 6);
		ArraysUtil.display(leaders);
	}

}
