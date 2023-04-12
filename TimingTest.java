package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import assign09.StudentMediumHash;

class TimingTest {
	BinaryMaxHeap<Integer> mh=new BinaryMaxHeap<Integer>();
	ArrayList<Integer>list=new ArrayList<Integer>();
//	@Test
//	void addtest() {
//		int size=0;
//		System.out.println("add");
//		for(int i=1;i<11;i++) {
//			size=1000000;
//			size=size*i;
//		double startTime=System.nanoTime();
//		for(int j=0;j<size;j++) {
//			mh.add(j);
//		}
//		double endTime=System.nanoTime();
//		double ans=endTime-startTime;
//		System.out.println(ans);
//		}
//		
//		
//	}
//	@Test
//	void peektest() {
//		int size=0;
//		System.out.println("peek");
//		for(int i=1;i<11;i++) {
//			size=1000000;
//			size=size*i;
//			double ans=0;
//			for(int j=0;j<size;j++) {
//				mh.add(j);
//				double startTime=System.nanoTime();
//				mh.peek();
//				double endTime=System.nanoTime();
//				ans=ans+(endTime-startTime);
//			}
//		System.out.println(ans);
//		}
//		
//		
//	}
//	@Test
//	void extractMaxtest() {
//		int size=0;
//		System.out.println("extractMax");
//		for(int i=1;i<11;i++) {
//			size=1000000;
//			size=size*i;
//			for(int j=0;j<size;j++) {
//				mh.add(j);
//			}
//		double startTime=System.nanoTime();
//		for(int j=0;j<size;j++) {
//			mh.extractMax();
//		}
//		double endTime=System.nanoTime();
//		double ans=endTime-startTime;
//		System.out.println(ans);
//		}
//		
//		
//	}
	@Test
	void KthHeaptest() {
		int size=0;
		System.out.println("Heap Kth");
		for(int i=1;i<11;i++) {
			size=100000;
			size=size*i;
			for(int j=0;j<size;j++) {
				list.add((int)Math.random()*size);
			}
		double startTime=System.nanoTime();
		for(int j=0;j<10;j++) {
			FindKLargest.findKLargestHeap(list,size/2);
		}
		double endTime=System.nanoTime();
		double ans=endTime-startTime;
		
		System.out.println(ans/10);
		}
		
		
	}
	@Test
	void KthSorttest() {
		int size=0;
		System.out.println("Sort Kth");
		for(int i=1;i<11;i++) {
			size=100000;
			size=size*i;
			for(int j=0;j<size;j++) {
				list.add(j);
			}
		double startTime=System.nanoTime();
		for(int j=0;j<10;j++) {
			FindKLargest.findKLargestSort(list, size/2);
		}
		double endTime=System.nanoTime();
		double ans=endTime-startTime;
		System.out.println(ans/10);
		}
		
		
	}
}
