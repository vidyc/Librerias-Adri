package com.utils;

import java.util.Arrays;

public class Matrix {

	public float[] matrix[];
	public String name;

	public Matrix(int rows, int columns) {

		this.matrix = new float[rows][columns];

		for (int i = 0; i < rows; i++) {
			this.matrix[i] = new float[columns];

		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;

			}
		}

	}

	public Matrix(int rows, int columns, String name) {

		this.matrix = new float[rows][columns];

		for (int i = 0; i < rows; i++) {
			this.matrix[i] = new float[columns];

		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;

			}
		}

		this.name = name;

	}

	public void randomize() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = Utils.randInt(3) - 1;
			}
		}
	}

	public void add(float num) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] += num;
			}
		}

	}

	public void sub(float num) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] -= num;
			}
		}

	}

	public void mult(float num) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] *= num;
			}
		}

	}

	public void div(float num) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] /= num;
			}
		}

	}

	public void add(Matrix m) {
		if (matrix.length == m.matrix.length
				&& matrix[0].length == m.matrix[0].length) {

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] += m.matrix[i][j];
				}
			}
		}

		else {
			System.out.println("The matrices don't have the same size!");
		}
	}

	public void sub(Matrix m) {
		if (matrix.length == m.matrix.length
				&& matrix[0].length == m.matrix[0].length) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] -= m.matrix[i][j];
				}
			}

		}

		else {
			System.out.println("The matrices don't have the same size!");
		}

	}

	public void mult(Matrix m) {
		if (matrix.length == m.matrix.length
				&& matrix[0].length == m.matrix[0].length) {

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] *= m.matrix[i][j];
				}
			}
		}

		else {
			System.out.println("The matrices don't have the same size!");
		}

	}

	public void div(Matrix m) {
		if (matrix.length == m.matrix.length
				&& matrix[0].length == m.matrix[0].length) {

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] /= m.matrix[i][j];
				}
			}
		}

		else {
			System.out.println("The matrices don't have the same size!");
		}

	}

	public static Matrix subtract(Matrix a, Matrix b) {

		Matrix output = new Matrix(a.matrix.length, a.matrix[0].length);

		if (a.matrix.length == b.matrix.length
				&& a.matrix[0].length == b.matrix[0].length) {
			for (int i = 0; i < a.matrix.length; i++) {
				for (int j = 0; j < a.matrix[0].length; j++) {
					output.matrix[i][j] = a.matrix[i][j] - b.matrix[i][j];
				}
			}
			return output;
		}

		else {
			System.out.println("The matrices don't have the same size!");
			return null;
		}

	}

	public static Matrix multMatrix(Matrix m, Matrix m2) {
		Matrix mate = null;
		if (m.matrix[0].length != m2.matrix.length) {
			System.out
					.println("WARNING!! The columns of matrix A don't match the rows of matrix B!");

			return null;
		} else {
			mate = new Matrix(m.matrix.length, m2.matrix[0].length);

			for (int i = 0; i < mate.matrix.length; i++) {
				for (int j = 0; j < mate.matrix[0].length; j++) {

					for (int z = 0; z < m.matrix[0].length; z++) {

						mate.matrix[i][j] += m.matrix[i][z] * m2.matrix[z][j];
					}

				}
			}
			return mate;
		}

	}

	public void transpose() {

		Matrix result = new Matrix(matrix[0].length, matrix.length);

		for (int i = 0; i < result.matrix.length; i++) {
			for (int j = 0; j < result.matrix[0].length; j++) {
				result.matrix[i][j] = matrix[j][i];
			}
		}

		matrix = result.matrix;

	}

	public static Matrix transpose(Matrix m) {

		Matrix result = new Matrix(m.matrix[0].length, m.matrix.length);

		for (int i = 0; i < result.matrix.length; i++) {
			for (int j = 0; j < result.matrix[0].length; j++) {
				result.matrix[i][j] = m.matrix[j][i];
			}
		}

		return result;

	}

	public void setName(String string) {
		this.name = string;
	}

	public void print() {
		if (name != null)
			System.out.println(name + ": ");
		for (float[] array : matrix) {
			System.out.println(Arrays.toString(array));

		}
		System.out.println();
	}

	public static Matrix fromArray(float[] array) {

		Matrix matrix = new Matrix(array.length, 1);

		for (int i = 0; i < matrix.matrix.length; i++) {

			matrix.matrix[i][0] = array[i];

		}

		return matrix;

	}

	public float[] toArray() {

		float[] array = new float[matrix.length * matrix[0].length];
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				array[count++] = matrix[i][j];
			}
		}

		return array;
	}
}
