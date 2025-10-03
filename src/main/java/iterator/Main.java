package iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Create Fibonacci sequence that generates the first 10 numbers
        Sequence sequence = new FibonacciSequence(10);

        // Get an iterator for the sequence
        Iterator<Integer> it = sequence.iterator();

        // Go through the sequence and print numbers
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
