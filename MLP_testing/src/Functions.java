
public interface Functions {
	public double function(double n);
}

class relu implements Functions {
	public double function(double n) {
		return Math.max(0, n);
	}
}