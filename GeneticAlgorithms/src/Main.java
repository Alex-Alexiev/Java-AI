
import perimeteroptimization.Gene;
import perimeteroptimization.World;
import processing.core.PApplet;

public class Main extends PApplet{
	
	public static World world = new World(10, 400);

	public static void main(String[] args) {
		System.out.println(world);
		PApplet.main("Main");
	}
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		frameRate(30);
	}
	
	public void draw() {
		background(0);
		fill(0);
		stroke(255);
		Gene current = world.evolveOnce().getTopGene();
		rect(30,30, (int) current.getLength(), (int) current.getWidth());		
	}

}







