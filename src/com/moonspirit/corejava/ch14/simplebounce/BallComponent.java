package com.moonspirit.corejava.ch14.simplebounce;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BallComponent extends JPanel {
	private static final long serialVersionUID = 7417283919282458999L;
	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 350;
	private List<Ball> balls = new ArrayList<>();

	public void add(Ball ball) {
		balls.add(ball);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gg = (Graphics2D) g;
		for (Ball ball : balls) {
			gg.fill(ball.getShape());
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
