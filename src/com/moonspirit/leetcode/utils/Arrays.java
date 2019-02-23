package com.moonspirit.leetcode.utils;

public class Arrays {
	public static char[] stringToCharArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0)
			return new char[0];

		String[] parts = input.split(",");
		char[] output = new char[parts.length];
		for (int i = 0; i < parts.length; i++)
			output[i] = parts[i].trim().charAt(0);
		return output;
	}

	public static char[][] stringToChar2dArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0)
			return new char[0][0];

		String[] parts = input.split("],");
		char[][] output = new char[parts.length][];
		for (int i = 0; i < parts.length - 1; i++) {
			output[i] = stringToCharArray(parts[i] + "]");
		}
		output[parts.length - 1] = stringToCharArray(parts[parts.length - 1]);
		return output;
	}
}
