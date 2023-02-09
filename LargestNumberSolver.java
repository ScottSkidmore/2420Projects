package assign04;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumberSolver {
	/**
	 * This generic method sorts the input array using an
	 * insertion sort and the input Comparator object.
	 * @param arr Array to be sorted
	 * @param cmp The comparator you want to use to sort
	 * @param <T> The type of array being sorted
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp) {
		for(int i = 1; i < arr.length; i++){
			int pos1 = i-1;
			int pos2 = i;
			while(cmp.compare(arr[pos1], arr[pos2]) > 0){
				T temp = arr[pos1];
				arr[pos1] = arr[pos2];
				arr[pos2] = temp;
				if (pos1 > 0){
					pos2 = pos2 - 1;
					pos1 = pos1 - 1;
				}
			}
		}
	}

	/**
	 * This method returns the largest number that can be formed by arranging
	 * 	the integers of the given array, in any order. If the array is empty,
	 * 	the largest number that can be formed is 0.
	 */
	public static BigInteger findLargestNumber(Integer[] arr) {

		return null;
	}


	/**
	 * This method returns the largest int value that can be formed by arranging the
	 * integers of the given array, in any order. An OutOfRangeException Download
	 * OutOfRangeException is thrown if the largest number that can be formed
	 * is too large for the int data type.  Logic for solving the problem of
	 * determining the largest number should not appear again in this method —
	 * call an existing public method or a helper method.
	 * @param arr
	 * @return
	 * @throws OutOfRangeException
	 */
	public static int findLargestInt(Integer[] arr) throws OutOfRangeException{
		return 0;
	}
	/*
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
	*/
}

