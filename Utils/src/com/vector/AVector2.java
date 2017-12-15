package com.vector;

import com.utils.Utils;

public class AVector2 {

	public float x, y;

	public AVector2(float x, float y) {

		this.x = x;
		this.y = y;
	}

	public AVector2 add(AVector2 vec) {
		x += vec.x;
		y += vec.y;

		return this;
	}

	public AVector2 sub(AVector2 vec) {
		x -= vec.x;
		y -= vec.y;

		return this;
	}

	public AVector2 mult(float i) {
		x *= i;
		y *= i;

		return this;
	}

	public AVector2 div(float i) {
		x /= i;
		y /= i;

		return this;
	}

	public static AVector2 div(AVector2 a, float b) {
		a.get().div(b);

		return a;
	}

	public AVector2 normalize() {

		float mag = this.mag();

		x /= mag;
		y /= mag;

		return this;

	}

	public float dist(AVector2 vec) {
		float x = this.x - vec.x;
		float y = this.y - vec.y;
		float dist = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

		return dist;

	}

	public float mag() {
		float mag = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

		return mag;
	}

	public AVector2 setMag(float i) {
		this.normalize();
		this.mult(i);

		return this;
	}

	public AVector2 limit(float i) {
		float r = i / this.mag();

		if (r <= 1) {
			this.setMag(i);
		}

		return this;

	}

	public static AVector2 random2D() {

		float x = Utils.randFloat(-1, 1);
		float y = Utils.randFloat(-1, 1);
		AVector2 a = new AVector2(x, y);
		a.normalize();

		return a;

	}

	public AVector2 get() {
		float f = this.x;
		float h = this.y;
		AVector2 z = new AVector2(f, h);
		return z;
	}

	public float heading() {
		float angle = (float) Math.atan2(y, x);
		return angle;
	}

	public boolean intersects(AVector2 pos, float width, float height) {
		if (this.x >= pos.x && this.x <= pos.x + (width) && this.y >= pos.y
				&& this.y <= pos.y + (height)) {

			return true;

		} else
			return false;
	}
}
