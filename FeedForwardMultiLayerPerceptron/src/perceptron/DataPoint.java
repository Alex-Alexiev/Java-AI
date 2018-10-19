package perceptron;

import vector.Vector;

public class DataPoint {
	
	int x;
	int y;
	int label;
	
	public DataPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public DataPoint(int range) {
		this.x = (int)(Math.random()*range)-(range/2);
		this.y = (int)(Math.random()*range)-(range/2);
	}
	
	public Vector getVector() {
		return new Vector(new double[] {x,y});
	}
	
	public static DataPoint[] getRandomData(int n, int range) {
		DataPoint[] ret = new DataPoint[n];
		for (int i =  0; i < n; i++) {
			ret[i] = new DataPoint((int)(Math.random()*range)-(range/2),(int)(Math.random()*range)-(range/2));
		}
		return ret;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getLabel() {
		if (x < y) this.label = -1; //bottom half
		else this.label = 1;
		return label;
	}

}
