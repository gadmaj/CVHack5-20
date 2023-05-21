

public class InsertionSort {
 
    public static void main(String[] args) 
    { 
        int[] arr = {5, 2, 8, 9, 1, 0}; 
  
        System.out.println("Array before Sorting..."); 
        printArray(arr); 
  
        insertionSort(arr); 
  
        System.out.println("Array after Sorting..."); 
        printArray(arr); 
    } 
  
    static void insertionSort(int[] arr) 
    { 
        int n = arr.length; 
        
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 

    static void printArray(int[] arr) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
}