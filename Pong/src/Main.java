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
		ballX += ballVelX;
		ballY += ballVelY;
		rect(ballX, ballY, bSize, bSize);

		p1Y = ballY;
		p2Y = ballY;

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
		
		rect(p1X, p1Y, pWidth, pHeight);
		rect(p2X, p2Y, pWidth, pHeight);
	}

}
