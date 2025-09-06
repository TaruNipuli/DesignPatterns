package strategy;

// SorterContext holds a reference to a SortingStrategy
// and delegates the sorting task to the currently set strategy.
public class SorterContext {
    private SortingStrategy strategy; // current sorting strategy

    // Set the strategy at runtime
    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    // Use the current strategy to sort the array
    public void sort(int[] array) {
        strategy.sort(array);
    }
}

