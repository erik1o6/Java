/** 
 * Name: Erik Arfvidson
 * Program: Lab 2 
 * Date: 9/5/2012
 **/

import java.util.Arrays;

public class lab2 {
	public static final int MAX = 20; // Number of random numbers

	public static void getRandom(double[] randomA, int index) {
		// Box-Muller is a method to generate pairs of independent standard
		// normally distributed numbers

		double ran1; // uniformly-distributed random numbers ran1
		double ran2; // uniformly-distributed random numbers ran2
		double r; // r to find gen1 and gen2
		double th; // th which is used to find gen1 and gen2
		double gen1; // normally-distributed random number
		double gen2; // normally-distributed random number
		// Generate two random numbers
		ran1 = Math.random();
		ran2 = Math.random();
		// check if first number is 0
		while (ran1 == 0)
			ran1 = Math.random();
		// compute the r and th quantities
		r = Math.sqrt((-2 * Math.log(ran1)));
		th = (2 * Math.PI * ran2);
		// generate normally-distributed numbers
		gen1 = (ran1) * (Math.cos(ran2));
		gen2 = (ran1) * (Math.sin(ran2));
		// add random numbers to the array
		randomA[index] = ran1;
		randomA[index + 1] = ran2;
	}

	public static void main(String[] args) {
		double[] randomA = new double[MAX]; // create the array that will hold
											// the MAX number of numbers
		// number of times getrandom gets called
		for (int d = 0; d < MAX; d += 2) {
			getRandom(randomA, d); // call the generating function
		}
		System.out.println("\nHere are the results of the " + MAX
				+ " random numbers: \n");
		// display array
		for (double num : randomA) {
			System.out.println("value: " + num);
		}
		// Sort the array
		Arrays.sort(randomA);
		System.out.println("\nHere are the sorted results of the random numbers: \n");
		// display sorted array
		for (double num : randomA) {
			System.out.println("value: " + num);
		}
	}
}
