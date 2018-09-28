package vector;

public class Vector {
	
	private double[] vector;
	
	public Vector(double[] vector) {
		this.vector = new double[vector.length];
		for (int i = 0; i < vector.length; i++) {
			this.vector[i] = vector[i];
		}
	}
	
	public Vector add(Vector v) {
		if (v.getLength() != this.getLength()) {
			throw new IllegalArgumentException("Vectors of different sizes can't add");
		}
		double[] ret = new double[getLength()];
		for(int i = 0; i < getLength(); i++) {
			ret[i] = v.get(i) + this.get(i);
		}
		return new Vector(ret);
	}
	
	public double dot(Vector v) {
		if (v.getLength() != this.getLength()) {
			throw new IllegalArgumentException("Matricies are not the same size");
		}
		double total = 0.0;
		for (int i = 0; i < getLength(); i++) {
			total += this.get(i)*v.get(i);
		}
		return total;
	}

	public Vector scalarMultiply(double scalar) {
		double[] ret = new double[getLength()];
		for (int i = 0; i < getLength(); i++) {
			ret[i] = this.get(i)*scalar;
		}
		return new Vector(ret);
	}
	
	public double get(int i) {
		return vector[i];
	}
	
	public void set(int i, double value) {
		vector[i] = value;
	}
	
	public int getLength() {
		return vector.length;
	}
	
	public String toString() {
		String ret = "";
		ret += "[";
		for (double v : vector) {
			ret += v+" ";
		}
		ret += "]";
		return ret;
	}
	
	
}
