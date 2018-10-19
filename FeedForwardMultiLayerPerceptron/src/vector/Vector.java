package vector;

public class Vector {

	double[] nums;

	public Vector(double[] nums) {
		this.nums = nums;
	}

	public double dot(Vector v2) {
		double ret = 0;
		for (int i = 0; i < length(); i++) {
			ret += v2.get(i) * this.get(i);
		}
		return ret;
	}
	
	public Vector add(Vector v) {
		Vector ret = new Vector(nums);
		for (int i = 0; i < nums.length; i++) {
			ret.set(i, ret.get(i)+v.get(i));
		}
		return ret;
	}
	
	public Vector scalarMultiply(double d) {
		Vector ret = new Vector(nums);
		for (int i = 0; i < nums.length; i++) {
			ret.set(i, nums[i]*d);
		}
		return ret;
	}

	public double get(int index) {
		return nums[index];
	}
	
	public void set(int index, double value) {
		nums[index] = value;
	}

	public int length() {
		return nums.length;
	}

}
