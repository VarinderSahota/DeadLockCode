package com.practice.hackerrank;

public class NestedClassTest {

	class NestClass {
		public void show() {
			if (NestedClassTest.this.flag) {
				display();
			}
		}
	}

	private boolean flag = true;

	public void display() {
		System.out.println("hello");
	}

	public void innerClass() {
		new NestClass().show();
	}

	public static void main(String[] args) {

		NestedClassTest obj = new NestedClassTest();
		obj.innerClass();
	}

}
