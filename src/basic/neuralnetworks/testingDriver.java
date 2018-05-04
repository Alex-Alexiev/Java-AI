package basic.neuralnetworks;

import vector.Vector;

public class testingDriver {

	public static void main(String[] args) {
		
		Vector testData = new Vector(new double[] {0,1,0});
		Vector[] trainingData = {
				new Vector(new double[] {1,0,0}),
				new Vector(new double[] {1,1,0}),
				new Vector(new double[] {0,0,1}),
				new Vector(new double[] {0,1,0}),
				new Vector(new double[] {1,0,0})
		};
		double[] trainingOutputs = {
				1,
				1,
				0,
				0,
				1
		};
		SingleNeuronNetwork n = new SingleNeuronNetwork(3);
		System.out.println(n.feed(testData));
		n.train(trainingData, trainingOutputs, 10000);
		System.out.println(n.getWeights());
		System.out.println(n.feed(testData));
	}

}
