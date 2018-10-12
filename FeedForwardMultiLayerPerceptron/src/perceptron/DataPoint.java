package perceptron;

public class DataPoint {
	
	double x;
	double y;
	int label;
	
	public DataPoint(double x, double y) {
		this.x = x;
		this.y = y;
		if (x > y) this.label = -1;
		else this.label = 1;
	}

}
