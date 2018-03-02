package com.utils;

import java.util.ArrayList;

public class Model {

	private Vertex[] vertices;
	private ArrayList<myLine2D> lines = new ArrayList<myLine2D>();

	public Model(Vertex[] vertices) {

		this.vertices = vertices;

		createLines();
	}

	public void createLines() {

		for (int i = 0; i < vertices.length; i++) {
			lines.add(new myLine2D(vertices[i].getX(), vertices[i].getY(),
					vertices[i + 1].getX(), vertices[i + 1].getY()));
		}
	}

	public Vertex[] getVertices() {
		return vertices;
	}

	public ArrayList<myLine2D> getLines() {
		return lines;
	}

}
