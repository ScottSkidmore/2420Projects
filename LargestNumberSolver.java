package assign04;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumberSolver {
	public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp) {
		
	}
	public static BigInteger findLargestNumber(Integer[] arr) {
		return null;
		
	}
	public static int findLargestInt(Integer[] arr) throws OutOfRangeException{
		
	}
	public static long findLargestLong(Integer[] arr) throws OutOfRangeException{
		
	}
	public static BigInteger sum(List<Integer[]> list) {
		return null;
		
	}
	public static Integer[] findKthLargest(List<Integer[]> list, int k) throws IllegalArgumentException{
		return null;
		
	}
	public static List<Integer[]> readFile(String filename){
		return null;
		
	}
	public class ArrayComparator<T> implements Comparator<T>{

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
	public class FullArrayComparator implements Comparator<ArrayList<Integer>>{


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
}
