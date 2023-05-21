

public class bensheaven3 {
   
    // insertion sort sorting algorithm
    static void insertionSort(int[] arr)
    {
        int i, j, key, temp;
        for (i = 1; i < arr.length; i++)
        {
            key = arr[i];
            j = i-1;
      
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key)
            {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int[] arr = {12, 11, 13, 5, 6};
 
        insertionSort(arr);
 
        // Print the sorted array
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }
}