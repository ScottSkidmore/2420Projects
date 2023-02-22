package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArrayListSorterTest {
	ArrayList<Integer> list1=new ArrayList<Integer>();

	@Test
	void test() {
		list1.add(1);
		list1.add(3);
		list1.add(2);
		list1.add(5);
		ArrayListSorter.mergesort(list1);
		System.out.println(list1.toString());
		
		fail("Not yet implemented");
	}
	@Test
	void test1() {
		list1.add(1);
		list1.add(3);
		list1.add(2);
		list1.add(5);
		ArrayListSorter.quicksort(list1);
		System.out.println(list1.toString());
		
		fail("Not yet implemented");
	}

}
