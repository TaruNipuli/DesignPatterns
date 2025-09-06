package strategy;

// Comb Sort repeatedly compares elements that are a certain gap apart and swaps them if needed.
// The gap gradually shrinks until it becomes 1, then it continues like Bubble Sort.
public class CombSort implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        int n = array.length;
        int gap = n;          // initial gap size
        boolean swapped = true;

        // Continue until the gap is 1 and no swaps are done
        while (gap != 1 || swapped) {
            // Shrink the gap using a shrink factor
            gap = getNextGap(gap);

            swapped = false;

            // Compare elements with the current gap
            for (int i = 0; i < n - gap; i++) {
                if (array[i] > array[i + gap]) {
                    // Swap if they are out of order
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;

                    swapped = true;
                }
            }
        }
    }

    // Calculates next gap size
    private int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        return Math.max(gap, 1);
    }
}

