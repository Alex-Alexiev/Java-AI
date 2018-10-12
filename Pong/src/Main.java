import processing.core.PApplet;

public class Main extends PApplet {

	public static int width, height;

	public static int pWidth, pHeight, bSize;

	public static int ballX, ballY;
	public static int p1X, p1Y, p2X, p2Y;
	public static int ballVelX, ballVelY;

	public static void main(String[] args) {
		PApplet.main("Main");

		pWidth = 20;
		pHeight = 100;
		bSize = 20;

		ballX = 200;
		ballY = 200;
		p1X = 0;
		p1Y = 0;
		p2X = width - pWidth;
		p2Y = 0;

		ballVelX = 10;
		ballVelY = 10;
	}

	public void settings() {
		width = 400;
		height = 400;
		size(width, height);
	}

	public void setup() {
		frameRate(30);
	}

	public void draw() {
		background(0);
		fill(255);
		stroke(255);    

		p1Y = ballY;
		p2Y = ballY;
		
		checkBoundaries();		
		updateVelocities();

		rect(ballX, ballY, bSize, bSize);
		rect(p1X, p1Y, pWidth, pHeight);
		rect(p2X, p2Y, pWidth, pHeight);
	}
	
	public void checkBoundaries() {
		if (p1Y < 0) p1Y = 0;
		if (p2Y < 0) p2Y = 0;
		if (p1Y + pHeight > height) p1Y = height - pHeight;
		if (p2Y + pHeight > height) p2Y = height - pHeight;
	}
	
	public void updateVelocities() {
		ballX += ballVelX;
		ballY += ballVelY;
		if (ballX < 0 || ballX > width - bSize) {
			ballVelX = -ballVelX;
		}
		if (ballY < 0 || ballY > height - bSize) {
			ballVelY = -ballVelY;
		}
		if (ballX < p1X + pWidth) {
			ballVelX = -ballVelX;
		}
		if (ballX+bSize > p2X) {
			ballVelX = -ballVelX;
		}
	}

}
