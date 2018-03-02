package com.utils;

import java.util.Random;

public class Screen extends Bitmap {
	Bitmap pene;

	Random random;

	public Screen(int width, int height) {
		super(width, height);

		random = new Random();
		pene = new Bitmap(256, 256);

		for (int i = 0; i < 256 * 256; i++) {
			pene.pixels[i] = random.nextInt();
		}

	}

	public void render() {

		draw(pene, 0, 0);

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public int[] getPixels() {
		return pixels;
	}
}
