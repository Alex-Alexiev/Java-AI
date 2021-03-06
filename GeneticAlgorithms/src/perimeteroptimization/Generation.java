package perimeteroptimization;
import java.util.Arrays;

public class Generation {
	
	private int size;
	private Gene[] population;
	private double overLapPercent = 0.8;
	
	public Generation(int size, int perimeter) {
		this.size = size;
		population = new Gene[size];
		for (int i = 0; i < size; i++) {
			population[i] = new Gene(perimeter);
		}
	}
	
	public Generation(Gene[] population) {
		this.population = population;
		this.size = population.length;
	}
	
	public Generation reBirth() {
		Arrays.sort(population);
		Gene[] nextGen = new Gene[this.size];
		int last = 0;
		for (int i = 0; i < this.size*this.overLapPercent; i++) {
			nextGen[i] = this.population[i].mutate();
			last = i;
		}
		for (int i = last; i < this.size; i++) {
			nextGen[i] = new Gene(this.getPerimeter());
		}
		return new Generation(nextGen);		
	}
	
	public Gene getTopGene() {
		Arrays.sort(population);
		return population[0];
	}
	
	public double getPerimeter() {
		return this.population[0].getPerimeter();
	}
	
	public double fitness() {
		Arrays.sort(population);
		double maxArea = getTopGene().getArea();
		double sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += population[i].getArea();
		}
		double averageArea = sum/3;
		return (maxArea-averageArea)/maxArea;
	}
	
	public String toString() {
		return "" + this.getTopGene();
	}

}
