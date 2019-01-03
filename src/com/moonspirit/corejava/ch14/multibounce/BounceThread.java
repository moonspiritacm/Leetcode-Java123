package com.moonspirit.corejava.ch14.multibounce;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceThread {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame jframe = new BounceFrame();
			jframe.setTitle("BounceThread");
			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jframe.setVisible(true);
		});
	}
}

class BounceFrame extends JFrame {
	private static final long serialVersionUID = 2134381405494329413L;
	private static final int STEPS = 1000;
	private static final int DELAY = 3;
	private BallComponent component;

	public BounceFrame() {
		component = new BallComponent();
		add(component, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", event -> addBall());
		addButton(buttonPanel, "Close", event -> System.exit(0));
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}

	public void addButton(Container container, String title, ActionListener listener) {
		JButton button = new JButton(title);
		container.add(button);
		button.addActionListener(listener);
	}

	public void addBall() {
		Ball ball = new Ball();
		component.add(ball);
		Runnable runnable = () -> {
			try {
				for (int i = 1; i <= STEPS; i++) {
					ball.move(component.getBounds());
					component.repaint();
					Thread.sleep(DELAY);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
