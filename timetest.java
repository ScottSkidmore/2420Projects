package comprehensive;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class timetest {
    @Test
    void test(){
    	System.out.println("custom");
    	 CustomForest<Integer> forest = new CustomForest<>();
        
         for(int j=0;j<10;j++) {
        	 int numElements = 10000;
        	 numElements=numElements*(j+1);

         // Time makeSet method
         long startTime = System.nanoTime();
         for (int i = 0; i < numElements; i++) {
             forest.makeSet(i);
         }
         long endTime = System.nanoTime();
         long makeSetTime = endTime - startTime;
         System.out.println("makeSet time: " + makeSetTime + " nanoseconds"+numElements);
         startTime = System.nanoTime();
         for (int i = 0; i < numElements - 1; i += 2) {
             forest.union(i, i + 1);
         }
         endTime = System.nanoTime();
         long unionTime = endTime - startTime;
         System.out.println("union time: " + unionTime + " nanoseconds"+numElements);
         // Time getRepresentative method
         startTime = System.nanoTime();
         for (int i = 0; i < numElements; i++) {
             forest.getRepresentative(i);
         }
         endTime = System.nanoTime();
         long getRepresentativeTime = endTime - startTime;
         System.out.println("getRepresentative time: " + getRepresentativeTime + " nanoseconds"+numElements);

         // Time union method
         }
     }
    @Test
    void test1() {
    	System.out.println("Benny");
    	 DisjointForest<Integer> set = new DisjointForest<>();
    	 
    	    for(int j=0;j<10;j++) {
    	    	 int n = 100000;
           	 n=n*(j+1);
    	    // Timing for makeSet method
    	    long start = System.nanoTime();
    	    for (int i = 0; i < n; i++) {
    	        set.makeSet(i);
    	    }
    	    long end = System.nanoTime();
    	    System.out.println("Time taken for makeSet: " + (end - start) + " nano"+n);

    	    // Timing for union method
    	    start = System.nanoTime();
    	    for (int i = 1; i < n; i++) {
    	        set.union(i, i-1);
    	    }
    	    end = System.nanoTime();
    	    System.out.println("Time taken for union: " + (end - start) + " nano"+n);

    	    // Timing for getRepresentative method
    	    start = System.nanoTime();
    	    for (int i = 0; i < n; i++) {
    	        set.getRepresentative(i);
    	    }
    	    end = System.nanoTime();
    	    System.out.println("Time taken for getRepresentative: " + (end - start) + " nano"+n);
    	}
    }
    	    
}
    

