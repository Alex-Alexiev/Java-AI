import processing.core.PApplet;

public class Main extends PApplet {
	
	private static DataPoint[] randomData;
	private static Neuron n1;
	
	public static void main(String[] args) {
		PApplet.main("Main");
	}
	
	public void setup() {
		frameRate(5);
	}
	
	public void settings() {
		size(1000,1000);
		randomData = DataPoint.generateRandomData(1000, width);
		n1  = new Neuron(2);
	}
	
	public void draw() {
		background(150);
		showData(randomData);
		n1.train(randomData, 1, 1);
	}
	
	public void showData(DataPoint[] dataPoints) {
		stroke(0);
		for (DataPoint d : dataPoints) {
			int translatedX = width/2+d.getX();
			int translatedY = height/2-d.getY();
			if (n1.feed(d.getVector()) > 0.5) {
			//if (d.getLabel() > 0) {
				fill(255);
			} else {
				fill(0);
			}
			rect(translatedX, translatedY, 10,10);
		}
		line(width/2, 0, width/2, height);
		line(0, height/2, width, height/2);
	}

}
