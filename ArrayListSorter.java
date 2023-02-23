package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class contains methods that run merge sort and quick sort and has
 * methods to generate arrays to test the two sorting methods on.
 * 
 * @author Scott Skidmore and Nate Zuro
 * @Version February 22nd, 2023
 */
public class ArrayListSorter<T> {
	private static int insertionPoint = 10;

	/**
	 * method provides a low and high value for merge sort run to allow for a
	 * simpler call of merge sort.
	 * 
	 * @param <T>  generic type of the array
	 * @param list the array being sorted
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list) {
		ArrayList<T> tempArray = new ArrayList<>(list.size());
		mergesortRun(list, 0, list.size() - 1,tempArray);
	}

	/**
	 * This method calls merge sort recursively and then merges the divided array
	 * back into a sorted array using the merge method. Once the sub arrays reach a
	 * certain size merge sort will begin to use insertion sort to sort the smaller
	 * arrays
	 * 
	 * @param <T>  generic type of the array
	 * @param list array being sorted
	 * @param low  the lower index of the current array
	 * @param high the high index of the current array
	 */
	private static <T extends Comparable<? super T>> void mergesortRun(ArrayList<T> list, int low, int high,ArrayList<T> tempArray) {
		if (high - low <= insertionPoint) {
			int lower = low + 1;
			while ( lower <= high) {
				int first = lower - 1;
				int second = lower;
				while (list.get(first).compareTo(list.get(second)) > 0) {
					T tempElement = list.get(first);
					list.set(first, list.get(second));
					list.set(second, tempElement);
					if (first > low) {
						second = second - 1;
						first = first - 1;
					}
				}
				lower++;
			}
		} else {
			int middle = (low + high) / 2;
			mergesortRun(list, low, middle,tempArray);
			mergesortRun(list, middle + 1, high,tempArray);
			merge(list, low, middle, high, tempArray);
		}
	}

	/**
	 * This method merges the divided arrays created by merge sort into a fully
	 * sorted array.
	 * 
	 * @param <T>    generic type of the array
	 * @param list   the array being sorted
	 * @param low    the low index of sub array or full array
	 * @param middle the middle index of array or sub array
	 * @param high   the high index of array or sub array
	 * @param tempArray   a temporary array to hold values
	 */
	private static <T extends Comparable<? super T>> void merge(ArrayList<T> list, int low, int middle, int high,ArrayList<T> tempArray) {
		tempArray.clear();
		int lower = low;
		int mid = middle + 1;
		while (lower <= middle && mid <= high) {
			if (list.get(lower).compareTo(list.get(mid)) <= 0) {
				tempArray.add(list.get(lower));
				lower++;
			} else {
				tempArray.add(list.get(mid));
				mid++;
			}
		}
		while (lower <= middle) {
			tempArray.add(list.get(lower));
			lower++;
		}
		while (mid <= high) {
			tempArray.add(list.get(mid));
			mid++;
		}
		for (int i = 0; i < tempArray.size(); i++) {
			list.set(low + i, tempArray.get(i));
		}
	}

	/**
	 * method provides a low and high value for quick sort run to allow for a
	 * simpler call of quick sort.
	 * 
	 * @param <T>  generic type of the array
	 * @param list the array being sorted
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list) {
		quicksortRun(list, 0, list.size() - 1);
	}

	/**
	 * This method calls quick sort recursively and then uses partition to divide
	 * the array and sort it as it goes.
	 * 
	 * @param <T>  generic type of the array
	 * @param list array being sorted
	 * @param low  the lower index of the current array
	 * @param high the high index of the current array
	 */
	private static <T extends Comparable<? super T>> void quicksortRun(ArrayList<T> list, int low, int high) {
		if (low < high) {
			int divide = partition(list, low, high);
			quicksortRun(list, low, divide - 1);
			quicksortRun(list, divide + 1, high);
		}
	}

	/**
	 * helper method to create a random pivot point
	 * 
	 * @param <T>  generic type of the array
	 * @param list the array being sorted
	 * @param low  the low index of sub array or full array
	 * @param high the high index of array or sub array
	 * @return returns the index for the pivot
	 */
	private static <T extends Comparable<? super T>> int randomPivot(ArrayList<T> list, int low, int high) {
		return new Random().nextInt(high - low) + low;
	}

	/**
	 * helper method to create a high pivot point
	 * 
	 * @param <T>  generic type of the array
	 * @param list the array being sorted
	 * @param low  the low index of sub array or full array
	 * @param high the high index of array or sub array
	 * @return returns the index for the pivot
	 */
	private static <T extends Comparable<? super T>> int highPivot(ArrayList<T> list, int low, int high) {
		return high;
	}

	/**
	 * helper method to create a pivot point in the middle
	 * 
	 * @param <T>  generic type of the array
	 * @param list the array being sorted
	 * @param low  the low index of sub array or full array
	 * @param high the high index of array or sub array
	 * @return returns the index for the pivot
	 */
	private static <T extends Comparable<? super T>> int middlePivot(ArrayList<T> list, int low, int high) {
		return low + (high - low) / 2;
	}

	/**
	 * This method picks a pivot point and sorts the array or sub array based on the
	 * pivot point given
	 * 
	 * @param <T>  generic type of the array
	 * @param list the array being sorted
	 * @param low  the low index of sub array or full array
	 * @param high the high index of array or sub array
	 * @return returns the index that the array was sorted around
	 */
	private static <T extends Comparable<? super T>> int partition(ArrayList<T> list, int low, int high) {
		int pivotIndex = randomPivot(list, low, high);
		//int pivotIndex = highPivot(list, low, high);
		//int pivotIndex = middlePivot(list, low, high);
		T pickPivot = list.get(pivotIndex);
		flip(list, pivotIndex, high);
		int lower = low - 1;
		for (int i = low; i < high; i++) {
			if (list.get(i).compareTo(pickPivot) <= 0) {
				lower++;
				flip(list, lower, i);
			}
		}
		flip(list, lower + 1, high);
		return lower + 1;
	}

	/**
	 * flips two item indexes in the array
	 * 
	 * @param <T>  Generic type of the array
	 * @param list the array being sorted
	 * @param first    the index of first item being flipped
	 * @param second    the index of second item being flipped
	 */
	private static <T extends Comparable<? super T>> void flip(ArrayList<T> list, int first, int second) {
		T holder = list.get(first);
		list.set(first, list.get(second));
		list.set(second, holder);
	}

	/**
	 * generates an array list from one to size in ascending order
	 * 
	 * @param size the size of the array
	 * @return the array in ascending order
	 */
	public static ArrayList<Integer> generateAscending(int size) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= size; i++) {
			arr.add(i);
		}
		return arr;
	}

	/**
	 * generates an array list from one to size in random order
	 * 
	 * @param size the size of the array
	 * @return the array in random order
	 */
	public static ArrayList<Integer> generatePermuted(int size) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= size; i++) {
			arr.add(i);
		}
		Collections.shuffle(arr);
		return arr;
	}

	/**
	 * generates an array list from one to size in descending order
	 * 
	 * @param size the size of the array
	 * @return the array in descending order
	 */
	public static ArrayList<Integer> generateDescending(int size) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = size; i >= 1; i--) {
			arr.add(i);
		}
		return arr;
	}

}
