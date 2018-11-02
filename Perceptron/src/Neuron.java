
public class Neuron {

	private int numInputs;
	private Vector weights;
	
	public Neuron(int numInputs) {
		this.numInputs = numInputs;
		this.weights = Vector.getRandomVector(numInputs, 2);
	}
	
	public void train(DataPoint[] dataPoints, int numTimes, double learningRate) {
		for (int i = 0; i < numTimes; i++) {
			for (DataPoint d : dataPoints) {
				double yHat = d.getLabel();
				Vector inputs = d.getVector();
				double y = feed(inputs);
				Vector deltaW = inputs.scalarMultiply(-(yHat-y)*learningRate);
				weights = weights.add(deltaW);
			}
		}
	}
	
	public int feed(Vector inputs) {
		return sigmoid(inputs.dot(weights));
	}
	
	public int sigmoid(double x) {
		if (x > 0) return 1;
		return -1;
	}
	
}
