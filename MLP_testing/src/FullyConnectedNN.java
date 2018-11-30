import java.util.Arrays;

public class FullyConnectedNN {
	
	
	public static void main(String[] args) {
		FullyConnectedNN n1 = new FullyConnectedNN(new int[] {2, 2, 1});
		System.out.println(n1);
	}
	
	int[] layerSizes;
	Matrix[] weights;
	Matrix[] biases;
	
	public FullyConnectedNN(int[] layerSizes) {
		this.layerSizes = Arrays.copyOf(layerSizes, layerSizes.length);
		initWeights();
	}
	
	/*
	 * initialize the weight matrix for each layer with random values 
	 * The number of rows for the matrix will be the number of inputs, 
	 * which is the number of neurons in the previous layer
	 * The number of columns will be the number of outputs, 
	 * or the number of neurons in the next layer
	 */
	
	public void initWeights() {
		
	}
	
	public double feed(Matrix input) {
		return 0.0;
	}
	
	public String toString() {
		String ret = "";
		for (int n : layerSizes) {
			ret += n+", ";
		}
		return ret;
	}


}
