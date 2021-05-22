package com.practice.codility.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class HireVueDatacomQuestion {
	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			if (!Objects.isNull(line) && line.length() > 0) {
				char[] sortedArray = sort(line.toLowerCase());
				Map<Character, Integer> countMap = countOccurences(sortedArray);
				StringBuilder result = new StringBuilder();
				Set<Character> set = new HashSet();
				for (char ch : sortedArray) {
					if (set.add(ch)) {
						result.append(ch).append(countMap.get(ch));
					}
				}
				System.out.println(result.toString());
			} else {
				System.out.println("Invalid input, please check.");
			}
		}
	}

	private static Map<Character, Integer> countOccurences(char[] charArray) {
		Map<Character, Integer> countMap = new HashMap<>();
		for (char ch : charArray) {
			if (Objects.isNull(countMap.get(ch))) {
				countMap.put(ch, 1);
			} else {
				int count = countMap.get(ch);
				countMap.put(ch, count + 1);
			}
		}
		return countMap;
	}

	private static char[] sort(String input) {
		char[] charArray = input.toCharArray();
		Arrays.sort(charArray);
		return charArray;
	}
}