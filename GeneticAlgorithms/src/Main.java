
import perimeteroptimization.Gene;
import perimeteroptimization.World;
import processing.core.PApplet;

public class Main extends PApplet{
	
	public static World world = new World(10, 1000);
	public static int width, height;

	public static void main(String[] args) {
		System.out.println(world);
		PApplet.main("Main");
	}
	
	public void settings() {
		width = 400;
		height = 400;
		size(width,height);
	}
	
	public void setup() {
		frameRate(30);
	}
	
	public void draw() {
		background(0);
		fill(0);
		stroke(255);
		Gene current = world.evolveOnce().getTopGene();
		int bLength = (int) current.getLength();
		int bWidth = (int) current.getWidth();
		rect((width/2)-(bWidth/2), (height/2)-(bLength/2), bWidth, bLength);		
	}

}







