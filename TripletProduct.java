package com.practice.codility.problems;

public class TripletProduct {

	public int solution(int[] A) {
		int curProduct = 1;
		int maxProduct = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				for (int k = i + 2; k < A.length; k++) {

					if (i < j && j < k) {
						curProduct = A[i] * A[j] * A[k];
						//System.out.println("Pair { " + A[i] + " " + A[j] + " " + A[k] + "} = " + curProduct);

						if (maxProduct < curProduct)
							maxProduct = curProduct;
					}
				}
			}
		}
		return maxProduct;
	}

	public static void main(String[] args) {
		TripletProduct obj = new TripletProduct();
		System.out.println(obj.solution(new int[] { -3, 1, 2, -2, 5, 6 }));
		System.out.println(obj.solution(new int[] { 10, 10, 10 }));
		System.out.println(obj.solution(new int[] { -10, -2, -4 }));

	}

}
