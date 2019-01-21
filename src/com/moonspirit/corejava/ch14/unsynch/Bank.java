package com.moonspirit.corejava.ch14.unsynch;

import java.util.Arrays;

public class Bank {
	private final double[] accounts;

	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		Arrays.fill(accounts, initialBalance);
	}

	public void transfer(int from, int to, double amount) {
		if (accounts[from] < amount)
			return;

		System.out.printf("%s --- Transfer List: %d-%.2f %d-%.2f %.2f\n", Thread.currentThread(), from, accounts[from],
				to, accounts[to], amount);
		accounts[from] -= amount;
		System.out.println(Thread.currentThread());
		System.out.println(Thread.currentThread());
		accounts[to] += amount;
		System.out.printf("%s --- Transfer Result: %.2f %.2f\n", Thread.currentThread(), accounts[from], accounts[to]);
		System.out.printf("%s --- Total Balance: %.2f\n", Thread.currentThread(), getTotalBalance());
	}

	public double getTotalBalance() {
		double sum = 0;
		for (double account : accounts)
			sum += account;
		return sum;
	}

	public int size() {
		return accounts.length;
	}
}
