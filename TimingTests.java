package assign09;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TimingTests {
        @Test
        void hashMapGetTest() {
            final int START_SIZE = 100000;
            final int END_SIZE = 1500000;
            final int INTERVAL_SIZE = 100000;
            final int NUM_ITERATIONS = 10;

            for (int i = START_SIZE; i <= END_SIZE; i += INTERVAL_SIZE) {
                long totalTime = 0;
                for (int j = 0; j < NUM_ITERATIONS; j++) {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    for (int k = 0; k < i; k++) {
                        map.put(k, k);
                    }
                    long startTime = System.nanoTime();
                    // Test the HashMap function here
                    map.get(i / 2);
                    long endTime = System.nanoTime();
                    totalTime += (endTime - startTime);
                }
                long averageTime = totalTime / NUM_ITERATIONS;
                System.out.println(averageTime);
            }
        }
    @Test
    void hashMapPutTest() {
        final int START_SIZE = 100000;
        final int END_SIZE = 1500000;
        final int INTERVAL_SIZE = 100000;
        final int NUM_ITERATIONS = 10;

        for (int i = START_SIZE; i <= END_SIZE; i += INTERVAL_SIZE) {
            long totalTime = 0;
            for (int j = 0; j < NUM_ITERATIONS; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                long startTime = System.nanoTime();
                for (int k = 0; k < i; k++) {
                    map.put(k, k);
                }
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            long averageTime = totalTime / NUM_ITERATIONS;
            System.out.println(averageTime);
        }
    }
    @Test
    void hashMapRemoveTest() {
        final int START_SIZE = 100000;
        final int END_SIZE = 1500000;
        final int INTERVAL_SIZE = 100000;
        final int NUM_ITERATIONS = 10;

        for (int i = START_SIZE; i <= END_SIZE; i += INTERVAL_SIZE) {
            long totalTime = 0;
            for (int j = 0; j < NUM_ITERATIONS; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int k = 0; k < i; k++) {
                    map.put(k, k);
                }
                long startTime = System.nanoTime();
                for (int k = 0; k < i; k++) {
                    map.remove(k);
                }
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            long averageTime = totalTime / NUM_ITERATIONS;
            System.out.println(averageTime);
        }
    }
    @Test
    void hashTableGetTest() {
        final int START_SIZE = 100000;
        final int END_SIZE = 1500000;
        final int INTERVAL_SIZE = 100000;
        final int NUM_ITERATIONS = 10;

        for (int i = START_SIZE; i <= END_SIZE; i += INTERVAL_SIZE) {
            long totalTime = 0;
            for (int j = 0; j < NUM_ITERATIONS; j++) {
                HashTable<Integer, Integer> map = new HashTable<>();
                for (int k = 0; k < i; k++) {
                    map.put(k, k);
                }
                long startTime = System.nanoTime();
                // Test the HashMap function here
                map.get(i / 2);
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            long averageTime = totalTime / NUM_ITERATIONS;
            System.out.println(averageTime);
        }
    }
    @Test
    void hashTablePutTest() {
        final int START_SIZE = 100000;
        final int END_SIZE = 1500000;
        final int INTERVAL_SIZE = 100000;
        final int NUM_ITERATIONS = 10;

        for (int i = START_SIZE; i <= END_SIZE; i += INTERVAL_SIZE) {
            long totalTime = 0;
            for (int j = 0; j < NUM_ITERATIONS; j++) {
                HashTable<Integer, Integer> map = new HashTable<>();
                long startTime = System.nanoTime();
                for (int k = 0; k < i; k++) {
                    map.put(k, k);
                }
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            long averageTime = totalTime / NUM_ITERATIONS;
            System.out.println(averageTime);
        }
    }
    @Test
    void hashTableRemoveTest() {
        final int START_SIZE = 100000;
        final int END_SIZE = 1500000;
        final int INTERVAL_SIZE = 100000;
        final int NUM_ITERATIONS = 10;

        for (int i = START_SIZE; i <= END_SIZE; i += INTERVAL_SIZE) {
            long totalTime = 0;
            for (int j = 0; j < NUM_ITERATIONS; j++) {
                HashTable<Integer, Integer> map = new HashTable<>();
                for (int k = 0; k < i; k++) {
                    map.put(k, k);
                }
                long startTime = System.nanoTime();
                for (int k = 0; k < i; k++) {
                    map.remove(k);
                }
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            long averageTime = totalTime / NUM_ITERATIONS;
            System.out.println(averageTime);
        }
    }








}





