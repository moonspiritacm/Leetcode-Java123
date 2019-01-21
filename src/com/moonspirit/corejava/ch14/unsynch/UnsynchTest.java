package com.moonspirit.corejava.ch14.unsynch;

public class UnsynchTest {
	public static final int N = 100;
	public static final double INITIAL_BALANCE = 1000;
	public static final double MAX_AMOUNT = 1000;
	public static final int DELAY = 10;

	public static void main(String[] args) {
		Bank bank = new Bank(N, INITIAL_BALANCE);
		for (int i = 0; i < N; i++) {
			int fromAccount = i;
			Runnable r = () -> {
				try {
					while (true) {
						int toAccount = (int) (bank.size() * Math.random());
						double amount = MAX_AMOUNT * Math.random();
						bank.transfer(fromAccount, toAccount, amount);
						Thread.sleep((int) (DELAY * Math.random()));
					}
				} catch (Exception e) {
				}
			};
			Thread thread = new Thread(r);
			thread.start();
		}
	}
}
