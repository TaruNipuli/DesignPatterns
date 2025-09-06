package strategy;

// Pigeonhole Sort creates a counting array (pigeonholes) for all values between min and max.
// It counts occurrences of each number and rebuilds the array in ascending order.
public class PigeonholeSort implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        // Find minimum and maximum values in the array
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }

        // Create pigeonholes for each value in the range
        int range = max - min + 1;
        int[] holes = new int[range];

        // Put each element into its pigeonhole
        for (int num : array) {
            holes[num - min]++;
        }

        // Collect elements back into the array in ascending order
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (holes[i]-- > 0) {
                array[index++] = i + min;
            }
        }
    }
}

