package com.practice.hackerrank;

public class MinimumBribes {

	static void minimumBribes(int[] q) {
		int count = 0;
		String result = "Too chaotic";
		boolean isBreak = false;

		for (int i = 0; i < q.length; i++) {
			int currentPosition = i + 1;
			if (currentPosition != q[i]) {
				int bribe = Math.abs(q[i] - currentPosition);
				if (bribe > 2) {
					isBreak = true;
					break;
				}
			}

			for (int j = i + 1; j < q.length; j++) {
				int temp = 0;
				if (q[i] > q[j]) {
					temp = q[i];
					q[i] = q[j];
					q[j] = temp;
					count++;
				}
			}
		}

		if (isBreak)
			System.out.println(result);
		else
			System.out.println(count);
	}

	public static void main(String[] args) {

		minimumBribes(new int[] { 1, 2, 3, 5, 4, 6, 7, 8 });
		minimumBribes(new int[] { 4, 1, 2, 3 });

		minimumBribes(new int[] { 2, 1, 5, 3, 4 });
		minimumBribes(new int[] { 2, 5, 1, 3, 4 });

		minimumBribes(new int[] { 5, 1, 2, 3, 7, 8, 6, 4 });

		minimumBribes(new int[] { 1, 2, 5, 3, 7, 8, 6, 4 });

	}
}
