package perceptron;

import vector.Vector;

public class Neuron {
	
	Vector weights;
	double bias;
	double learningRate = 0.4;
	
	public Neuron(int inputSize) {
		double[] weightsArr = new double[inputSize];
		for (int i = 0; i < inputSize; i++) {
			weightsArr[i] = Math.random()*2-1;
		}
		weights = new Vector(weightsArr);
		bias = Math.random()*400-200;
	}

	public int feed(Vector inputs) {
		return activation(inputs.dot(weights)+bias);
	}
	
	/*
	 * adjust weight
	 * derivate of error with respect to certain weight
	 * use chain rule to get delta rule
	 * 			write as derivative of error wrt output (y-o) * derivative of output wrt weight (x)
	 * wf = wi + deltaW
	 * deltaW = (label-feed)*input        (y-o)*x
	 * 
	 * do this over all the training samples
	 */
	
	public void train(DataPoint[] dataPoints) {
		for (DataPoint input : dataPoints) {
			int o = feed(input.getVector());
			double error = (o-input.getLabel())*learningRate;
			Vector weightDeltas = input.getVector().scalarMultiply(error);
			weights = weights.add(weightDeltas);
			bias += error;
		}
	}
	
	public int activation(double x) {
		if (x > 0) return 1;
		else return -1;
	}
	
}
