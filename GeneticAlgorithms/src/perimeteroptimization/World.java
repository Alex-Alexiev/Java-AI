package perimeteroptimization;

import java.util.ArrayList;
import java.util.List;

public class World {
	
	private List<Generation> generations = new ArrayList<Generation>();
	private int currentGeneration;
	private double goal = 0.01;
	
	public World(int populationSize, int perimeter){
		generations.add(new Generation(populationSize, perimeter));
	}
	
	public void evolve() {
		double fitness = generations.get(currentGeneration).fitness();
		while(fitness > 0.0000001) {
			generations.add(generations.get(currentGeneration).reBirth());
			currentGeneration++;
			fitness = generations.get(currentGeneration).fitness();
			System.out.println(fitness);
		}
	}
	
	public String toString() {
		return "Generation: " + currentGeneration + " Top Gene: " + generations.get(currentGeneration).getTopGene();
	}

}
