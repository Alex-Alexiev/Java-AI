import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
		//start PApplet and tell it to use "Main"
		PApplet.main("Main");
	}
	
	public void settings() {
		size(1000,1000);
	}
	
	public void setup() {
		frameRate(30);
	}
	
	/*
	 * This method gets looped continuously at the specified  frame rate
	 */
	public void draw() {
		background(0);
		fill(0);
		stroke(255);
		rect(30,30, 50, 50);		
	}

}
