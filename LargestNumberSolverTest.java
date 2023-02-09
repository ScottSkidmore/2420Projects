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

class LargestNumberSolverTest{
	 Integer[] arr1 = {3,1,6,3,10,2,1};
	 Integer[] arr3 = {1,43,23,12,1,43,23,12,1,43,23,12};
	 Integer[] arr4 = {1,2};
	 Integer[] arr5 = {789,36};
	 Integer[] arr6 = {28984,29};
	 
	 ArrayList<Integer[]> numbers = new ArrayList<>();
	 

	    Point p1 = new Point(5,6);
	    Point p2 = new Point(3,5);
	    Point p3 = new Point(9,2);
	    Point p4 = new Point(1,0);
	    Point p5 = new Point(0,1);
	    Point[] arr2 = {p1,p2,p3,p4,p5};
	    Comparator<Integer> intSort = Comparator.naturalOrder();
	    Comparator<Point> pointSort = (Point o1, Point o2) -> (int)(o1.getX() - o2.getX());
	    @Test
	    void insertionSortTest(){
	        LargestNumberSolver.insertionSort(arr1,intSort);
	        //System.out.print(Arrays.toString(arr1));
	        assertEquals(1, arr1[0]);
	    }

	    @Test
	    void insertionSortTest2(){
	    	LargestNumberSolver.insertionSort(arr2,pointSort);
	        //System.out.print(Arrays.toString(arr2));
	        assertEquals(new Point(0,1), arr2[0]);
	    }


	    @Test
	    void findLargestNumberTest(){
	    	int i=63321110;
	        LargestNumberSolver.insertionSort(arr1,new ArrayComparator());
	        //System.out.println(LargestNumberSolver.findLargestNumber(arr1));
	        assertEquals(i,LargestNumberSolver.findLargestInt(arr1));
	    }

	    @Test
	    void findLargestIntTest(){

	    }

	    @Test
	    void findLargestLongTest(){

	    }

	    @Test
	    void sumTest(){
	    	numbers.add(arr3);
	    	numbers.add(arr1);
	    	//System.out.println(LargestNumberSolver.sum(numbers));
	    	assertEquals(67644231,LargestNumberSolver.sum(numbers));
	    	
	    }

	    @Test
	    void findKthLargestTest() throws Exception{
	    	numbers.add(arr3);
	    	numbers.add(arr1);
	    	numbers.add(arr4);
	    	numbers.add(arr5);
	    	numbers.add(arr6);
	    	//System.out.println(Arrays.toString(LargestNumberSolver.findKthLargest(numbers,2)));
	    	assertEquals(arr4,LargestNumberSolver.findKthLargest(numbers,4));
	    }
	    @Test
	    void readFileTest(){

	    }

}
