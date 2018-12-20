package com.moonspirit.corejava.ch06.comparator;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {
	@Override
	public int compare(String a, String b) {
		return Integer.compare(a.length(), b.length());
	}
}
