package assign06;

import java.util.NoSuchElementException;

public class LinkedListStack<E> implements Stack{

    public LinkedListStack(){
    }
    private SinglyLinkedList<E> stack;
    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public Object peek() throws NoSuchElementException {
        return stack.getFirst();
    }

    @Override
    public Object pop() throws NoSuchElementException {
        return stack.deleteFirst();
    }

    @Override
    public void push(Object element) {
        stack.insertFirst((E)element);
    }

    @Override
    public int size() {
        return stack.size;
    }
}
