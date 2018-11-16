package com.moonspirit.corejava.ch04;

import java.time.LocalDate;

/**
 * 
 * @ClassName      PrintDateTable
 * @Description    打印当前月的日历表
 *                 LocalData 类的使用
 *                 corejava 10th 4.3
 *
 * @author         moonspirit
 * @date           2018年11月14日 下午5:32:44
 * @version        1.0.0
 */
public class PrintDateTable {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();

		LocalDate date = LocalDate.of(year, month, 1);
		int week = date.getDayOfWeek().getValue();

		System.out.println("                    " + year + "/" + month);
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		for (int i = 1; i < week; i++) {
			System.out.print("    ");
		}
		while (date.getMonthValue() == month) {
			System.out.printf("%3d", date.getDayOfMonth());
			if (date.getDayOfMonth() == today.getDayOfMonth()) {
				System.out.print("*");
			} else {
				System.out.print(" ");
			}
			date = date.plusDays(1);
			if (date.getDayOfWeek().getValue() == 1) {
				System.out.println();
			}
		}
		if (date.getDayOfWeek().getValue() != 1) {
			System.out.println();
		}
	}
}
