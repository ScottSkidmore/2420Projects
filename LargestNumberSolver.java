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
	 * integers of the given array, in any order. An OutOfRangeException Download
	 * OutOfRangeException is thrown if the largest number that can be formed
	 * is too large for the int data type.  Logic for solving the problem of
	 * determining the largest number should not appear again in this method —
	 * call an existing public method or a helper method.
	 * @param arr
	 * @return
	 * @throws OutOfRangeException
	 */
	public static int findLargestInt(Integer[] arr) {
		insertionSort(arr,new ArrayComparator());
		StringBuilder number = new StringBuilder();
		for (Integer i : arr)
			number.append(i);
			String numberString=number.toString();
			try {
		    Integer fin= Integer.parseInt(numberString);
		    return fin;
			}
			catch(Exception OutOfRangeException){
				throw OutOfRangeException;
			}
	}

	public static long findLargestLong(Integer[] arr) {
		insertionSort(arr,new ArrayComparator());
		StringBuilder number = new StringBuilder();
		for (Integer i : arr)
			number.append(i);
			String numberString=number.toString();
			try {
		    Long fin= Long.parseLong(numberString);
		    return fin;
			}
			catch(Exception OutOfRangeException){
				throw OutOfRangeException;
			}
	}

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

	public static Integer[] findKthLargest(List<Integer[]> lists, int k) throws Exception {
		if(k>lists.size()-1) {
			throw new Exception("IllegalArgumentException");
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
		//for(Integer[] i:lists)
		//System.out.println(Arrays.toString(i));
		return list.get(k);

	}

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
		   catch (FileNotFoundException e) {
		      return list;
		   } catch (IOException e) {
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
			return number2.compareTo(number);
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
			return number2.compareTo(number);
		}

	}
}

