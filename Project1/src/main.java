import java.util.Scanner;
import java.lang.String;
//import java.lang.Runtime;
import java.io.*;
import java.lang.Math;

/*
* Name: Erik Arfvidson
* Program: Lab 1 
* Date: 9/5/2012
**/
public class main {
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Welcome to project #1 By: Erik Arfvidson");//intro message
		String label;
		System.out.println("Please enter the label for your number set");//label message
		label = scn.nextLine();
		System.out.println("Please enter the set of number and end input by typing Ctrl-z");// input of number request
		double[] inputarray = new double[50];
		double[] outputarray = new double[50];
		double temp = 0.0;
		int x = 0;
		while (scn.hasNextDouble()) {//get input list and highest value number
			inputarray[x] = Math.abs(scn.nextDouble());
			if (temp < inputarray[x]) {
				temp = inputarray[x];
			}
			x++;
		}
		int z = 0;
		System.out.printf("Scaled form of '%s':", label);//output with label message
		System.out.print("\n");
		while (z < x) {
			outputarray[z] = inputarray[z] / temp;//devides largest number with all the numbers in the array
			System.out.printf("point %d = %.2f \n",z, outputarray[z]);//prints out formatted array
			z++;
		}

	}

}
