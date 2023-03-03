package assign06;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E>{

    private E data;
    int size;
    private Node<E> head;

    Iterator<E> it = iterator();

    private Node<E> tail;


    private static class Node<E>{
        private E data;
        private Node<E> nextNode;
        public Node (E data){
            this.nextNode = null;
            this.data = data;
        }
    }

    public SinglyLinkedList(){
    	head=null;
    	tail=null;
    	size=0;
    }

    @Override
    public void insertFirst(E element) {
        Node<E> newNode = new Node<E>(element);
        newNode.nextNode=head;
        head=newNode;
        size++;
    }

    public void insert(int index, E element) throws IndexOutOfBoundsException {
        it=iterator();
        Node<E> insertNode=new Node<E>(element);
        if(index > size||index<0) throw new IndexOutOfBoundsException("Index out of range of list.");
        if(index==0) {
            insertFirst(element);
        }
        if(index==1) {
            insertNode.nextNode=head.nextNode;
            head.nextNode=insertNode;
            size++;
        }
        for (int i=2;i<=index;i++) {
            if(index==i) {
                Node<E> temp=((SinglyLinkedListIterator) it).getCurrentNode();
                insertNode.nextNode=temp.nextNode;
                temp.nextNode=insertNode;
                size++;
            }
            it.next();
        }
        if (index>size) {
        	tail=insertNode;
        }

    }

    @Override
    public E getFirst() throws NoSuchElementException {
        return head.data;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if(index > size) throw new IndexOutOfBoundsException("Index out of range of list.");
        E temp=null;
        Iterator<E> it = iterator();
        Node<E> indexNode=head;
        if(index==0) {
            return indexNode.data;
        }
        for(int i = 1; i <= index; i++){
            temp=it.next();
        }
        return temp;
    }

    @Override
    public E deleteFirst() throws NoSuchElementException {
    	if(head.nextNode==null) {
    		 Node<E> newNode = head;
    	        size--;
    	        return newNode.data;
    	}
        Node<E> newNode = head;
        head = head.nextNode;
        size--;
        return newNode.data;
    }

    @Override
    public E delete(int index) throws IndexOutOfBoundsException {
        it=iterator();
        E temp=get(index);
        if(index > size||index<0) throw new IndexOutOfBoundsException("Index out of range of list.");
        if(index==0) {
            it.remove();
        }
        else {
            for (int i=0;i<=index;i++) {
                if(index==i) {
                    it.remove();
                }
                it.next();
            }
        }
        return temp;
    }

    @Override
    public int indexOf(Object element) {
        Node<E> startData = head;
        if(head.data.equals(element)) return 0;
        for(int i = 1; i < size; i++){
            if(startData.nextNode.data.equals(element)){
                return i;
            }
            startData = startData.nextNode;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(head==(null)&& tail==(null)&& size==0){
            return true;
        }
        else return false;
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        for(int i = 0; i < size; i++){
            arr[i] = get(i);
        }
        return arr;
    }

    @Override
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator();
    }

    public class SinglyLinkedListIterator implements Iterator<E>{

        private int index;
        private Node<E> currentNode = head;

        private Node<E> preNode = null;
        private boolean remove=false;


        private SinglyLinkedListIterator(){
            index =0;
        }
        public Node<E> getCurrentNode(){
        	return currentNode.nextNode;
        }
        @Override
        public boolean hasNext() {
        	if (currentNode.nextNode==null) {
        		return false;
        	}
            return true;
        }

        @Override
        public E next() {
            if(!hasNext()) throw new NoSuchElementException();
            else {
            preNode=currentNode;
            currentNode = currentNode.nextNode;
            index++;
            remove=false;
            return currentNode.data;
            }
        }

        public void remove() {
        	if(remove)throw new IllegalStateException("cannot remove twice");
            if(size==0)throw new NoSuchElementException("list is empty");
            remove=true;
            if(head.nextNode==null) {
                head=null;
                size--;
            }
            if(currentNode==head) {
                head=currentNode.nextNode;
                size--;
            }
            else {
                preNode.nextNode=currentNode.nextNode;
                size--;
            }
            remove=true;
       
        }
    }


}
