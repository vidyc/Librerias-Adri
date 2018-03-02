package com.utils;

public class NeuralNetwork {

	private int input_nodes;
	private int hidden_nodes;
	private int ouput_nodes;
	private Matrix weights1, weights2, bias1, bias2;
	private float lr = 0.1f;

	public NeuralNetwork(int input_nodes, int hidden_nodes, int output_nodes) {
		this.input_nodes = input_nodes;
		this.hidden_nodes = hidden_nodes;
		this.ouput_nodes = output_nodes;

		weights1 = new Matrix(hidden_nodes, input_nodes, "Weights1");
		weights2 = new Matrix(output_nodes, hidden_nodes, "Weights2");

		bias1 = new Matrix(hidden_nodes, 1, "Bias1");
		bias2 = new Matrix(output_nodes, 1, "Bias2");

		weights1.randomize();
		weights2.randomize();

		bias1.randomize();
		bias2.randomize();

		weights1.print();
		weights2.print();

		bias1.print();

	}

	public float[] feedforward(Matrix inputs) {
		return guess(inputs);
	}

	public float[] feedforward(float[] inputs) {
		Matrix inputos = Matrix.fromArray(inputs);
		return guess(inputos);
	}

	private float[] guess(Matrix inputs) {
		Matrix hidden = Matrix.multMatrix(weights1, inputs);
		hidden.setName("Hidden");
		hidden.add(bias1);

		for (int i = 0; i < hidden.matrix.length; i++) {
			for (int j = 0; j < hidden.matrix[0].length; j++) {
				hidden.matrix[i][j] = sigmoid(hidden.matrix[i][j]);
			}
		}

		// hidden.print();

		Matrix output = Matrix.multMatrix(weights2, hidden);
		output.setName("Output");
		output.add(bias2);

		for (int i = 0; i < output.matrix.length; i++) {
			for (int j = 0; j < output.matrix[0].length; j++) {
				output.matrix[i][j] = sigmoid(output.matrix[i][j]);
			}
		}

		float[] answer = output.toArray();

		System.out.println("Output: ");

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}

		return answer;

	}

	public void train(Matrix inputs, float[] target) {

		Matrix hidden = Matrix.multMatrix(weights1, inputs);
		hidden.add(bias1);

		for (int i = 0; i < hidden.matrix.length; i++) {
			for (int j = 0; j < hidden.matrix[0].length; j++) {
				hidden.matrix[i][j] = sigmoid(hidden.matrix[i][j]);
			}
		}

		Matrix output = Matrix.multMatrix(weights2, hidden);
		output.add(bias2);

		for (int i = 0; i < output.matrix.length; i++) {
			for (int j = 0; j < output.matrix[0].length; j++) {
				output.matrix[i][j] = sigmoid(output.matrix[i][j]);
			}
		}

		Matrix targets = Matrix.fromArray(target);

		Matrix errors1 = Matrix.subtract(targets, output);

		Matrix gradient = new Matrix(output.matrix.length,
				output.matrix[0].length);

		for (int i = 0; i < output.matrix.length; i++) {
			for (int j = 0; j < output.matrix[0].length; j++) {
				gradient.matrix[i][j] = output.matrix[i][j]
						* (1 - output.matrix[i][j]);
			}
		}

		gradient.mult(errors1);
		gradient.mult(lr);

		Matrix T_hidden = Matrix.transpose(hidden);
		Matrix weights2_deltas = Matrix.multMatrix(gradient, T_hidden);

		weights2.add(weights2_deltas);
		bias2.add(gradient);

		Matrix T_weights2 = Matrix.transpose(weights2);
		Matrix hidden_errors = Matrix.multMatrix(T_weights2, errors1);

		Matrix hidden_gradient = new Matrix(hidden.matrix.length,
				hidden.matrix[0].length);

		for (int i = 0; i < hidden.matrix.length; i++) {
			for (int j = 0; j < hidden.matrix[0].length; j++) {
				hidden_gradient.matrix[i][j] = hidden.matrix[i][j]
						* (1 - hidden.matrix[i][j]);
			}
		}

		hidden_gradient.mult(hidden_errors);
		hidden_gradient.mult(lr);

		Matrix T_inputs = Matrix.transpose(inputs);
		Matrix weights1_deltas = Matrix.multMatrix(hidden_gradient, T_inputs);

		weights1.add(weights1_deltas);
		bias1.add(hidden_gradient);
	}

	public float sigmoid(float i) {
		float output = 0;

		// output = (float) (Math.pow(Math.E, i) / (Math.pow(Math.E, i) + 1));
		output = (float) (1 / (1 + Math.pow(Math.E, i)));

		return output;

	}

	public float dsigmoid(float i) {
		float output = 0;

		output = sigmoid(i) * (1 - sigmoid(i));

		return output;

	}

}
