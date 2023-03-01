package assign06;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E>{

    private E data;
    int size = 0;
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
    }

    @Override
    public void insertFirst(E element) {
        Node<E> newNode = new Node(element);
        newNode.nextNode = head;
        head = newNode;
        size++;
    }

    @Override
    public void insert(int index, E element) throws IndexOutOfBoundsException {
        if(index > size) throw new IndexOutOfBoundsException("Index out of range of list.");

        Node<E> newNode = new Node(element);
        Node<E> currentNode = head;
        int OGsize = this.size;
        int newSize = index;
        this.size = newSize;

        while(it.hasNext()){
            currentNode = (Node<E>)it.next();
            if(!it.hasNext()){
                currentNode.nextNode = newNode;
                this.size = OGsize+1;
                newNode.nextNode = (Node<E>)it.next();
            }
        }

    }

    @Override
    public E getFirst() throws NoSuchElementException {
        return (E)head;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if(index >= size) throw new IndexOutOfBoundsException("Index out of range of list.");

        Iterator<E> it = iterator();
        Node<E> indexNode = head;
        for(int i = 0; i <= index; i++){
            indexNode = (Node<E>) it.next();
        }
        return (E)indexNode;
    }

    @Override
    public E deleteFirst() throws NoSuchElementException {
        Node<E> newNode = head;
        head = head.nextNode;
        size--;
        return (E)newNode;
    }

    @Override
    public E delete(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public int indexOf(Object element) {
        Node<E> startData = head;
        if(head.equals(element)) return 0;
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
        return new SinglyLinkedListIterator();
    }

    public class SinglyLinkedListIterator implements Iterator<E>{

        private int index;
        private Node<E> currentNode = head;


        private SinglyLinkedListIterator(){
            index = 0;
        }
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if(!hasNext()) throw new NoSuchElementException();
            currentNode = currentNode.nextNode;
            index++;
            return (E) currentNode;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
