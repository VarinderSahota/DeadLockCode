package com.practice.codility.problems;

public class MinimalFrogJump {

	public static int solution(int X, int Y, int D) {
		
		double jumps = (double) (Y - X) / D;
		return (int) Math.ceil(jumps);
    }

	public static void main(String[] args) {
		System.out.println("value = "+solution(1, 5, 2));
		
		System.out.println("value = "+solution(10, 85, 30));

	}

}
