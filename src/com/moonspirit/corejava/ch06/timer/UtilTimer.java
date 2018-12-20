package com.moonspirit.corejava.ch06.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class UtilTimer {
	public static void main(String[] args) {
		Timer t = new Timer();
		t.schedule(new PrinterTask(), 0, 10000);
//		t.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				System.out.println("The time is " + new Date());
//			}
//		}, 0, 10000);
	}
}

class PrinterTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("The time is " + new Date());
	}
}
