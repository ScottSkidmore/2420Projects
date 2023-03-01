package assign06;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements List{

    private T data;
    int size = 0;
    private Node<T> head;

    Iterator<T> it = iterator();

    private Node<T> tail;

    Iterator balls = new Iterator();





    private static class Node<T>{
        private T data;
        private Node<T> nextNode;
        public Node (T data){
            this.nextNode = null;
            this.data = data;
        }
    }

    public SinglyLinkedList(){
    }

    @Override
    public void insertFirst(Object element) {
        Node<T> newNode = new Node(element);
        newNode.nextNode = head;
        size++;
    }

    @Override
    public void insert(int index, Object element) throws IndexOutOfBoundsException {
        if(index > size) throw new IndexOutOfBoundsException("Index out of range of list.");

        Node<T> newNode = new Node(element);
        Node<T> currentNode = head;
        int OGsize = this.size;
        int newSize = index;
        this.size = newSize;

        while(it.hasNext()){
            currentNode = (Node<T>)it.next();
            if(!it.hasNext()){
                currentNode.nextNode = newNode;
                this.size = OGsize+1;
                newNode.nextNode = (Node<T>)it.next();
            }
        }

    }

    @Override
    public Object getFirst() throws NoSuchElementException {
        return head;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {


        throw new IndexOutOfBoundsException ("Index not valid");
    }

    @Override
    public Object deleteFirst() throws NoSuchElementException {
        Node<T> newNode = head;
        head = head.nextNode;
        size--;
        return newNode;
    }

    @Override
    public Object delete(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Iterator iterator() {
        return new SinglyLinkedListIterator;
    }

    public class SinglyLinkedListIterator implements Iterator<T>{

        private int index;
        private Node<T> currentNode = head;


        private SinglyLinkedListIterator(){
            index = 0;
        }
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            currentNode = currentNode.nextNode;
            index++;
            return (T) currentNode;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
