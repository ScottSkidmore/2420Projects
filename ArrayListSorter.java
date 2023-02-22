package assign05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayListSorter<T> {
		public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list) {
		    mergesortRun(list, 0, list.size() - 1);
		}

		private static <T extends Comparable<? super T>> void mergesortRun(ArrayList<T> list, int low, int high) {
		    if (high-low<=10) {
		    	
		    }
		    else {
		        int middle = (low + high) / 2;
		        mergesortRun(list, low, middle);
		        mergesortRun(list, middle + 1, high);
		        ArrayList<T> temp = new ArrayList<>(high - low + 1);
		        merge(list, low, middle, high,temp);
		    }
		}

		private static <T extends Comparable<? super T>> void merge(ArrayList<T> list, int low, int middle, int high,ArrayList<T> temp) {
		    int i = low;
		    int j = middle + 1;
		    while (i <= middle && j <= high) {
		        if (list.get(i).compareTo(list.get(j)) <= 0) {
		            temp.add(list.get(i));
		            i++;
		        } else {
		            temp.add(list.get(j));
		            j++;
		        }
		    }
		    while (i <= middle) {
		        temp.add(list.get(i));
		        i++;
		    }
		    while (j <= high) {
		        temp.add(list.get(j));
		        j++;
		    }
		    for (int q = 0; q < temp.size(); q++) {
		        list.set(low + q, temp.get(q));
		    }
		}

	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list) {
		quicksortRun(list, 0, list.size() - 1);
	}

	private static <T extends Comparable<? super T>> void quicksortRun(ArrayList<T> list, int low, int high) {
	    if (low < high) {
	        int divide = partition(list, low, high);
	        quicksortRun(list, low, divide - 1);
	        quicksortRun(list, divide + 1, high);
	    }
	}

	private static <T extends Comparable<? super T>> int partition(ArrayList<T> list, int low, int high) {
	    //int pivotIndex= new Random().nextInt(high-low)+low;
		T pickPivot = list.get(high);
		//flip(list,pivotIndex,high);
	    int i = low - 1;
	    for (int j = low; j < high; j++) {
	        if (list.get(j).compareTo(pickPivot) <= 0) {
	            i++;
	            flip(list, i, j);
	        }
	    }
	    flip(list, i + 1, high);
	    return i + 1;
	}

	private static <T extends Comparable<? super T>> void flip(ArrayList<T> list, int i, int j) {
	    T holder = list.get(i);
	    list.set(i, list.get(j));
	    list.set(j, holder);
	}
	
	public static ArrayList<Integer> generateAscending(int size){
		return null;
		
	}
	public static ArrayList<Integer> generatePermuted(int size){
		return null;
		
	}
	public static ArrayList<Integer> generateDescending(int size){
		return null;
		
	}
}
		
	
