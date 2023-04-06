package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentBadHashTest {
	HashTable<StudentBadHash,Integer> bad=new HashTable<StudentBadHash,Integer>();
	HashTable<StudentMediumHash, Integer> medium=new HashTable<StudentMediumHash,Integer>();
	HashTable<StudentGoodHash,Integer> good=new HashTable<StudentGoodHash,Integer>();
	@Test
	void mediumtest() {
		int size=0;
		System.out.println("medium");
		for(int i=1;i<11;i++) {
			size=1000;
			size=size*i;
		double startTime=System.nanoTime();
		for(int j=0;j<size;j++) {
		StudentMediumHash add=new StudentMediumHash(j,""+j,""+j);
		medium.put(add, j);
		}
		double endTime=System.nanoTime();
		double ans=endTime-startTime;
		System.out.println(ans);
		}
		
		
	}
	@Test
	void goodtest() {
		int size=0;
		System.out.println("good");
		for(int i=1;i<11;i++) {
			size=1000;
			size=size*i;
		double startTime=System.nanoTime();
		for(int j=0;j<size;j++) {
		StudentGoodHash add=new StudentGoodHash(j,""+j,""+j);
		good.put(add, j);
		}
		double endTime=System.nanoTime();
		double ans=endTime-startTime;
		System.out.println(ans);
		}
		
		
	}
	@Test
	void badtest() {
		int size=0;
		System.out.println("bad");
		for(int i=1;i<11;i++) {
			size=1000;
			size=size*i;
		double startTime=System.nanoTime();
		for(int j=0;j<size;j++) {
		StudentBadHash add=new StudentBadHash(j,""+j,""+j);
		bad.put(add, j);
		}
		double endTime=System.nanoTime();
		double ans=endTime-startTime;
		System.out.println(ans);
		}
		
		
	}

}
