package com.moonspirit.corejava.ch14.interruptbounce;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	private static List<Thread> Threads = new ArrayList<>();
	private BallComponent component;

	public BounceFrame() {
		component = new BallComponent();
		add(component, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", event -> addBall());
		addButton(buttonPanel, "Stop", event -> stopBall());
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
			}
		};
		Thread thread = new Thread(runnable);
		Threads.add(thread);
		thread.start();
	}

	public void stopBall() {
		Iterator<Thread> iter = Threads.iterator();
		while (iter.hasNext()) {
			iter.next().interrupt();
			iter.remove();
		}
	}
}
