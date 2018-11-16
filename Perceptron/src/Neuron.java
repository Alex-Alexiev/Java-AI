
public class Neuron {

	private int numInputs;
	private Vector weights;
	
	public Neuron(int numInputs) {
		this.numInputs = numInputs;
		/*
		 * the last item in the weight vector is the bias 
		 */
		this.weights = new Vector(new double[] {-1,1, 0});//Vector.getRandomVector(numInputs+1, 1); //
	}
	
	/*
	 * Uses delta learning rule
	 * Loop through sample data
	 * Calculate error for each data point, then multiply by the learning rate, call this product e
	 * Multiply e by the input because larger inputs will be more affected by the weights  
	 * Add the above product to the weight vector
	 * Add e to the bias because a bias is just a weight where the input is always 1
	 */
	
	public void train(DataPoint[] dataPoints, int numTimes, double learningRate) {
		for (int i = 0; i < numTimes; i++) {
			Vector deltaW = new Vector(new double[numInputs+1]);
			for (DataPoint d : dataPoints) {
				Vector inputs = d.getVector();
				double yHat = d.getLabel();
				double y = feed(inputs);
				double de_dy = yHat-y;
				Vector de_dw = inputs.scalarMultiply(learningRate*de_dy);
				deltaW = deltaW.add(de_dw);
			}
			weights = weights.add(deltaW);
			System.out.println(weights);
		}
	}
	
	public double feed(Vector inputs) { 
		if (Math.abs(inputs.get(0)) < 10 && Math.abs(inputs.get(1)) < 10) {
			//System.out.println("salad");
		}
		return sigmoid(inputs.dot(weights));
	}
	
	public double sigmoid(double x) {
		if (x > 0) return 1;
		return 0;
		//return ((1.0/(1.0+Math.pow(Math.E, -x))));
	}
	
}
