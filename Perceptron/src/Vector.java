
public class Vector {

	private double[] nums;
	
	public Vector(double[] nums) {
		this.nums = nums;
	}
	
	public Vector(int length) {
		nums = new double[length];
	}
	
	public static Vector getRandomVector(int size, int range) {
		double[] vals = new double[size];
		for (int i = 0; i < vals.length; i++) {
			vals[i] = Math.random()*range-range/2;
		}
		return new Vector(vals);
	}
	
	public Vector scalarMultiply(double k) {
		Vector ret = new Vector(nums.length);
		for (int i = 0; i < nums.length; i++) {
			ret.set(i,  nums[i]*k);
		}
		return ret;
	}
	
	public Vector add(Vector v) {
		Vector ret = new Vector(nums.length);
		for (int i = 0; i < nums.length; i++) {
			ret.set(i, nums[i]+v.get(i));
		}
		return ret;
	}
	
	public double dot(Vector v2) {
		double dot = 0;
		for(int i = 0; i < nums.length; i++) {
			dot+=this.get(i)*v2.get(i);
		}
		return dot;
	}
	
	public double get(int i) {
		return nums[i];
	}
	
	public void set(int i, double val) {
		nums[i] = val;
	}
	
}
