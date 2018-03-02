package com.utils;

import java.awt.Color;
import java.awt.Point;

public class myPoint extends Point {

	private static final long serialVersionUID = 1L;
	public float x;
	public float y;
	public float size;
	public Color color;

	public myPoint(float x, float y, float size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}

	public myPoint(Point p, float size, Color color) {

		this.x = (float) p.getX();
		this.y = (float) p.getY();
		this.size = size;
		this.color = color;
	}

}
