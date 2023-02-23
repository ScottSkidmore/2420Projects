package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArrayListSorterTest {
	ArrayList<Integer> list1 = new ArrayList<Integer>();

	@Test
	void test() {
		list1.add(1);
		list1.add(3);
		list1.add(2);
		list1.add(5);
		ArrayListSorter.mergesort(list1);
		System.out.println(list1.toString());
	}

	@Test
	void test1() {
		list1.add(1);
		list1.add(3);
		list1.add(2);
		list1.add(5);
		ArrayListSorter.quicksort(list1);
		System.out.println(list1.toString());
	}

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
		if (!arr.equals(ArrayListSorter.generateAscending(8)) && !arr.equals(ArrayListSorter.generateDescending(8))) {
			assertEquals(0, 0);
		} else
			assertEquals(0, 1);
	}

	@Test
	void generatePermutedTestLarge() {
		ArrayList<Integer> arr = ArrayListSorter.generatePermuted(25);
		if (!arr.equals(ArrayListSorter.generateAscending(25)) && !arr.equals(ArrayListSorter.generateDescending(25))) {
			assertEquals(0, 0);
		} else
			assertEquals(0, 1);
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
	 @Test
	    void testMergeVeryEmpty() {
	        ArrayList<Integer> arr = ArrayListSorter.generatePermuted(0);
	        ArrayList<Integer> arr2 = new ArrayList<>();
	        ArrayListSorter.mergesort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testMergeVerySmall() {
	        ArrayList<Integer> arr = ArrayListSorter.generatePermuted(1);
	        ArrayListSorter.mergesort(arr);
	        assertEquals(1, arr.get(0));
	    }

	    @Test
	    void testMergeSmallRandom() {
	        ArrayList<Integer> arr = ArrayListSorter.generatePermuted(10);
	        ArrayList<Integer> sorted = ArrayListSorter.generateAscending(10);
	        ArrayListSorter.mergesort(arr);
	        if(arr.equals(sorted))return;
	        fail("Lists are not equal");

	    }
	    @Test
	    void testMergeSmallSorted() {
	        ArrayList<Integer> arr = ArrayListSorter.generateAscending(9);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(9);
	        ArrayListSorter.mergesort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }
	    @Test
	    void testMergeSmallReversed() {
	        ArrayList<Integer> arr = ArrayListSorter.generateDescending(13);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(13);
	        ArrayListSorter.mergesort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testMergeMediumRandom() {
	        ArrayList<Integer> arr = ArrayListSorter.generatePermuted(50);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(50);
	        ArrayListSorter.mergesort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testMergeMediumSorted() {
	        ArrayList<Integer> arr = ArrayListSorter.generateAscending(51);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(51);
	        ArrayListSorter.mergesort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testMergeMediumReversed() {
	        ArrayList<Integer> arr = ArrayListSorter.generateDescending(72);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(72);
	        ArrayListSorter.mergesort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testMergeLargeRandom() {
	        ArrayList<Integer> arr = ArrayListSorter.generatePermuted(123);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(123);
	        ArrayListSorter.mergesort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testMergeLargeSorted() {
	        ArrayList<Integer> arr = ArrayListSorter.generateAscending(110);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(110);
	        ArrayListSorter.mergesort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testMergeLargeReversed() {
	        ArrayList<Integer> arr = ArrayListSorter.generateDescending(187);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(187);
	        ArrayListSorter.mergesort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }
	    @Test
	    void testQuickVeryEmpty() {
	        ArrayList<Integer> arr = ArrayListSorter.generatePermuted(0);
	        ArrayList<Integer> arr2 = new ArrayList<>();
	        ArrayListSorter.quicksort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testQuickVerySmall() {
	        ArrayList<Integer> arr = ArrayListSorter.generatePermuted(1);
	        ArrayListSorter.quicksort(arr);
	        assertEquals(1, arr.get(0));
	    }

	    @Test
	    void testQuickSmallRandom() {
	        ArrayList<Integer> arr = ArrayListSorter.generatePermuted(10);
	        ArrayList<Integer> sorted = ArrayListSorter.generateAscending(10);
	        ArrayListSorter.quicksort(arr);
	        if(arr.equals(sorted))return;
	        fail("Lists are not equal");

	    }
	    @Test
	    void testQuickSmallSorted() {
	        ArrayList<Integer> arr = ArrayListSorter.generateAscending(9);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(9);
	        ArrayListSorter.quicksort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }
	    @Test
	    void testQuickSmallReversed() {
	        ArrayList<Integer> arr = ArrayListSorter.generateDescending(13);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(13);
	        ArrayListSorter.quicksort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testQuickMediumRandom() {
	        ArrayList<Integer> arr = ArrayListSorter.generatePermuted(50);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(50);
	        ArrayListSorter.quicksort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testQuickMediumSorted() {
	        ArrayList<Integer> arr = ArrayListSorter.generateAscending(51);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(51);
	        ArrayListSorter.quicksort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testQuickMediumReversed() {
	        ArrayList<Integer> arr = ArrayListSorter.generateDescending(72);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(72);
	        ArrayListSorter.quicksort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testQuickLargeRandom() {
	        ArrayList<Integer> arr = ArrayListSorter.generatePermuted(123);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(123);
	        ArrayListSorter.quicksort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testQuickLargeSorted() {
	        ArrayList<Integer> arr = ArrayListSorter.generateAscending(110);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(110);
	        ArrayListSorter.quicksort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

	    @Test
	    void testQuickLargeReversed() {
	        ArrayList<Integer> arr = ArrayListSorter.generateDescending(187);
	        ArrayList<Integer> arr2 = ArrayListSorter.generateAscending(187);
	        ArrayListSorter.quicksort(arr);
	        if(arr.equals(arr2))return;
	        fail("Lists are not equal");
	    }

}
