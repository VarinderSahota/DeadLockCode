package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.practice.codility.problems.ArraysUtil;

public class LongestSubArray {

	//find the longest sub array in array so that their diff between elements should not be more than 1 
	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<>();
//1 example output--> 4 (1,2,1,2)
		arr.add(0);
		arr.add(1);
		arr.add(2);
		arr.add(1);
		arr.add(2);
		arr.add(3);

		//2 example output--> 12
		/*
		 * arr.add(195593459); arr.add(195593459); arr.add(195593458);
		 * arr.add(195593457); arr.add(195593459); arr.add(195593459);
		 * arr.add(195593458); arr.add(195593459); arr.add(195593458);
		 * arr.add(195593459); arr.add(195593457); arr.add(195593458);
		 * arr.add(195593458); arr.add(195593457); arr.add(195593457);
		 * arr.add(195593457); arr.add(195593457); arr.add(195593458);
		 * arr.add(195593457); arr.add(195593459); arr.add(195593457);
		 * arr.add(195593457); arr.add(195593458); arr.add(195593457);
		 * arr.add(195593457); arr.add(195593458); arr.add(195593458);
		 * arr.add(195593457); arr.add(195593458); arr.add(195593457);
		 * arr.add(195593457); arr.add(195593457); arr.add(195593459);
		 * arr.add(195593459); arr.add(195593459); arr.add(195593458);
		 * arr.add(195593458); arr.add(195593458); arr.add(195593458);
		 * arr.add(195593458); arr.add(195593457); arr.add(195593459);
		 * arr.add(195593459); arr.add(195593458); arr.add(195593457);
		 * arr.add(195593459); arr.add(195593459); arr.add(195593457);
		 * arr.add(195593459); arr.add(195593459); arr.add(195593457);
		 * arr.add(195593457); arr.add(195593459); arr.add(195593459);
		 * arr.add(195593457); arr.add(195593459); arr.add(195593458);
		 * arr.add(195593458); arr.add(195593458); arr.add(195593457);
		 * arr.add(195593458); arr.add(195593458); arr.add(195593458);
		 * arr.add(195593458); arr.add(195593457); arr.add(195593458);
		 * arr.add(195593459); arr.add(195593458); arr.add(195593459);
		 * arr.add(195593458); arr.add(195593459); arr.add(195593458);
		 * arr.add(195593458); arr.add(195593459); arr.add(195593459);
		 * arr.add(195593458); arr.add(195593457); arr.add(195593459);
		 * arr.add(195593459); arr.add(195593459); arr.add(195593459);
		 * arr.add(195593457); arr.add(195593459); arr.add(195593459);
		 * arr.add(195593459); arr.add(195593459); arr.add(195593459);
		 * arr.add(195593457); arr.add(195593459); arr.add(195593457);
		 * arr.add(195593458); arr.add(195593457); arr.add(195593458);
		 * arr.add(195593458); arr.add(195593457); arr.add(195593459);
		 * arr.add(195593457); arr.add(195593457); arr.add(195593459);
		 * arr.add(195593457); arr.add(195593459); arr.add(195593459);
		 * arr.add(195593458); arr.add(195593457); arr.add(195593459);
		 * arr.add(195593458); arr.add(195593459); arr.add(195593459);
		 * arr.add(195593458); arr.add(195593458); arr.add(195593459);
		 * arr.add(195593458); arr.add(195593459); arr.add(195593458);
		 * arr.add(195593457); arr.add(195593459); arr.add(195593458);
		 * arr.add(195593457); arr.add(195593457); arr.add(195593457);
		 * arr.add(195593458); arr.add(195593457); arr.add(195593459);
		 * arr.add(195593457); arr.add(195593458); arr.add(195593459);
		 * arr.add(195593458); arr.add(195593458); arr.add(195593459);
		 * arr.add(195593457); arr.add(195593459); arr.add(195593459);
		 * arr.add(195593459); arr.add(195593458); arr.add(195593459);
		 * arr.add(195593458); arr.add(195593458); arr.add(195593459);
		 * arr.add(195593458); arr.add(195593459); arr.add(195593458);
		 * arr.add(195593457); arr.add(195593457); arr.add(195593457);
		 * arr.add(195593459); arr.add(195593458); arr.add(195593459);
		 * arr.add(195593458); arr.add(195593457);
		 */

		//3 example output--> 4 (3,3,2,2)
		/*
		 * arr.add(1); arr.add(1); arr.add(1); arr.add(3); arr.add(3); arr.add(2);
		 * arr.add(2);
		 */

		System.out.println(longestSubarray(arr));
	}

	public static int longestSubarray(List<Integer> arr) {
		List<Integer> maxLengths = new ArrayList<>();

		for (int index = 0; index < arr.size(); index++) {
			for (int j = index + 1; j < arr.size(); j++) {
				recordMaxLength(maxLengths, arr, index, j);
			}
		}
		return Collections.max(maxLengths).intValue();
	}

	static void recordMaxLength(List<Integer> maxLengths, List<Integer> arr, int startIndex, int endIndex) {
		ArraysUtil.display(arr, startIndex, endIndex);

		Set<Integer> set = new HashSet<>();
		boolean isCandidate = true;
		for (int i = startIndex; i + 1 <= endIndex; i++) {
			int value1 = arr.get(i);
			int value2 = arr.get(i + 1);

			int diff = Math.abs(value1 - value2);
			if (diff <= 1) {
				if (diff == 0) {
					set.add(arr.get(i));
				}
				if (diff == 1) {
					set.add(arr.get(i));
					set.add(arr.get(i + 1));
				}
			} else {
				isCandidate = false;
				break;
			}
		}

		if (set.size() == 2 && isCandidate) {
			// System.out.println("Length = " + ((endIndex - startIndex) + 1));
			maxLengths.add((endIndex - startIndex) + 1);
		}
	}

}
