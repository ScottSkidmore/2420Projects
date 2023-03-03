package assign06;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/**
 * This interface provides the behavior of an ordered list of elements.
 *
 * @author Erin Parker, Nate Zuro, Scott Skidmore
 * @version Mar 2, 2022
 *
 * @param <E> - the type of elements contained in the list
 */
public class SinglyLinkedList<E> implements List<E>{

    private E data;
    int size;
    private Node<E> head;

    Iterator<E> it = iterator();

    private Node<E> tail;


    /**
     * This embedded class provides the structure for the node object.
     *
     * @Authors Nate Zuro and Scott Skidmore
     * @param <E> Type of data in Node.
     */
    private static class Node<E>{
        private E data;
        private Node<E> nextNode;

        /**
         * Constructor for Node Object
         *
         * @param data data to be stored in Node.
         */
        public Node (E data){
            this.nextNode = null;
            this.data = data;
        }
    }

    /**
     * Constructor for Singly Linked List
     *
     */
    public SinglyLinkedList(){
        head=null;
        tail=null;
        size=0;
        it=iterator();
    }

    /**
     * Inserts an element at the beginning of the list.
     * O(1) for a singly-linked list.
     *
     * @param element - the element to add
     */
    @Override
    public void insertFirst(E element) {
        Node<E> newNode = new Node<E>(element);
        newNode.nextNode=head;
        head=newNode;
        size++;
    }

    /**
     * Inserts an element at a specific position in the list.
     * O(N) for a singly-linked list.
     *
     * @param index - the specified position
     * @param element - the element to add
     * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index > size())
     */
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


    /**
     * Gets the first element in the list.
     * O(1) for a singly-linked list.
     *
     * @return the first element in the list
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public E getFirst() throws NoSuchElementException {
        if(head==null) {
            return null;
        }
        return head.data;
    }

    /**
     * Gets the element at a specific position in the list.
     * O(N) for a singly-linked list.
     *
     * @param index - the specified position
     * @return the element at the position
     * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
     */
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

    /**
     * Deletes and returns the first element from the list.
     * O(1) for a singly-linked list.
     *
     * @return the first element
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public E deleteFirst() throws NoSuchElementException {
        if(head.nextNode==null) {
            Node<E> newNode = head;
            head=null;
            size--;
            return newNode.data;
        }
        Node<E> newNode = head;
        head = head.nextNode;
        size--;
        return newNode.data;
    }

    /**
     * Deletes and returns the element at a specific position in the list.
     * O(N) for a singly-linked list.
     *
     * @param index - the specified position
     * @return the element at the position
     * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
     */
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
                    break;
                }
                it.next();
            }
        }
        return temp;
    }

    /**
     * Determines the index of the first occurrence of the specified element in the list,
     * or -1 if this list does not contain the element.
     * O(N) for a singly-linked list.
     *
     * @param element - the element to search for
     * @return the index of the first occurrence; -1 if the element is not found
     */
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

    /**
     * O(1) for a singly-linked list, gets the number of elements in list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * O(1) for a singly-linked list.
     *
     * @return true if this collection contains no elements; false, otherwise
     */
    @Override
    public boolean isEmpty() {
        if(head==(null)&& tail==(null)&& size==0){
            return true;
        }
        else return false;
    }

    /**
     * Removes all of the elements from this list.
     * O(1) for a singly-linked list.
     */
    @Override
    public void clear() {
        head=null;
        tail=null;
        size=0;
    }

    /**
     * Generates an array containing all of the elements in this list in proper sequence
     * (from first element to last element).
     * O(N) for a singly-linked list.
     *
     * @return an array containing all of the elements in this list, in order
     */
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        for(int i = 0; i < size; i++){
            arr[i] = get(i);
        }
        return arr;
    }

    /**
     * @return an iterator over the elements in this list in proper sequence (from first
     * element to last element)
     */
    @Override
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator();
    }


    /**
     * This class provides the iterator functions used for the
     * singlyLinkedList object.
     *
     * @Authors Nate Zuro and Scott Skimdore
     * @Version Mar 2, 2023
     */
    public class SinglyLinkedListIterator implements Iterator<E>{

        private int index;
        private Node<E> currentNode = head;

        private Node<E> preNode = null;
        private boolean remove=false;

        /**
         * Constructor that sets index equal to 0.
         *
         */
        private SinglyLinkedListIterator(){
            index =0;
        }

        /**
         * Getter to see next node.
         *
         * @return Node object
         */
        public Node<E> getCurrentNode(){
            return currentNode.nextNode;
        }

        /**
         * Checks to see if list it has more elements.
         *
         * @return true if list has elements, and false if it doesn't.
         */
        @Override
        public boolean hasNext() {
            if (currentNode.nextNode==null) {
                return false;
            }
            return true;
        }

        /**
         * This method gets the next element in the array.
         *
         * @return the next element.
         */
        @Override
        public E next() {
            if(!hasNext()) throw new NoSuchElementException();
            else {
                preNode=currentNode;
                currentNode = currentNode.nextNode;
                remove=false;
                return currentNode.data;
            }
        }

        /**
         * Removes current node.
         */
        public void remove() {
            Node<E>temp=null;
            if(remove)throw new IllegalStateException("cannot remove twice");
            if(size==0)throw new NoSuchElementException("list is empty");
            remove=true;
            if(currentNode==head) {
                if(hasNext()) {
                    temp=currentNode.nextNode;
                    head=currentNode.nextNode;
                    size--;
                    currentNode=temp;
                }else {
                    head=null;
                    size--;
                    currentNode=head;
                }
            }
            else {
                if(hasNext()) {
                    preNode.nextNode=currentNode.nextNode;
                    currentNode=null;
                    size--;
                }else {
                    currentNode=null;
                    size--;
                }

            }
            remove=true;

        }
    }

}