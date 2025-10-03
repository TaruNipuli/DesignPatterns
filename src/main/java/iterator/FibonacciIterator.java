package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Responsible for generating Fibonacci numbers up to given count
public class FibonacciIterator implements Iterator<Integer> {
    private int previous;
    private int current;
    private int count;
    private int maxCount;

    /* Stores the current state of the sequence: previous and current Fibonacci numbers,
    and how many numbers have been returned so far.
    Keeping it in this class allows each iterator to track its own position independently,
    so multiple iterators can go through the same FibonacciSequence without affecting each other,
    and each iterator can generate numbers on demand at its own pace. */

    public FibonacciIterator(int maxCount) {
        this.maxCount = maxCount;
        previous = 1;
        current = 1;
        count = 0;
    }

    // Checks if there are more numbers to generate
    @Override
    public boolean hasNext() {
        if (count < maxCount) {  // true if we haven't reached maxCount yet
            return true;
        } else {
            return false;
        }
    }

    // Returns the next Fibonacci number in the sequence
    @Override
    public Integer next() {
        if (!hasNext()) {  // If hasNext is false, there's no more numbers to generate
            throw new NoSuchElementException();
        }

        int result; // Temporary variable to store the next Fibonacci number before returning it

        // The first two numbers are always 1
        if (count == 0 || count == 1) {
            result = 1;
        } else {
            // Sum previous two numbers
            result = previous + current;

            // Update state for next call
            previous = current;
            current = result;
        }

        count++;  // Increment the count of numbers returned
        return result;
    }
}
