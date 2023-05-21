
public class javafun {

    public static void main(String[] args) {

        // Declaring an array of random integer values
        int[] array = { 34, 8, 64, 51, 32, 21 };

        System.out.println("Array Before Insertion Sort");
        for (int value : array) {
            System.out.print(value + " ");
        }

        // sorting elements using Insertion sort
        insertionSort(array);

        System.out.println("\nArray After Insertion Sort");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    // insertion sort
    static void insertionSort(int array[]) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int element = array[i];
            int j = i - 1;
            while ((j > -1) && (array[j] > element)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = element;
        }
    }

}