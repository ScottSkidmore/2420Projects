package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryMaxHeap<E> implements PriorityQueue<E> {
	E[]backing;
	int size=0;
	Comparator<? super E> needsComparator=null;
	public BinaryMaxHeap() {
		backing = (E[]) new Object[10];
	}
	public BinaryMaxHeap(Comparator<? super E> comp) {
		backing = (E[]) new Object[10];
		needsComparator=comp;
	}
	public BinaryMaxHeap(List<? extends E>list) {
		backing = (E[]) new Object[list.size()];
		for(E item:list) {
			add(item);
		}
	}
	public BinaryMaxHeap(List<? extends E>list, Comparator<? super E>comp) {
		backing = (E[]) new Object[list.size()];
		needsComparator=comp;
		for(E item:list) {
			add(item);
		}
	}
	public void buildHeap() {
		for(int i=size/2;i>0;i--) {
			percolateDown(i);
		}
	}
	private void percolateUp(int index) {
		 int newIndex = (index ) / 2;
		 while(newIndex>0 && innerCompare(backing[index],backing[newIndex])>0) {
			 swap(backing,index,newIndex);
			 index=newIndex;
			 newIndex = (index ) / 2;
		 }
	}
	private void swap(E[] array,int first,int second) {
		E temp=array[first];
		array[first]=array[second];
		array[second]=temp;
	}
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
	private int innerCompare(E one, E two) {
		if(needsComparator!=null) {
			return needsComparator.compare(one, two);
		}else {
			
			return ((Comparable<E>)one).compareTo(two);
		}
		
	
	}
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

	@Override
	public E peek() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("heap is empty");
		}else {
		return backing[1];
		}
	}

	@Override
	public E extractMax() throws NoSuchElementException {
		E ret=backing[1];
		backing[1]=backing[size];
		size--;
		percolateDown(1);
		return ret;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(backing==null||backing[1]==null) {
			return true;
		}else {
		return false;
		}
	}

	@Override
	public  void clear() {
		backing = (E[]) new Object[size];
		size=0;
		
	}

	@Override
	public Object[] toArray() {
		Object[] ret=new Object[size];
		for(int i=1;i<size+1;i++) {
			ret[i-1]=backing[i];
		}
		return ret;
	}

}
