package Lists;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class NoCollection {
	
	public static void main(String args[]) throws IOException{

		/*
		 * 1.Remove duplicate with out using collections
		 * (examples:[1,2,2,3]out put is [1,2,3] and for[1,2,3,3,3,4] out put is [1,2,3,4]) 
		 * */
		
		
		// Enter size of array and assert the type of input
		
		System.out.println("Enter size of array in integers");
		Scanner sc = new Scanner(System.in);
		while(!sc.hasNextInt()) {
			System.out.println("Please enter integers"); 
			sc.next(); 
		};
		
		// Accepting the values into the array and sorting them
		int demoInt = sc.nextInt();
		String[] array = new String[demoInt];
		String[] outputMarkers = new String[demoInt];
		System.out.println("Enter the integers");
		for(int i=0; i< array.length; i++) {
			Scanner scNum = new Scanner(System.in);
			array[i] = scNum.next();
			if(i == array.length -1) System.out.println("Array is full");
		}
		Arrays.sort(array);
		System.out.printf("Sorted array is : %s", Arrays.toString(array));
		
		//Checking for duplicates //Sample: a a a s d f
		for(int j=0; j< array.length; j++) {
			for(int k=j+1; k< array.length; k++) {
				if(array[j].equals(array[k])) {
					continue; //returns to for loop with increment
				}
				System.out.print(array[j] + ". ");
				j = k;
			}
		}
//		
		System.out.print(array[array.length-1] + " ");
}}
