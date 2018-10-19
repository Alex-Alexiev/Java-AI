import perceptron.DataPoint;
import perceptron.Neuron;
import processing.core.PApplet;
import vector.Vector;

public class Main extends PApplet {
	
	public static int width = 1000;
	public static DataPoint[] inputs = DataPoint.getRandomData(500, width);
	public static Neuron neuron1 = new Neuron(2);
	
	public static void main(String[] args) {
		neuron1.train(DataPoint.getRandomData(10000, width));
		Vector a = new Vector(new double[] {1,2,3});
		Vector b = new Vector(new double[] {4,5,6});
		Vector c = a.add(b);
		System.out.println(c.get(0)+"  "+c.get(1)+"  "+c.get(2));
		PApplet.main("Main");
	}

	public void settings() {
		size(width, width);
	}

	public void setup() {
		frameRate(30);
	}

	public void draw() {
		background(125);
		stroke(0);
		fill(0);
		line(width/2, 0, width/2, width);
		line(0, width/2, width, width/2);
		for (DataPoint input : inputs) {
			if (neuron1.feed(input.getVector()) == 1) {
				fill(255);
				stroke(255);
			} else {
				fill(0);
				stroke(0);
			}
			rect(width/2+input.getX(), height/2-input.getY(), 10,10);
		}
	}

}
