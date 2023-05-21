

import java.util.Arrays; 

public class funtimes { 
	
	// Insertion Sort Method 
	static void insertionSort(int[] array) {  
		int n = array.length; 
		for (int i = 1; i < n; i++) { 
			int temp = array[i]; 
			int j = i-1; 

			// Move the elements of the array that are larger than temp one position ahead  
			while (j >= 0 && array[j] > temp) { 
				array[j+1] = array[j]; 
				j--; 
			} 
			array[j+1] = temp; 
		} 
	} 

	// Main Method 
	public static void main (String[] args) { 
		// Test Data 
		int[] array = {122, 13, 1, 24, 5, 11}; 
		
		// Print Unsorted Array 
		System.out.println("Before sorting: " + Arrays.toString(array)); 
		
		// Method call to sort
		insertionSort(array); 
		
		// Print Sorted Array 
		System.out.println("After sorting: " + Arrays.toString(array)); 
	} 
}