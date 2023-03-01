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
		test.insert(2, (j));
		//test.insert(1, (E)i);
		System.out.println(test.get(2));
	}

}
