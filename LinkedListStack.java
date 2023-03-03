package assign06;

import java.util.NoSuchElementException;

public class LinkedListStack<E> implements Stack<E>{
    private SinglyLinkedList<E> stack;
    public LinkedListStack(){
    	stack=new SinglyLinkedList();
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public E peek() throws NoSuchElementException {
        return stack.getFirst();
    }

    @Override
    public E pop() throws NoSuchElementException {
        return stack.deleteFirst();
    }

    @Override
    public void push(E element) {
        stack.insertFirst(element);
    }

    @Override
    public int size() {
        return stack.size;
    }
    public SinglyLinkedList<E> get() {
    	return stack;
    }
}
