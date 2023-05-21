

import java.util.*; 

public class Precupstack
{
    // Fill out the body of this method
    static void sort(int array[])
    {
        int n = array.length; 
        for (int i = 1; i < n; ++i) { 
            int key = array[i]; 
            int j = i - 1; 
  
             /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && array[j] > key) { 
                array[j + 1] = array[j]; 
                j = j - 1; 
            } 
            array[j + 1] = key; 
        } 
    } 
  
    // Main method to test
    public static void main(String args[])
    {
        // Test insertion sort
        int[] test_array = {85, 24, 63, 45, 17, 31, 96, 50}; 
  
        // print array before sorting 
        System.out.println("Before Insertion Sort"); 
        for (int i = 0; i < test_array.length; i++) 
        { 
            System.out.print(test_array[i] + " "); 
        } 
        System.out.println(); 
  
        // Apply insertion sort
        sort(test_array); 
  
        // print array after sorting 
        System.out.println("After Insertion Sort"); 
        for (int i = 0; i < test_array.length; i++) 
        { 
            System.out.print(test_array[i] + " "); 
        } 
        System.out.println(); 
    } 
}