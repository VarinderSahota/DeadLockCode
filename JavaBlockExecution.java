package com.practice.codility.problems;

public class JavaBlockExecution {

	static {
		System.out.println("In static ");
	}

	public JavaBlockExecution() {
		super();
		System.out.println("In constructor");
	}

	{
		System.out.println("In inin 1");
	}
	{
		System.out.println("In init 2");
	}

	public static void main(String[] args) {
		JavaBlockExecution ojj1 = new JavaBlockExecution();
		JavaBlockExecution obj2 = new JavaBlockExecution();

	}

}
