package com.utils;

import java.awt.Color;

import com.vector.AVector;

public class Vertex {

	private float x, y;
	private Color color;

	public Vertex() {

		x = 0;
		y = 0;
		color = Color.black;
	}

	public Vertex(float x, float y) {
		this.x = x;
		this.y = y;
		color = Color.black;
	}

	public Vertex(AVector pos) {
		this.x = pos.x;
		this.y = pos.y;
		color = Color.black;
	}

	public Vertex(float x, float y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public Vertex(AVector pos, Color color) {
		this.x = pos.x;
		this.y = pos.y;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setPosition(AVector pos) {
		this.x = pos.x;
		this.y = pos.y;
	}

	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}

}
