package comprehensive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DisjointTests {
	DisjointForest<Integer>dj=new DisjointForest<Integer>();
	CustomForest<Integer>cdj=new CustomForest<Integer>();
	@Test
	void testDF() {
		dj.makeSet(12);
		dj.makeSet(11);
		dj.makeSet(10);
		dj.makeSet(9);
		dj.makeSet(8);
		System.out.print(dj.getRepresentative(9));
		dj.union(12, 11);
		dj.union(11, 9);
		dj.union(10, 8);
		dj.union(10, 9);
		System.out.print(dj.getRepresentative(9));
	}
	@Test
	void testCustom() {
		cdj.makeSet(12);
		cdj.makeSet(11);
		cdj.makeSet(10);
		cdj.makeSet(9);
		cdj.makeSet(8);
		System.out.print(cdj.getRepresentative(9));
		cdj.union(12, 11);
		cdj.union(11, 9);
		cdj.union(10, 8);
		cdj.union(10, 9);
		System.out.print(cdj.getRepresentative(9));
	}

}
