package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class HeapTest {
    BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    Comparator<Integer> cmp = new Comparat<Integer>();
    Comparator<Integer> reverseCmp = (s1, s2) -> s2.compareTo(s1);

    //---------------------Tests-start-here-----------------------------------

    @Test
    void testAddMedium() {
        for (int i = 99; i > 0; i--) {
            test.add(i);
        }
        assertEquals(99, test.peek());
        assertEquals(test.size(), 99);
    }

    @Test
    void testAddHuge() {
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            test.add(i);
        }
        assertEquals(test.size(), 10_000);
        assertEquals(9_999, test.peek());
    }

    @Test
    void testAddSmall() {
        for (int i = 10; i > 0; i--) {
            test.add(i);
        }
        assertEquals(test.peek(), 10);
        assertEquals(test.size(), 10);
    }

    @Test
    void testAddRepeats() {
        for (int i = 100; i > 0; i--) {
            test.add(10);
        }
        assertEquals(test.peek(), 10);
    }

    @Test
    void testPeak() {
        test.add(1);
        test.add(2);
        assertEquals(2, test.peek());
    }

    @Test
    void testPeakLarge() {
        for (int i = 0; i < 100; i++) {
            test.add(i);
        }
        assertEquals(99, test.peek());
    }

    @Test
    void testPeakEmpty() {
        try {
            test.peek();
        } catch (NoSuchElementException e) {
            return;
        }
    }

    @Test
    void testBuildHeap() {
        for (int i = 0; i < 100; i++) {
            test.add(i);
        }
        test.buildHeap();
        assertEquals(99, test.peek());
    }

    @Test
    void testBuildHeapLarge() {
        for (int i = 0; i < 10_000; i++) {
            test.add(i);
        }
        test.buildHeap();
        assertEquals(9999, test.peek());
    }

    @Test
    void testBuildHeapEmpty() {
        try {
            test.buildHeap();
        } catch (NoSuchElementException e) {
            return;
        }
    }

    @Test
    void testHeapKthMedium() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(99, FindKLargest.findKLargestHeap(list, 1).get(0));
    }

    @Test
    void testHeapKthLarge() {
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        assertEquals(9999, FindKLargest.findKLargestHeap(list, 1).get(0));
    }

    @Test
    void testHeapKthCmp() {
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        assertEquals(0, FindKLargest.findKLargestHeap(list, 1, reverseCmp).get(0));
    }

    @Test
    void testSortKth() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        FindKLargest.findKLargestSort(list, 44);
        assertEquals(44, list.get(44));
    }

    @Test
    void testSortComparatorKth() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        FindKLargest.findKLargestSort(list, 99, reverseCmp);
        assertEquals(3, list.get(96));
    }

    @Test
    void extractMaxTestSmall() {
        for (int i = 0; i < 3; i++) {
            test.add(i);
        }
        test.extractMax();
        assertEquals(1, test.peek());
    }

    @Test
    void extractMaxTestLarge() {
        for (int i = 0; i < 500; i++) {
            test.add(i);
        }
        test.extractMax();
        assertEquals(498, test.peek());
    }

    @Test
    void extractMaxTestUntilEmpty() {
        for (int i = 0; i < 500; i++) {
            test.add(i);
        }
        for (int i = 0; i < 500; i++) {
            test.extractMax();
        }
        assertEquals(0, test.peek());
    }

    @Test
    void clearTest() {
        for (int i = 0; i < 500; i++) {
            test.add(i);
        }
        test.clear();
        assertEquals(0, test.size());
    }

    @Test
    void clearTestEmpty() {
        test.clear();
        assertEquals(0, test.size());
    }

    @Test
    void percolateUpTestMedium() {
        for (int i = 0; i < 100; i++) {
            test.add(i);
            assertEquals(i, test.peek());
        }
    }

    @Test
    void percolateUpTestLarge() {
        for (int i = 0; i < 10000; i++) {
            test.add(i);
            assertEquals(i, test.peek());
        }
    }

    @Test
    void percolateDownTestMedium() {
        for (int i = 0; i < 100; i++) {
            test.add(i);
        }
        test.extractMax();
        assertEquals(98, test.peek());
    }

    @Test
    void percolateDownTestLarge() {
        for (int i = 0; i < 10000; i++) {
            test.add(i);
        }
        test.extractMax();
        assertEquals(9998, test.peek());
    }


    class Comparat<E> implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
}
