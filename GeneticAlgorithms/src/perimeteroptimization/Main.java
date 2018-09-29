package perimeteroptimization;

public class Main {

	public static void main(String[] args) {
		
		World world = new World(10, 400);
		System.out.println(world);
		
		world.evolve();
		System.out.println(world);

	}

}







