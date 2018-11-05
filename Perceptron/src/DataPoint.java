
public class DataPoint {
	
	private int x, y;
	private int label;
	private static final int SLOPE = 1;
	
	public DataPoint(int x, int y) {
		this.x = x;
		this.y = y;
		if (y > SLOPE*x) {
			this.label = 1;
		} else {
			this.label = -1;
		}
	}
		
	public static DataPoint[] generateRandomData(int numDatas, int rangeSize) {
		DataPoint[] ret = new DataPoint[numDatas];
		for (int i = 0; i < ret.length; i++) {
			int x = (int)(Math.random()*rangeSize)-(rangeSize/2);
			int y = (int)(Math.random()*rangeSize)-(rangeSize/2);
			ret[i] = new DataPoint(x, y);
		}
		return ret;
	}
	
	public Vector getVector() {
		return new Vector(new double[] {x,y});
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}
	
}
