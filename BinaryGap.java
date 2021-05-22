package com.practice.codility.problems;

public class BinaryGap {

	final static String ONE = "1";

	public static void main(String[] args) {
		int n = 1041;
		int gapCount = binaryGapCount(n);
		System.out.println("Gap Count = " + gapCount);
	}

	private static int binaryGapCount(int n) {
		int gapCount = 1;
		String binary = Integer.toBinaryString(n);
		System.out.println(binary);
		if (binary.contains(ONE)) {
			int count = countOneOccurrences(binary);
			if (count >= 2) {
				if (count == 2) {
					int firstIndex = binary.indexOf("1");
					int secondIndex = binary.indexOf("1", firstIndex + 1);
					gapCount = secondIndex - firstIndex;
				} else {
					int[] indexes = new int[count];

					for (int index = 0; index < count; index++) {
						if (index == 0) {
							indexes[index] = binary.indexOf(ONE);
						} else {
							indexes[index] = binary.indexOf(ONE, indexes[index - 1] + 1);
						}
					}

					ArraysUtil.display(indexes);
					gapCount = countMaxGap(indexes);
				}
			}
		}
		return gapCount - 1;
	}

	private static int countMaxGap(int[] indexes) {
		int max = 0;
		int tempMax = 0;
		for (int index = 0; index < indexes.length - 1; index++) {
			tempMax = indexes[index + 1] - indexes[index];
			if (tempMax > max) {
				max = tempMax;
			}
		}
		return max;
	}

	private static int countOneOccurrences(String binary) {

		char[] binaryArray = binary.toCharArray();
		int count = 0;
		for (int index = 0; index < binaryArray.length; index++) {
			if (binaryArray[index] == '1') {
				count++;
			}
		}
		return count;
	}

}
