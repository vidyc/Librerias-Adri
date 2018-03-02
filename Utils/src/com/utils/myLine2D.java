package com.utils;

import java.awt.Color;
import java.awt.Point;

public class myLine2D {

	public float size;
	public float x1, y1, x2, y2;
	public Color color = Color.gray;

	public myLine2D(Point a, Point b, float size, Color color) {
		this.size = size;
		this.x1 = a.x;
		this.y1 = a.y;
		this.x2 = b.x;
		this.y2 = b.y;
		this.color = color;
	}

	public myLine2D(float x1, float y1, float x2, float y2) {

		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		color = Color.black;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

}
