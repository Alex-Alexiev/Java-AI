package perceptron;

import vector.Vector;

public class Neuron {
	
	Vector weights;
	
	public Neuron(int inputSize) {
		double[] weightsArr = new double[inputSize];
		for (int i = 0; i < inputSize; i++) {
			weightsArr[i] = Math.random()*2-1;
		}
		weights = new Vector(weightsArr);
	}

	public int feed(Vector inputs) throws Exception{
		return activation(inputs.dot(weights));
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
	
	public int activation(double x) {
		if (x > 0) return 1;
		else return -1;
	}
	
}
