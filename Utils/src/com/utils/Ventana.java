package com.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Ventana extends JPanel implements Runnable {

	public static final long serialVersionUID = 1L;

	protected JFrame frame;
	private boolean running;

	private final static int WIDTH = 800;
	private final static int HEIGHT = 500;

	public Ventana() {
		frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		size(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		frame.setLayout(new BorderLayout());
		setLayout(new GridBagLayout());

		frame.setContentPane(this);
		frame.setVisible(true);

	}

	protected synchronized void start() {
		running = true;
		new Thread(this).start();
	}

	private synchronized void stop() {
		running = false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		render(g);
	}

	public void render(Graphics g) {

	}

	public void update() {

	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerUpdate = 1000000000D / 60D;

		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerUpdate;
			lastTime = now;

			while (delta >= 1) {

				update();
				delta -= 1;
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			repaint();

		}
	}

	public void size(float width, float height) {

		frame.setSize((int) width, (int) height);
		frame.setLocationRelativeTo(null);

	}

	public void title(String s) {
		frame.setTitle(s);
	}

	public void background() {
		setBackground(new Color(0, 0, 0));
	}

	public void background(Color color) {
		setBackground(color);
	}

	public void background(int r, int g, int b) {
		setBackground(new Color(r, g, b));
	}

	public void background(int r, int g, int b, int a) {
		setBackground(new Color(r, g, b, a));
	}

}
