package com.practice.hackerrank;

public class JumpingOnClouds {

	static int jumpingOnClouds(int[] c) {

		if (c.length < 2)
			return 0;

		int jump = 0;
		for (int i = 0; i + 1 < c.length;) {

			if ((c.length - 1) - i >= 2) {
				if (c[i + 2] == 0) {
					jump++;
					i = i + 2;
				} else if (c[i + 1] == 0) {
					jump++;
					i = i + 1;
				}
			} else if ((c.length - 1) - i == 1) {
				if (c[i + 1] == 0) {
					jump++;
					i = i + 1;
				}
			}
		}
		return jump;
	}

	public static void main(String[] args) {
		System.out.println(jumpingOnClouds(new int[] { 0, 0, 1, 0, 0, 1, 0 }));
		System.out.println(jumpingOnClouds(new int[] { 0, 0, 0, 1, 0, 0 }));
	}

}
