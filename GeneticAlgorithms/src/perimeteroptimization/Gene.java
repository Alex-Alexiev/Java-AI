package perimeteroptimization;

public class Gene implements Comparable<Gene>{
	
	private double perimeter;
	private double length;
	private double width;
	private double maxOffset = 0.5;
	
	public Gene(double perimeter) {
		this.perimeter = perimeter;
		this.length = Math.random()*(perimeter/10);
		this.width  = (perimeter - 2*this.length)/2;
	}
	
	public Gene(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public Gene mutate() {
		double increment = Math.random()*(2*maxOffset*this.perimeter)-(maxOffset*this.perimeter);
		return new Gene(this.length + increment, this.width - increment);
	}
	
	public double getArea() {
		return this.length*this.width;
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getPerimeter() {
		return this.perimeter;
	}
	
	public int compareTo(Gene other) {
		return (int) (other.getArea()-this.getArea());
	}
	
	public String toString() {
		return "" + this.length + "*" + this.width + " = " + this.getArea();
	}
}
