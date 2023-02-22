package assign05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListSorterTests {

    @Test
    void generateAscendingTest() {
        ArrayList<Integer> arr = ArrayListSorter.generateAscending(9);
        assertEquals(9, arr.get(8));
        assertEquals(4, arr.get(3));
        assertEquals(1, arr.get(0));
    }
    @Test
    void generateAscendingTestLarge() {
        ArrayList<Integer> arr = ArrayListSorter.generateAscending(30);
        assertEquals(30, arr.get(29));
        assertEquals(15, arr.get(14));
        assertEquals(1, arr.get(0));
    }
    @Test
    void generatePermutedTest() {
        ArrayList<Integer> arr = ArrayListSorter.generatePermuted(8);
        if (!arr.equals(ArrayListSorter.generateAscending(8)) && !arr.equals(ArrayListSorter.generateDescending(8))){
            assertEquals(0,0);
        }
        else assertEquals(0,1);
    }
    @Test
    void generatePermutedTestLarge() {
        ArrayList<Integer> arr = ArrayListSorter.generatePermuted(25);
        if (!arr.equals(ArrayListSorter.generateAscending(25)) && !arr.equals(ArrayListSorter.generateDescending(25))){
            assertEquals(0,0);
        }
        else assertEquals(0,1);
    }
    @Test
    void generateDescendingTest() {
        ArrayList<Integer> arr = ArrayListSorter.generateDescending(10);
        assertEquals(10, arr.get(0));
        assertEquals(4, arr.get(6));
        assertEquals(1, arr.get(9));
    }
    @Test
    void generateDescendingTestLarge() {
        ArrayList<Integer> arr = ArrayListSorter.generateDescending(27);
        assertEquals(27, arr.get(0));
        assertEquals(20, arr.get(7));
        assertEquals(1, arr.get(26));
    }

}
