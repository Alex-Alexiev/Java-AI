package basic.neuralnetworks;

import vector.Vector;

public class SingleNeuronNetwork {
	
	private int numInputs;
	private Vector weights;
	
	public SingleNeuronNetwork(int numInputs){
		this.numInputs = numInputs;
		double[] weightsArray = new double[numInputs];
		for (int i = 0; i < numInputs; i++) {
			weightsArray[i] = Math.random();
		}
		weights = new Vector(weightsArray);
	}
	
	public void train(Vector[] inputs, double[] outputs, int numTimes) {
		for (int i = 0; i < numTimes; i++) {
			Vector weightAdjustment = new Vector(new double[numInputs]);
			for (int j = 0; j < inputs.length; j++) {
				double fedOutput = feed(inputs[j]);
				double error = outputs[j] - fedOutput;
				double confidence = fedOutput*(1-fedOutput);
				weightAdjustment = weightAdjustment.add(inputs[j].scalarMultiply(error*confidence));
			}
			weights = weights.add(weightAdjustment);
		}
	}
	
	public double feed(Vector input) {
		if (input.getLength() != numInputs) {
			throw new IllegalArgumentException("Vector is wrong size");
		}
		return sigmoid((input.dot(weights))/numInputs);
	}
	
	private double sigmoid(double value) {
		return 1/(1+(Math.pow(Math.E, -value)));
	}
	
	public Vector getWeights() {
		return weights;
	}

}
