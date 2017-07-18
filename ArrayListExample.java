package Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ArrayListExample {

	public static void main(String[] args) {
		/*
		 * 2. show duplicate a value and times 
		 * it is repeated as key value pair for same 
		 * output[2,2],[3,3] using collections
		 * 
		 * Notes: 
		 * Set is a "collection that contains no duplicate elements
		 * List is "An ordered collection (also known as a sequence)
		 * 
		 * */
		// Enter size of array and assert the type of input
		
//		    Create an ArrayList that holds references to String
		    ArrayList<String> values = new ArrayList<String>();
//		    Capacity starts at 5, but size starts at 0
		    Scanner scNum = new Scanner(System.in);
		    System.out.println("initial size: " + values.size() );
		    System.out.println("Enter 5 values with duplications");
		    for(int i=0; i<5; i++) {
		    	values.add(scNum.next());
		    }
			Set<String> freq = new HashSet<String>(values);
			for (String i : freq) {
				System.out.println(i + ": " + Collections.frequency(values, i));
			}
		  
		
		
	}

}
