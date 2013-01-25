/** 
 * Name: Erik Arfvidson
 * Program: Lab 3 
 * Date: 9/12/2012
 * 
 *  Lab 3/Project 0: Random Numbers & Histogram
**/

import java.util.Arrays;

public class lab3 
{
	public static final int MAX = 200; // Number of random numbers
	public static final int UP = 1; // Number of random numbers
	public static final int DOWN = -2; // Number of random numbers
	public static final int DIVI = 12; // Number of random numbers
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
		/*
		 * while (ran1 == 0) ran1 = Math.random();
		 */
		r = Math.sqrt(((-2) * Math.log(ran1)));
		th = (2 * Math.PI * ran2);
		gen1 = (r) * (Math.cos(th));
		gen2 = (r) * (Math.sin(th));
		randomA[index] = gen1;
		randomA[index + 1] = gen2;
	}

	public static void DisplayHistogram(double[] array, int lowerBound, int higherBound,int divisions)
	{
		int categories = divisions;
		int upBound =higherBound;
		int downBound= lowerBound;
		double[] catArray = new double[divisions];// create an array that will hold the quantity of numbers within each category  
		double listDistance = Math.abs(downBound - upBound);
		double categorySize = listDistance / categories;
		System.out.println("\nHere are the sorted results of the random numbers: \n"); // display sorted array;
		

		for(int b=1; b-1<array.length; b++)
		{
			System.out.printf("||%.2f",array[b-1]);
			if(b%10==0 && b!=0)
			{
				System.out.print("||");
				System.out.println();
			}
		}

			int check=0;//checks if y has incremented
			int y = 0;//manages the bound
			System.out.println("\nHistogram:\n");
			for (int t = 0; t < array.length; t++)  //Creates Category array that hold quantity of numbers within each category
			{
				
				if (array[t] > (downBound+categorySize+(y*categorySize)) )
				{
					y++;
					check++;
					t--;
					
				}
				
				if(check==0 &&   array[t] <=higherBound)
				{
				catArray[y] +=1;
				}
				check=0;
			}
			/*for (double num : catArray)//Output category values
				System.out.print(" || " + num);
			*/
			
			
			for (int z = 0; z < catArray.length; z++) //Final output loop , outputs the categorySize and the histogram
			{
				
				System.out.printf( "%.0f to %.0f ",(downBound+z*categorySize), (downBound+z*(categorySize)+categorySize));
				System.out.printf("(%.0f)",catArray[z]);
				for (int out = 0; out < catArray[z]; out++) 
				{
					System.out.print("*");
				}
				System.out.println();
			}
	}

	public static void main(String[] args) 
	{
		double[] randomA = new double[MAX]; // create the array that will Hold Random Numbers
		double[] examGrades = {95,82,71,100,93,84,77,61,55,68,72,12};  //an array to hold exam grades.
		for (int d = 0; d < MAX; d += 2)// number of times getrandom gets called
		{
			getRandom(randomA, d);			// call the generating function
		}
		
			
		Arrays.sort(randomA);// Sort the array	 
		Arrays.sort(examGrades);  //sort the array    
		//DisplayHistogram(randomA,DOWN,UP,DIVI);//display the Histogram.
		DisplayHistogram(examGrades,0,100,20); //display the Histogram.
		
	}
}
