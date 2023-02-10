package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import assign04.LargestNumberSolver.ArrayComparator;
import assign04.LargestNumberSolver.FullArrayComparator;

/**
 * This class contains tests for Largest Number Solver
 * @author Nate Zuro and Scott Skidmore
 */
class LargestNumberSolverTest{
    Integer[] arr1 = {3,1,6,3,10,2,1};
    Integer[] sorted = {1,2,3,4,5,6,7,8,9};
    Integer[] arr3 = {1,43,23,12,1,43,23,12,1,43,23,12};
    Integer[] arr4 = {1,2};
    Integer[] arr5 = {789,36};
    Integer[] arr6 = {28984,29};
    Integer[] empty= {};
    Integer[] text= {56, 78, 62, 38, 544, 42, 63, 81, 59, 28, 98, 971, 78, 14, 54, 26, 70, 32, 62, 72, 22, 12, 35, 35, 88, 42, 87, 74, 51, 92, 88, 71, 69, 14, 87, 10, 5906, 10, 9, 16, 55, 29, 65, 8, 80, 13, 19, 55, 22, 20, 6, 113, 97, 42, 58, 82, 26, 79, 46, 21, 9, 89, 90, 55, 63, 6663, 14, 33, 65, 4, 53, 9, 23, 63, 346, 93, 722, 64, 66, 96, 46, 62, 47, 34, 11, 38, 75, 251, 64, 74, 98, 96, 43};

    ArrayList<Integer[]> numbers = new ArrayList<>();


    Point p1 = new Point(5,6);
    Point p2 = new Point(3,5);
    Point p3 = new Point(9,2);
    Point p4 = new Point(1,0);
    Point p5 = new Point(0,1);
    Point[] arr2 = {p1,p2,p3,p4,p5};
    Comparator<Integer> intSort = Comparator.naturalOrder();
    Comparator<Point> pointSort = (Point o1, Point o2) -> (int)(o1.getX() - o2.getX());

    //----------------------------------------Tests start here---------------------------------------------
    @Test
    void insertionSortTest(){
        LargestNumberSolver.insertionSort(arr1,intSort);
        assertEquals(1, arr1[0]);
    }

    @Test
    void insertionSortTest2(){
        LargestNumberSolver.insertionSort(arr2,pointSort);
        assertEquals(new Point(0,1), arr2[0]);
    }
    @Test
    void insertionSortTestLarge(){
        LargestNumberSolver.insertionSort(text,intSort);
        assertEquals(4, text[0]);
        assertEquals(6663, text[text.length-1]);
    }

    @Test
    void insertionSortTestSorted(){
        LargestNumberSolver.insertionSort(sorted,intSort);
        assertEquals(1, sorted[0]);
        assertEquals(9, sorted[sorted.length-1]);
    }

    @Test
    void findLargestNumberTest(){
        int i=63321110;
        LargestNumberSolver.insertionSort(arr1,new ArrayComparator());
        assertEquals(i,LargestNumberSolver.findLargestNumber(arr1).intValue());
    }
    @Test
    void findLargestNumberSmall(){
        Integer[] nums = {1};
        LargestNumberSolver.findLargestNumber(nums);

    }

    @Test
    void findLargestNumberTestEmpty(){
        assertEquals(0,LargestNumberSolver.findLargestNumber(empty).intValue());
    }



    @Test
    void findLargestIntTest(){
        assertEquals(63321110,LargestNumberSolver.findLargestInt(arr1));
    }

    @Test
    void findLargestIntTestOversize(){
        assertThrows(OutOfRangeException.class,() -> LargestNumberSolver.findLargestInt(text));
    }

    @Test
    void findLargestIntTest2(){
        assertEquals(2928984,LargestNumberSolver.findLargestInt(arr6));
    }

    @Test
    void findLargestIntTestEmpty(){
        assertEquals(0,LargestNumberSolver.findLargestInt(empty));
    }

    @Test
    void findLargestLongTest(){
        numbers.add(arr4);
        numbers.add(arr5);
        assertEquals(78957,LargestNumberSolver.sum(numbers).intValue());
    }

    @Test
    void findLargestLongTestOversize(){
        assertThrows(OutOfRangeException.class,() -> LargestNumberSolver.findLargestLong(text));
    }

    @Test
    void findLargestLongTestEmpty(){
        assertEquals(0,LargestNumberSolver.findLargestLong(empty));
    }

    @Test
    void sumTest(){
        numbers.add(arr4);
        numbers.add(arr5);
        assertEquals(78957,LargestNumberSolver.sum(numbers).intValue());
    }

    @Test
    void sumTestEmpty(){
        assertEquals(0,LargestNumberSolver.sum(numbers).intValue());
    }

    @Test
    void findKthLargestTest() throws Exception{
        numbers.add(arr3);
        numbers.add(arr1);
        numbers.add(arr4);
        numbers.add(arr5);
        numbers.add(arr6);
        assertEquals(arr4,LargestNumberSolver.findKthLargest(numbers,4));
    }

    @Test
    void findKthLargestTestEmpty() throws Exception{
        assertThrows(IllegalArgumentException.class,() -> LargestNumberSolver.findKthLargest(numbers,4));
    }

    @Test
    void readFileTest(){
        ArrayList<Integer[]> arr = new ArrayList<>();
        arr = (ArrayList<Integer[]>) LargestNumberSolver.readFile("/Users/natezuro/eclipse-workspace/cs2420ii/src/integers.txt");
        assertEquals(text[15],arr.get(2)[15]);

    }
    @Test
    void readFileTestEmpty(){
        ArrayList<Integer[]> arr = new ArrayList<>();
        arr = (ArrayList<Integer[]>) LargestNumberSolver.readFile("/Users/natezuro/eclipse-workspace/cs2420ii/src/blank.txt");
        assertEquals(numbers,arr);

    }

}