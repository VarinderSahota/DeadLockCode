package com.practice.hackerrank;

import java.util.Objects;

public class RepeatedStrings {

	static long repeatedString(String s, long n) {

		long length = 0;
		long count = 0;
		if (!Objects.isNull(s)) {
			length = s.length();
		} else
			return 0;

		if (s.length() == 0 || n == 0) {
			return 0;
		}

		if (s.contains("a")) {
			if (length == 1) {
				return n;
			}

			count = countA(s);
			if (length == n) {
				return count;
			}

			if (length > n) {
				String st = s.substring(0, (int) n);
				count = countA(st);
				return count;
			}

			long quo = n / length;
			long remainder = n % length;
			count = (quo * count);

			if (remainder > 0) {
				String str = s.substring(0, (int) remainder);
				count = count + countA(str);
			}
		}
		return count;
	}

	private static long countA(String s) {
		long count = 0;
		char[] charArray = s.toCharArray();

		for (int j = 0; j < charArray.length; j++) {
			if (charArray[j] == 'a')
				count++;
		}

		return count;
	}

	/**
	 * Need to count 'a' from the created string. The string will be created at
	 * runtime by repeating the given string, keeping in mind that length of to be
	 * created string should not be > n. for example : Given string : abcac, n = 10
	 * --> Now the created string will be abcacabcac. which is having the length as
	 * n which 10. Now count the 'a' character.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		System.out.println(repeatedString("abcac", 10));
		System.out.println(repeatedString("a", 1000000000000l));
		System.out.println(repeatedString("ababa", 3));
		System.out.println(repeatedString("cfimaakj", 554045874191l));// output --> 138511468548
	}

}
