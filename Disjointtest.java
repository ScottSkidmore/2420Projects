package comprehensive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Disjointtest {
	DisjointForest<Integer>dj=new DisjointForest<Integer>();
	CustomForest<Integer>cdj=new CustomForest<Integer>();
	@Test
	void testDF() {
		dj.makeSet(12);
		dj.makeSet(11);
		dj.makeSet(10);
		dj.makeSet(9);
		dj.makeSet(8);
		dj.union(12, 11);
		dj.union(11, 9);
		dj.union(10, 8);
		dj.union(10, 9);
		for(int i=8;i<13;i++) {
			//System.out.println(dj.getRepresentative(i));
		}
	}
	@Test
	void testCustom() {
		cdj.makeSet(12);
		cdj.makeSet(11);
		cdj.makeSet(10);
		cdj.makeSet(9);
		cdj.makeSet(8);
		cdj.union(12, 11);
		cdj.union(11, 9);
		cdj.union(10, 8);
		cdj.union(10, 9);
		for(int i=8;i<13;i++) {
			System.out.println(cdj.getRepresentative(i));
		}
	}
	@Test
	void testDFOnExample() {
		dj.makeSet(1);
		dj.makeSet(2);
		dj.makeSet(3);
		dj.makeSet(4);
		dj.union(1,2);
		dj.union(1,3);
		assertEquals(true,dj.getRepresentative(2)==dj.getRepresentative(3));
		assertEquals(false,dj.getRepresentative(4)==dj.getRepresentative(3));
	}
	@Test
	void testCustomOnExample() {
		cdj.makeSet(1);
		cdj.makeSet(2);
		cdj.makeSet(3);
		cdj.makeSet(4);
		cdj.union(1,2);
		cdj.union(1,3);
		assertEquals(true,cdj.getRepresentative(2)==cdj.getRepresentative(3));
		assertEquals(false,cdj.getRepresentative(4)==cdj.getRepresentative(3));
	}
	@Test
	void testDFOnManySets() {
		for(int i=0;i<200;i++) {
			dj.makeSet(i);
		}
		dj.makeSet(1000);
		dj.makeSet(1001);
		for(int i=0;i<100;i++) {
			for(int j=100;j<200;j++) {
				dj.union(j,i);
				
			}
			dj.union(i, 2*i);
			
		}
		dj.union(1000,1);
		dj.union(1001,101);
			
		
		assertEquals(true,dj.getRepresentative(2)==dj.getRepresentative(3));
		assertEquals(true,dj.getRepresentative(1000)==dj.getRepresentative(1001));
	}
	
	@Test
	void testManySets() {
		
			dj.makeSet(1);
			dj.makeSet(2);
			dj.makeSet(3);
			dj.makeSet(4);
			dj.union(1,2);
			dj.union(3,4);
			dj.union(2,3);
			
		
	}
	
	@Test
	void testDFOnManySetsToLargeSet() {
		for(int i=0;i<128;i++) {
			dj.makeSet(i);
		}
	
		for(int i=0;i<64;i++) {
			
			dj.union(i, 63+i);
			
		}
for(int i=0;i<32;i++) {
			
			dj.union(i, 31+i);
			
		}
for(int i=0;i<16;i++) {
	
	dj.union(i, 15+i);
	
}
for(int i=0;i<8;i++) {
	
	dj.union(i, 7+i);
	
}
for(int i=0;i<4;i++) {
	
	dj.union(i, 3+i);
	
}
for(int i=0;i<2;i++) {
	
	dj.union(i, 1+i);
	
}
for(int i=0;i<128;i++) {
	System.out.println(dj.getRepresentative(i));
}
for(int i=0;i<64;i++) {
	
	assertEquals(true,dj.getRepresentative(i)==dj.getRepresentative(63+1));
	
}
	}
	

}
