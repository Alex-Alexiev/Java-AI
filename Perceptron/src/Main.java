import processing.core.PApplet;

public class Main extends PApplet {
		
	private static DataPoint[] randomData;
	private static Neuron n1;
	
	public static void main(String[] args) {
		PApplet.main("Main");
	}
	
	public void setup() {
		frameRate(20);
	}
	
	public void settings() {
		size(1000,1000);
		randomData = DataPoint.generateRandomData(300, width);
		n1  = new Neuron(2);
	}
	
	public void draw() {
		background(150);
		showData(randomData);
	}
	
	public void showData(DataPoint[] dataPoints) {
		for (DataPoint d : dataPoints) {
			int translatedX = width/2+d.getX();
			int translatedY = height/2-d.getY();
			if (n1.feed(d.getVector()) == 1) {
				fill(255);
			} else {
				fill(0);
			}
			rect(translatedX, translatedY, 10,10);
		}
	}

}
