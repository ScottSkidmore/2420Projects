package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class LargestNumberSolverTest {

	ArrayList<Integer> array= new ArrayList<Integer>();
	ArrayList<Integer> array1= new ArrayList<Integer>( Arrays.asList(1,2,23,45));
	ArrayList<Integer> array2= new ArrayList<Integer>( Arrays.asList(23,65,768,96,34,345));
	ArrayList<Integer> array3= new ArrayList<Integer>( Arrays.asList(1,2));
	List<ArrayList<Integer>> arrays= new ArrayList<ArrayList<Integer>>();

	@Test
    <T> void compareArrayTest() {
		array.add(11);
		array.add(67);
		array.add(79);
		array.add(7);
		array.add(22);
		array.add(13);
		arrays.add(array);
		arrays.add(array1);
		arrays.add(array2);
		arrays.add(array3);
		System.out.println(arrays.toString());
		for (ArrayList<Integer> i:arrays) {
			Collections.sort(i, new ArrayComparator());
		}
		Collections.sort(arrays,new FullArrayComparator());
		System.out.print(arrays.toString());
		assertEquals(array2,arrays.get(0));
    }

}
