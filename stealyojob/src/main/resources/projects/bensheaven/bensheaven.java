

public class bensheaven {

//Function that takes in an array and performs an insertion sort
public static void insertionSort(int[] array) 
{ 
	//Loop through array
    for (int i = 1; i < array.length; i++) { 
		//Store current element to save it
        int current = array[i]; 
        int j = i - 1; 
		//Loop through the rest of the elements comparing the current one
        while (j >= 0 && array[j] > current) { 
            array[j + 1] = array[j]; 
            j--; 
        } 
		//Once min index is found, insert current element into it
        array[j + 1] = current; 
    } 
} 

public static void main(String[] args) { 
	//Create array
    int[] array = {1, 5, 2, 3, 4, 0}; 
	//Print out initial array
    System.out.println("Initial Array:");
	//Loop through array
    for (int index = 0; index < array.length; index++) { 
        System.out.println(array[index]); 
    }
	//Perform insertion sort
	insertionSort(array);
	//Print out new array
    System.out.println("Sorted Array:"); 
    //Loop through array
    for (int index = 0; index < array.length; index++) { 
        System.out.println(array[index]); 
    }
}

}