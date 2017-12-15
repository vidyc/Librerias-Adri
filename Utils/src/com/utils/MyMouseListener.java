package com.utils;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class MyMouseListener extends MouseInputAdapter {

	Rectangle currentRect;

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		currentRect = new Rectangle(x, y, 0, 0);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	public void updateSize(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

	}

}
