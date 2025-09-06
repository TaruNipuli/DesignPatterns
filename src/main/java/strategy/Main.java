package strategy;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int smallSize = 30;
        int largeSize = 100000;

        // Generate small random array
        Random rand = new Random();
        int[] smallArray = new int[smallSize];
        for (int i = 0; i < smallSize; i++) {
            smallArray[i] = rand.nextInt(100);
        }

        // Generate large random array
        int[] largeArray = new int[largeSize];
        for (int i = 0; i < largeSize; i++) {
            largeArray[i] = rand.nextInt(10000);
        }

        SorterContext sorter = new SorterContext();

        // Bubble Sort
        sorter.setStrategy(new BubbleSort());
        System.out.println("=== Bubble Sort ===");

        // Small array
        long start = System.nanoTime();
        sorter.sort(smallArray);
        long end = System.nanoTime();
        System.out.println("Small array sorted. Time: " + (end - start) / 1000000.0 + " ms");

        // Large array
        start = System.nanoTime();
        sorter.sort(largeArray);
        end = System.nanoTime();
        System.out.println("Large array sorted. Time: " + (end - start) / 1000000.0 + " ms\n");

        // Pigeonhole Sort
        sorter.setStrategy(new PigeonholeSort());
        System.out.println("=== Pigeonhole Sort ===");

        // Small array
        start = System.nanoTime();
        sorter.sort(smallArray);
        end = System.nanoTime();
        System.out.println("Small array sorted again. Time: " + (end - start) / 1000000.0 + " ms");

        // Large array
        start = System.nanoTime();
        sorter.sort(largeArray);
        end = System.nanoTime();
        System.out.println("Large array sorted again. Time: " + (end - start) / 1000000.0 + " ms\n");

        // Comb Sort
        sorter.setStrategy(new CombSort());
        System.out.println("=== Comb Sort ===");

        // Small array
        start = System.nanoTime();
        sorter.sort(smallArray);
        end = System.nanoTime();
        System.out.println("Small array sorted again. Time: " + (end - start) / 1000000.0 + " ms");

        // Large array
        start = System.nanoTime();
        sorter.sort(largeArray);
        end = System.nanoTime();
        System.out.println("Large array sorted again. Time: " + (end - start) / 1000000.0 + " ms");
    }
}
