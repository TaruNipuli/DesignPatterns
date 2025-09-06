package strategy;

// Compare numbers that are next to each other and swap them if the left one is bigger
public class BubbleSort implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        int n = array.length;

        // Loop through all elements
        for (int i = 0; i < n - 1; i++) {
            // Compare each pair of adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // If the left element is greater than the right, swap them
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
