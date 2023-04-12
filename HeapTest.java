package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

class HeapTest {
	BinaryMaxHeap<Integer> test=new BinaryMaxHeap<Integer>();
	ArrayList<Integer> list=new ArrayList<Integer>();
	Comparator<Integer> cmp= new Comparat<Integer>();
	@Test
	void testAdd() {
	
		for (int i = 99; i > 0; i--) {
			test.add(i);
		}
	
		System.out.println(Arrays.toString(test.toArray()));
		System.out.println(test.size);
	}
	@Test
	void testPeak() {
		test.add(1);
		test.add(2);
		assertEquals(2,test.peek());
	}
	@Test
	void testBuildHeap() {
		for (int i = 0; i <100; i++) {
			test.add(i);
		}
		test.buildHeap();
		System.out.println(Arrays.toString(test.toArray()));
	}
	@Test
	void testHeapKth() {
		for (int i = 0; i <100; i++) {
			list.add(i);
		}
		System.out.println(FindKLargest.findKLargestHeap(list,44));
	}
	@Test
	void testSortKth() {
		for (int i = 0; i <100; i++) {
			list.add(i);
		}
		System.out.println(FindKLargest.findKLargestSort(list,44));
	}
	@Test
	void testSortComparatorKth() {
		for (int i = 0; i <100; i++) {
			list.add(i);
		}
		System.out.println(FindKLargest.findKLargestSort(list,44,cmp));
	}
	class Comparat <E>implements Comparator<Integer>{
		
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
	}

}
