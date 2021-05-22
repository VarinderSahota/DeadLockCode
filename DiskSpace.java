package com.practice.hackerrank;

import java.util.HashSet;
import java.util.Set;

public class DiskSpace {

	public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {

		boolean result = false;

		if (blockSize >= 1 && blockSize <= 1000000 && fileSize >= 1 && fileSize <= 1000000
				&& occupiedSectors.size() <= 1000000) {

			if (occupiedSectors.size() < 2) {
				int availableSize = blockSize;
				availableSize = availableSize - occupiedSectors.size();

				if (fileSize <= availableSize)
					return true;
			}

			int continuosSectors = blockSize;
			int[] array = occupiedSectors.stream().mapToInt(Integer::intValue).toArray();

			for (int index = 0; index + 1 < array.length; index++) {
				continuosSectors = (array[index + 1] - array[index]) - 1;
				if (fileSize <= continuosSectors)
					result = true;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(isWritable(1, 1, new HashSet<>()));
		Set<Integer> occupiedSpace = new HashSet<Integer>();
		occupiedSpace.add(1);
		System.out.println(isWritable(1, 1, occupiedSpace));
		occupiedSpace = new HashSet<Integer>();
		occupiedSpace.add(1);
		occupiedSpace.add(4);
		System.out.println(isWritable(4, 2, occupiedSpace));

	}
}
