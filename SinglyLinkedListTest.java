package assign06;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;

class SinglyLinkedListTest<E> {
	SinglyLinkedList<Integer> test= new SinglyLinkedList<Integer>();
	Integer i=1;
	Integer j=2;
	@Test
	void test() {
		test.insertFirst(i);
		test.insert(1, (i));
		test.insert(2, (i));
		test.insert(3, (j));
		test.insert(4, (i));
		test.insert(5, (j));
		test.delete(4);
		//test.insert(1, (E)i);
		System.out.println(test.get(4));
		System.out.println(test.get(3));
	}

}
