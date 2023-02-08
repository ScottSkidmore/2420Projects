package assign04;

import java.util.Comparator;

public class ArrayComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		StringBuilder number= new StringBuilder();
		StringBuilder number2= new StringBuilder();
		number.append(o1);
		number.append(o2);
		number2.append(o2);
		number2.append(o1);
		return number2.compareTo(number); 
	}


}
