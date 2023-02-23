package assign05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ArrayListSorterTimer {

    @Test
    void QuickSortTimerPermuted(){
        int size = 1000;
        int numberOfSorts = 1000;
        for (int totalLoops = 0; totalLoops < 10; totalLoops++){
            double totalTime = 0;

            for(int i = 0; i < numberOfSorts; i++){
                ArrayList randomArray = ArrayListSorter.generatePermuted(size);
                long startTime= System.nanoTime();
                ArrayListSorter.quicksort(randomArray);
                long sortTime = System.nanoTime() - startTime;
                totalTime = totalTime + sortTime;
            }
            double averageTime = totalTime/1000;
            System.out.println("The average time for quicksort on 1000 random arrays of size "+ size + " was " + averageTime);
            size = size + 1000;
        }
    }

    @Test
    void MergeSortTimerPermuted(){
        int size = 1000;
        int numberOfSorts = 1000;
        for (int totalLoops = 0; totalLoops < 10; totalLoops++){
            double totalTime = 0;

            for(int i = 0; i < numberOfSorts; i++){
                ArrayList randomArray = ArrayListSorter.generatePermuted(size);
                long startTime= System.nanoTime();
                ArrayListSorter.mergesort(randomArray);
                long sortTime = System.nanoTime() - startTime;
                totalTime = totalTime + sortTime;
            }
            double averageTime = totalTime/1000;
            System.out.println("The average time for mergesort on 1000 random array of size "+ size + " was " + averageTime);
            size = size + 1000;
        }
    }

    @Test
    void QuickSortTimerAscending(){
        int size = 1000;
        int numberOfSorts = 1000;
        for (int totalLoops = 0; totalLoops < 10; totalLoops++){
            double totalTime = 0;

            for(int i = 0; i < numberOfSorts; i++){
                ArrayList randomArray = ArrayListSorter.generateAscending(size);
                long startTime= System.nanoTime();
                ArrayListSorter.quicksort(randomArray);
                long sortTime = System.nanoTime() - startTime;
                totalTime = totalTime + sortTime;
            }
            double averageTime = totalTime/1000;
            System.out.println("The average time for quicksort on 1000 random arrays of size "+ size + " was " + averageTime);
            size = size + 1000;
        }
    }

    @Test
    void MergeSortTimerAscending(){
        int size = 1000;
        int numberOfSorts = 1000;
        for (int totalLoops = 0; totalLoops < 10; totalLoops++){
            double totalTime = 0;

            for(int i = 0; i < numberOfSorts; i++){
                ArrayList randomArray = ArrayListSorter.generateAscending(size);
                long startTime= System.nanoTime();
                ArrayListSorter.mergesort(randomArray);
                long sortTime = System.nanoTime() - startTime;
                totalTime = totalTime + sortTime;
            }
            double averageTime = totalTime/1000;
            System.out.println("The average time for mergesort on 1000 random array of size "+ size + " was " + averageTime);
            size = size + 1000;
        }
    }

    @Test
    void QuickSortTimerDescending(){
        int size = 1000;
        int numberOfSorts = 1000;
        for (int totalLoops = 0; totalLoops < 10; totalLoops++){
            double totalTime = 0;

            for(int i = 0; i < numberOfSorts; i++){
                ArrayList randomArray = ArrayListSorter.generateDescending(size);
                long startTime= System.nanoTime();
                ArrayListSorter.quicksort(randomArray);
                long sortTime = System.nanoTime() - startTime;
                totalTime = totalTime + sortTime;
            }
            double averageTime = totalTime/1000;
            System.out.println("The average time for quicksort on 1000 random arrays of size "+ size + " was " + averageTime);
            size = size + 1000;
        }
    }

    @Test
    void MergeSortTimerDescending(){
        int size = 1000;
        int numberOfSorts = 1000;
        for (int totalLoops = 0; totalLoops < 10; totalLoops++){
            double totalTime = 0;

            for(int i = 0; i < numberOfSorts; i++){
                ArrayList randomArray = ArrayListSorter.generateDescending(size);
                long startTime= System.nanoTime();
                ArrayListSorter.mergesort(randomArray);
                long sortTime = System.nanoTime() - startTime;
                totalTime = totalTime + sortTime;
            }
            double averageTime = totalTime/1000;
            System.out.println("The average time for mergesort on 1000 random array of size "+ size + " was " + averageTime);
            size = size + 1000;
        }
    }

}
