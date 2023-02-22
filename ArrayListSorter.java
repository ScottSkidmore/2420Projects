package assign05;

import java.util.ArrayList;
import java.util.Collections;

/**
 * merge sort is a divide and conquer algorithm. It divides the array in half until
 * it reaches a base case of one, once its there it sorts the arrays of 2, then 4, then 8 and so on.
 */
public class ArrayListSorter {
    public static ArrayList<Integer> generateAscending(int size){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 1; i <= size; i++){
            arr.add(i);
        }
        return arr;
    }

    public static ArrayList<Integer> generatePermuted(int size){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 1; i <= size; i++){
            arr.add(i);
        }
        Collections.shuffle(arr);
        return arr;
    }

    public static ArrayList<Integer> generateDescending(int size){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = size; i >= 1; i--){
            arr.add(i);
        }
        return arr;
    }

}
