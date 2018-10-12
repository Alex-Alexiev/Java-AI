package perceptron;

import vector.Vector;

public class Driver {
	
	public static void main(String[] args) throws Exception {
		Neuron and = new Neuron(2);
		System.out.println(and.feed(new Vector(new double[] {
				-1,2
		})));
	}

}
