package com.utils;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Utils {

	public static float randFloat(float min, float max) {
		Random r = new Random();
		float i = r.nextFloat() * (max - min) + min;
		return i;
	}

	public static int randInt(int max) {
		Random r = new Random();
		int i = r.nextInt(max);
		return i;
	}

	public static JFrame setJFrame(JFrame frame, JPanel panel, String title,
			int width, int height) {

		// frame.pack();
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.add(panel);
		frame.setVisible(true);

		return frame;

	}

	public static float map(float value, float start1, float stop1,
			float start2, float stop2) {
		return start2 + (stop2 - start2)
				* ((value - start1) / (stop1 - start1));
	}

}
