import java.util.Arrays;

public class FullyConnectedNN {
	
	
	public static void main(String[] args) {
		FullyConnectedNN n1 = new FullyConnectedNN(new int[] {2, 2, 1});
		Matrix input = new Matrix(new double[][] {
				{0,1}
		});
		System.out.println(n1.feed(input, 1, new relu()));
	}
	
	int[] layerSizes;
	Matrix[] weights;
	Matrix[] biases;
	
	public FullyConnectedNN(int[] layerSizes) {
		this.layerSizes = Arrays.copyOf(layerSizes, layerSizes.length);
		weights = new Matrix[layerSizes.length-1];
		biases = new Matrix[layerSizes.length-1];
		initWeightsAndBiases();
	}
	
	/*
	 * initialize the weight matrix for each layer with random values 
	 * The number of rows for the matrix will be the number of inputs, 
	 * which is the number of neurons in the previous layer
	 * The number of columns will be the number of outputs, 
	 * or the number of neurons in the next layer
	 */
	
	public void initWeightsAndBiases() {
		for (int i = 0; i < layerSizes.length-1; i++) {
			weights[i] = new Matrix(layerSizes[i], layerSizes[i+1]);
			weights[i].randomize();
			biases[i] = new Matrix(1,layerSizes[i+1]);
			biases[i].randomize();
		}
	}
	
	/*
	 * feed into layer
	 */
	
	public Matrix feed(Matrix input, int layer, Functions nonLinearizer) {
		Matrix nextLayerInput = Matrix.elementWiseFunction(Matrix.addDown(Matrix.multiply(input, weights[layer-1]), biases[layer-1]), nonLinearizer);
		if (layer == layerSizes.length-1) return nextLayerInput;
		return (feed(nextLayerInput, layer+1, nonLinearizer));
	}
	
}
