package com.moonspirit.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

public class Arrays {
	public static List<String> stringToStringList(String input) {
		List<String> output = new ArrayList<>();
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0)
			return output;

		String[] parts = input.split(",");
		for (int i = 0; i < parts.length; i++)
			output.add(parts[i].trim());
		return output;
	}

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

	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0)
			return new int[0];

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int i = 0; i < parts.length; i++)
			output[i] = Integer.parseInt(parts[i].trim());
		return output;
	}

	public static void qSort(int[] a, int low, int high) {
		int l = low;
		int h = high;
		int key = a[low];

		while (l < h) {
			while (l < h && a[h] >= key)
				h--;
			a[l] = a[h];

			while (l < h && a[l] <= key)
				l++;
			a[h] = a[l];
		}
		a[h] = key;
		if (low < l)
			qSort(a, low, l - 1);
		if (h < high)
			qSort(a, h + 1, high);
	}
}