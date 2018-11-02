
public class Neuron {

	private int numInputs;
	private Vector weights;
	
	public Neuron(int numInputs) {
		this.numInputs = numInputs;
		this.weights = Vector.getRandomVector(numInputs, 2);
	}
	
	public int feed(Vector inputs) {
		return sigmoid(inputs.dot(weights));
	}
	
	public int sigmoid(double x) {
		if (x > 0) return 1;
		return -1;
	}
	
}
