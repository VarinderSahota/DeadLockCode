package com.practice.hackerrank;

import java.util.Objects;

public class CountingValleys {

	public static int countingValleys(int steps, String path) {

		int valley = 0;
		int seaLevel = 0;

		if (steps < 2 || Objects.isNull(path) || path.length() < 2)
			return 0;

		char[] charArray = path.toCharArray();

		for (int i = 0; i < charArray.length; i++) {

			if (seaLevel == -1 && charArray[i] == 'U') {
				valley = valley + 1;
			}

			if (charArray[i] == 'D') {
				seaLevel = seaLevel - 1;
			} else if (charArray[i] == 'U') {
				seaLevel = seaLevel + 1;
			}
		}

		return valley;
	}

	public static void main(String[] args) {
		System.out.println(countingValleys(8, "UDDDUDUU"));
		System.out.println(countingValleys(12, "DDUUDDUDUUUD"));

	}

}
