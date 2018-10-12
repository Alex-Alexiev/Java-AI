package vector;

public class Vector {
	
	double[] nums;
	
	public Vector(double[] nums) {
		this.nums = nums;
	}
	
	public double dot(Vector v2) throws Exception {
		if (v2.length() != this.length()) throw new Exception("Vector sizes don't match");
		else {
			double ret = 0;
			for (int i = 0; i < length(); i++) {
				ret += v2.get(i)*this.get(i);
			}
			return ret;
		}
	}
	
	public double get(int index) {
		return nums[index];
	}
	
	public int length() {
		return nums.length;
	}

}
