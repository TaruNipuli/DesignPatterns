package iterator;

import java.util.Iterator;

// This class does not generate Fibonacci numbers itself, but provides an iterator that does
public class FibonacciSequence implements Sequence {
    private int maxCount; // Maximum number of Fibonacci numbers to generate

    public FibonacciSequence(int maxCount) {
        this.maxCount = maxCount;
    }

    // Returns an iterator for this Fibonacci sequence
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(maxCount);
    }
}
