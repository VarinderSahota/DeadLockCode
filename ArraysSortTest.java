package com.practice.hackerrank;

import java.util.Arrays;
import java.util.Comparator;

import com.practice.codility.problems.ArraysUtil;

public class ArraysSortTest implements Comparator<String>{
	
	public static void main(String[] args) {
		ArraysSortTest obj = new ArraysSortTest();
		String[] cities = new String[]{"Bangalore", "Pune", "San Francisco", "New York City"};
		Arrays.sort(cities, obj);
		ArraysUtil.display(cities);
		System.out.println(Arrays.binarySearch(cities, "New York City"));
	}

	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}
}
