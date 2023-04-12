package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * This class contains generic static methods for finding the k largest items in a list.
 * 
 * @author Scott Skidmore and Nate Zuro
 * @version April 12,2023
 */

public class BinaryMaxHeap<E> implements PriorityQueue<E> {
	E[]backing;
	int size=0;
	Comparator<? super E> needsComparator=null;
	/**
	 * Constructor for no list and no comparator
	 */
	public BinaryMaxHeap() {
		backing = (E[]) new Object[10];
	}
	/**
	 * Constructor for no list and comparator
	 */
	public BinaryMaxHeap(Comparator<? super E> comp) {
		backing = (E[]) new Object[10];
		needsComparator=comp;
	}
	/**
	 * Constructor for list and no comparator
	 */
	public BinaryMaxHeap(List<? extends E>list) {
		backing = (E[]) new Object[list.size()];
		for(E item:list) {
			add(item);
		}
	}
	/**
	 * Constructor for list and comparator
	 */
	public BinaryMaxHeap(List<? extends E>list, Comparator<? super E>comp) {
		backing = (E[]) new Object[list.size()];
		needsComparator=comp;
		for(E item:list) {
			add(item);
		}
	}
	/**
	 * function that constructs a max heap by percolating down the first half of an array.
	 */
	public void buildHeap() {
		for(int i=size/2;i>0;i--) {
			percolateDown(i);
		}
	}
	/**
	 * shifts an element in a heap up until it reaches the correct position
	 * @param index of the element we want to percolate up
	 */
	private void percolateUp(int index) {
		 int newIndex = (index ) / 2;
		 while(newIndex>0 && innerCompare(backing[index],backing[newIndex])>0) {
			 swap(backing,index,newIndex);
			 index=newIndex;
			 newIndex = (index ) / 2;
		 }
	}
	/**
	 * switches two element in a array
	 * @param array the array containing the elements
	 * @param first the first element we want to swap
	 * @param second the second element we want to swap
	 */
	private void swap(E[] array,int first,int second) {
		E temp=array[first];
		array[first]=array[second];
		array[second]=temp;
	}
	/**
	 * shifts an element in a heap down until it reaches the correct position
	 * @param index of the element we want to shift
	 */
	private void percolateDown(int index) {
		
		while ((index*2)+1<=size&&(innerCompare(backing[index],backing[index*2])<0||innerCompare(backing[index],backing[(index*2)+1])<0)) {
		int newIndex=0;
		if (innerCompare(backing[index*2],backing[(index*2)+1])>0) {
			newIndex = index*2;
		}else {
			 newIndex = (index*2)+1;
		}
		swap(backing,index,newIndex);
		index=newIndex;
		
		}
	}
	/**
	 * checks if the heap uses a custom comparator and then makes a comparison with it or with compare to
	 * @param one first element to compare
	 * @param two second element to compare
	 * @return 1,-1,or 0 based on the comparison of the two items
	 */
	private int innerCompare(E one, E two) {
		if(needsComparator!=null) {
			return needsComparator.compare(one, two);
		}else {
			
			return ((Comparable<E>)one).compareTo(two);
		}
		
	
	}
	/**
	 * adds an item to the heap in the correct position
	 */
	@Override
	public void add(E item) {
		
		size++;
		if(size+1 > backing.length){
			E[] newArr = (E[]) new Object[backing.length*2];
			for(int i = 0; i < backing.length; i++) {
				newArr[i]= backing[i];
			}
			backing = newArr;
		}
		if (isEmpty()) {
			backing[1]=item;
		}else {
			backing[size]=item;
			percolateUp(size);
		}
		
	}
	/**
	 * returns the top element on the heap without removing
	 * @return The top element of the heap
	 */
	@Override
	public E peek() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("heap is empty");
		}else {
		return backing[1];
		}
	}
	/**
	 * returns the top element on the heap and removes it
	 * @return the element that was removed
	 */
	@Override
	public E extractMax() throws NoSuchElementException {
		E ret=backing[1];
		backing[1]=backing[size];
		size--;
		percolateDown(1);
		return ret;
	}
	/**
	 * returns the size of the heap or number of items
	 * @return the size of the heap
	 */
	@Override
	public int size() {
		
		return size;
	}
	/**
	 * returns true if the heap is empty false if not
	 * @return the boolean telling if the heap is empty
	 */
	@Override
	public boolean isEmpty() {
		if(backing==null||backing[1]==null) {
			return true;
		}else {
		return false;
		}
	}
	/**
	 * clears the backing array of the heap
	 */
	@Override
	public  void clear() {
		backing = (E[]) new Object[size];
		size=0;
		
	}
	/**
	 * converts the backing array into an array of objects 
	 * @return the array of objects
	 */
	@Override
	public Object[] toArray() {
		Object[] ret=new Object[size];
		for(int i=1;i<size+1;i++) {
			ret[i-1]=backing[i];
		}
		return ret;
	}

}
