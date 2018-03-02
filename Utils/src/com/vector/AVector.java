package com.vector;

import com.utils.Utils;

public class AVector {

	public float x, y, z;

	public AVector() {

		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	public AVector(float x, float y) {

		this.x = x;
		this.y = y;
		this.z = 0;
	}

	public AVector(double x, double y) {

		this.x = (float) x;
		this.y = (float) y;
		this.z = 0;
	}

	public AVector(AVector v) {

		this.x = v.x;
		this.y = v.y;
		this.z = 0;
	}

	public AVector(float x, float y, float z) {

		this.x = x;
		this.y = y;
		this.z = z;
	}

	public AVector(double x, double y, double z) {

		this.x = (float) x;
		this.y = (float) y;
		this.z = (float) z;
	}

	public AVector add(AVector vec) {
		x += vec.x;
		y += vec.y;
		z += vec.z;

		return this;
	}

	public AVector sub(AVector vec) {
		x -= vec.x;
		y -= vec.y;
		z -= vec.z;

		return this;
	}

	public AVector mult(float i) {
		x *= i;
		y *= i;
		z *= i;

		return this;
	}

	public AVector div(float i) {
		x /= i;
		y /= i;
		z /= i;

		return this;
	}

	public static AVector div(AVector a, float b) {
		a.get().div(b);

		return a;
	}

	public AVector normalize() {

		float mag = this.mag();

		x /= mag;
		y /= mag;
		z /= mag;

		return this;

	}

	public float dist(AVector vec) {
		float x = this.x - vec.x;
		float y = this.y - vec.y;
		float z = this.z - vec.z;
		float dist = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)
				+ Math.pow(z, 2));

		return dist;

	}

	public float mag() {
		float mag = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)
				+ Math.pow(z, 2));

		return mag;
	}

	public AVector setMag(float i) {
		this.normalize();
		this.mult(i);

		return this;
	}

	public AVector limit(float i) {
		float r = i / this.mag();

		if (r <= 1) {
			this.setMag(i);
		}

		return this;

	}

	public static AVector random2D() {

		float x = Utils.randFloat(-1, 1);
		float y = Utils.randFloat(-1, 1);
		AVector a = new AVector(x, y);
		a.normalize();

		return a;

	}

	public static AVector absRandom2D() {

		float x = Math.abs(Utils.randFloat(-1, 1));
		float y = Math.abs(Utils.randFloat(-1, 1));
		AVector a = new AVector(x, y);
		a.normalize();

		return a;

	}

	public static AVector random3D() {

		float x = Utils.randFloat(-1, 1);
		float y = Utils.randFloat(-1, 1);
		float z = Utils.randFloat(-1, 1);
		AVector a = new AVector(x, y, z);
		a.normalize();

		return a;

	}

	public AVector setSize2D(float x, float y) {
		this.x = x;
		this.y = y;

		return this;
	}

	public AVector setSize3D(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;

		return this;
	}

	public AVector get() {
		float f = this.x;
		float h = this.y;
		float g = this.z;
		AVector z = new AVector(f, h, g);
		return z;
	}

	public float heading() {
		float angle = (float) Math.atan2(y, x);
		return angle;
	}

	public boolean intersects(AVector pos, float width, float height) {
		if (this.x >= pos.x && this.x <= pos.x + (width) && this.y >= pos.y
				&& this.y <= pos.y + (height)) {

			return true;

		} else
			return false;
	}
}
