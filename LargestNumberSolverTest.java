package assign04;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestNumberSolverTest extends LargestNumberSolver{

    Integer[] arr1 = {3,1,6,3,10,2,1};

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
        insertionSort(arr1,intSort);
        System.out.print(Arrays.toString(arr1));
        assertEquals(1, arr1[0]);
    }

    @Test
    void insertionSortTest2(){
        insertionSort(arr2,pointSort);
        System.out.print(Arrays.toString(arr2));
        assertEquals(new Point(0,1), arr2[0]);
    }


    @Test
    void findLargestNumberTest(){
        System.out.print(findLargestNumber(arr1));
    }

    @Test
    void findLargestIntTest(){

    }

    @Test
    void findLargestLongTest(){

    }

    @Test
    void sumTest(){

    }

    @Test
    void findKthLargestTest(){

    }
    @Test
    void readFileTest(){

    }

}
