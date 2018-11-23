import java.text.DecimalFormat;

public class Matrix {

	private double[][] mat;

	public Matrix(int rows, int cols) {
		mat = new double[rows][cols];
	}

	public Matrix(double[][] mat) {
		this.mat = new double[mat.length][mat[0].length];
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[0].length; c++) {
				this.mat[r][c] = mat[r][c];
			}
		}
	}

	public String toString() {
		String ret = "";
		DecimalFormat df = new DecimalFormat("#.#");
		for (int r = 0; r < mat.length; r++) {
			ret += "|";
			for (int c = 0; c < mat[0].length; c++) {
				ret += df.format(mat[r][c]) + " ";
			}
			ret += "|\n";
		}
		return ret;
	}

	public Matrix getRow(int r) {
		Matrix result = new Matrix(1, cols());
		for (int c = 0; c < cols(); c++) {
			result.set(0, c, mat[r][c]);
		}
		return result;
	}

	public Matrix getCol(int c) {
		Matrix result = new Matrix(rows(), 1);
		for (int r = 0; r < rows(); r++) {
			result.set(r, 0, mat[r][c]);
		}
		return result;
	}

	public static double dotProduct(Matrix mat1, Matrix mat2) {
		double ret = 0;
		for (int r = 0; r < mat1.rows(); r++) {
			for (int c = 0; c < mat1.cols(); c++) {
				ret += mat1.get(r,c)*mat2.get(r, c);
			}
		}
		return ret;
	}
	
	public Matrix transpose() {
		Matrix result = new Matrix(cols(), rows());
		for (int r = 0; r < result.rows(); r++) {
			for (int c = 0; c < result.cols(); c++) {
				result.set(r, c, get(c,r));
			}
		}
		return result;
	}
	
	public static Matrix multiply(Matrix mat1, Matrix mat2) {
		Matrix result = new Matrix(mat1.rows(), mat2.cols());
		for (int r = 0; r < result.rows(); r++) {
			for (int c = 0; c < result.cols(); c++) {
				result.set(r, c, Matrix.dotProduct(mat1.getRow(r).transpose(), mat2.getCol(c)));
			}
		}
		return result;
	}

	public void set(int r, int c, double val) {
		mat[r][c] = val;
	}

	public double get(int r, int c) {
		return mat[r][c];
	}

	public int cols() {
		return mat[0].length;
	}

	public int rows() {
		return mat.length;
	}

	public static void main(String[] args) {
		Matrix m1 = new Matrix(new double[][] { { 1, 4 }, { 2, 5 }, { 3, 6 } });
		Matrix m2 = new Matrix(new double[][] { { 1, 3 }, { 2, 4 } });
		Matrix m3 = new Matrix(new double[][] { { 1 }, { 2 }, { 3 } });
		Matrix m4 = new Matrix(new double[][] { { 4 }, { 5 }, { 6 } });
		System.out.println(Matrix.multiply(m1, m2));
		//System.out.println(m2.getCol(0));
	}

}
