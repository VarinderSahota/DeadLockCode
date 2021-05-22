package com.practice.hackerrank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PairOfSocks {

	public static int count = 0;

	public static int pairOfSocks(int n, int[] ar) {
		Map<Integer, Integer> countMap = new HashMap<>();

		if (n >= 1) {
			for (int i = 0; i < n; i++) {
				if (countMap.get(ar[i]) == null)
					countMap.put(ar[i], 1);
				else {
					int temp = countMap.get(ar[i]) + 1;
					countMap.put(ar[i], temp);
				}
			}

			countMap.values().stream().forEach(val -> {
				countPair(val);
			});
		}
		return count;
	}

	public static void countPair(int val) {
		count = count + (val / 2);
	}

	public static void main(String[] args) throws IOException {
		//System.out.println(pairOfSocks(7, new int[] { 1, 2, 1, 2, 1, 3, 2 }));
		System.out.println(pairOfSocks(9, new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 }));
	}

}
