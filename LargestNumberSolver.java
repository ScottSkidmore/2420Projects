package assign04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;
import java.util.List;

/**
 *  This class contains methods that are used to construct the longest integer
 *  that can be formed from an array of numbers. It also has methods for reading
 *  files and summation.
 *  @author Scott Skidmore and Nate Zuro
 * @Version February 9th, 2023
 */
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
		if(arr.length==0) {
			return new BigInteger("0");
		}
		insertionSort(arr,new ArrayComparator());
		StringBuilder number = new StringBuilder();
		for (Integer i : arr)
			number.append(i);
		String numberString=number.toString();
		BigInteger fin= new BigInteger(numberString);
		return fin;
	}
	/**
	 * This method returns the largest int value that can be formed by arranging the
	 * integers of the given array, in any order. AnOutOfRangeException is thrown
	 * if the largest number that can be formed is too large for the int data type.
	 * @param arr - The array that you want to find the biggest possible integer.
	 * @return - biggest possible number that can be formed from the array.
	 * @throws OutOfRangeException
	 */
	public static int findLargestInt(Integer[] arr) throws OutOfRangeException{

		try {
			String stringInt = findLargestNumber(arr).toString();
			int fin= Integer.parseInt(stringInt);
			return fin;
		}
		catch(Exception e){
			throw new OutOfRangeException("int");
		}
	}

	/**
	 * This method behaves the same as the previous method, but for data type long instead of data type int.
	 * @param arr - the array that you want to find the biggest possible integer
	 * @return longest integer that can be formed as a long
	 */
	public static long findLargestLong(Integer[] arr) throws OutOfRangeException{
		try {
			String stringLong = findLargestNumber(arr).toString();
			Long fin= Long.parseLong(stringLong);
			return fin;
		}
		catch(Exception e){
			throw new OutOfRangeException("long");
		}
	}

	/**
	 * This method sums the largest numbers that can be formed by each array in the given list.
	 * This method must not alter the given list.
	 * @param list - an array list of arrays
	 * @return - the sum of all the numbers in every array.
	 */
	public static BigInteger sum(List<Integer[]> list) {
		BigInteger sum=new BigInteger("0");
		for(Integer[] arr:list) {
			insertionSort(arr,new ArrayComparator());
			StringBuilder number = new StringBuilder();
			for (Integer i : arr)
				number.append(i);
			BigInteger hold=new BigInteger(number.toString());
			sum=hold.add(sum);
		}
		return sum;
	}

	/**
	 * This method determines the kth largest number that can be formed by each array in the given list.  E.g.,
	 * if k=0 returns the largest overall, if k=list.size()-1 returns the smallest overall.  This method returns
	 * the original array that represents the kth largest number, not the kth largest number itself.
	 * @param lists list of arrays you need to look through
	 * @param k the position of the array we are looking for
	 * @return
	 * @throws Exception
	 */
	public static Integer[] findKthLargest(List<Integer[]> lists, int k) throws IllegalArgumentException {
		if(k>lists.size()-1 || k < 0) {
			throw new IllegalArgumentException("K is not a valid position in the list.");
		}
		List<Integer[]> list=lists;
		for(Integer[] arr:list)
			insertionSort(arr,new ArrayComparator());
		Integer[] largest=list.get(0);
		int count=0;
		for(int j=0;j<k;j++) {
			for(int i=j;i<list.size();i++) {
				if((findLargestNumber(list.get(i)).compareTo(findLargestNumber(largest))>0)) {
					largest=list.get(i);
					count++;
				}
			}
			Integer[] hold=list.get(j);
			int pos=list.indexOf(largest);
			list.set(j, largest);
			list.set(pos, hold);
			largest=list.get(j+1);


		}
		return list.get(k);
	}

	/**
	 *  This method generates list of integer arrays from an input file, such that each line
	 *  corresponds to one array of integers separated by blank spaces, and returns an empty
	 *  list if the file does not exist.
	 * @param filename - the file to be read
	 * @return - an array list of all of the arrays in the file.
	 */
	public static List<Integer[]> readFile(String filename) {
		String newLine;
		ArrayList<Integer[]> list = new ArrayList<>();
		try {
			
			File file = new File(filename);
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			while ((newLine = br.readLine()) != null) {
				String[] parts = newLine.split("\\s+");
				Integer[] temp = new Integer[parts.length];
				for(int i = 0; i < parts.length; i ++){
					Integer num = new Integer(parts[i]);
					temp[i] = num;
				}
				list.add(temp);
			}
		}
		catch (Exception e) {
			return list;
		}

		return list;

	}


	public static class ArrayComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			StringBuilder number = new StringBuilder();
			StringBuilder number2 = new StringBuilder();
			number.append(o1);
			number.append(o2);
			number2.append(o2);
			number2.append(o1);
			return Integer.compare(Integer.parseInt(number2.toString()), Integer.parseInt(number.toString()));
		}

	}

	public static class FullArrayComparator implements Comparator<ArrayList<Integer>> {

		@Override
		public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
			StringBuilder number = new StringBuilder();
			StringBuilder number2 = new StringBuilder();
			for (Integer i : (ArrayList<Integer>) o1)
				number.append(i);
			for (Integer j : (ArrayList<Integer>) o2)
				number2.append(j);
			return Integer.compare(Integer.parseInt(number2.toString()), Integer.parseInt(number.toString()));
		}
	}
}
