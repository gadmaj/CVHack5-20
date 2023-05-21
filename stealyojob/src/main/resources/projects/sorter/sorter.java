

public class Sorter { 

    public static void insertionSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        int arr[] = { 5, 9, 1, 7, 2 }; 
  
        insertionSort(arr); 
  
        for (int i : arr) {
            System.out.println(i);
        }
         
    } 
}