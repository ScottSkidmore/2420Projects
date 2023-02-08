package assign04;

import java.util.ArrayList;
import java.util.Comparator;

public class FullArrayComparator implements Comparator<ArrayList<Integer>> {
	@Override
	public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
		StringBuilder number= new StringBuilder();
		StringBuilder number2= new StringBuilder();
		for(Integer i:(ArrayList<Integer>)o1)
			number.append(i);
		for(Integer j:(ArrayList<Integer>)o2)
			number2.append(j);
		return number2.compareTo(number);
	}
}
