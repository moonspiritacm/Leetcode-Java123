package com.moonspirit.corejava.ch06.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

public class SwingTimer {
	public static void main(String[] args) {
//		Timer t = new Timer(10000, new TimePrinter());
		Timer t = new Timer(10000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("The time is " + new Date());
			}
		});
		t.start();
		while (true) {
		}
	}
}

class TimePrinter implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("The time is " + new Date());
	}
}
