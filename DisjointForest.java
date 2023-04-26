package comprehensive;

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * This class represents a DisjointForest. Contains methods for making, combining
 * and finding different sets.
 *
 * @param <E> The type of element that you wish to store
 */
public class DisjointForest<E> implements DisjointSet<E> {

    private HashMap<E, Node<E>> balls = new HashMap<E, Node<E>>();

    /**
     * Makes a new set containing one element.
     *
     * @param element the element that will be in the new set.
     */
    @Override
    public void makeSet(E element) {
        Node<E> newNode = new Node<E>(element);
        newNode.setRepresentative(newNode);
        balls.put(element, newNode);

    }

    /**
     * Gets the representative of the different sets.
     *
     * @param element an element you want to find the representative of
     * @return the representative of the list.
     */
    @Override
    public E getRepresentative(E element) {
        Node<E> tempNode;
        tempNode = balls.get(element);

        if (tempNode == null) throw new NoSuchElementException();

        while (tempNode.get().get().getElement() != tempNode.get().getElement()) {
            tempNode.setRepresentative(balls.get(getRepresentative(tempNode.get().getElement())));

        }
        return tempNode.get().getElement();
    }


    /**
     * Combines the elements from two lists.
     *
     * @param one the element from the first set you want to combine.
     * @param two the element from the second set you want to combine.
     */
    @Override
    public void union(E one, E two) {
        E first = getRepresentative(one);
        E second = getRepresentative(two);
        if (first == second) {
            return;
        }
        if (balls.get(first).getRank() > balls.get(second).getRank()) {
            balls.get(second).setRepresentative(balls.get(first).get());
        } else if (balls.get(first).getRank() == balls.get(second).getRank()) {
            balls.get(second).setRepresentative(balls.get(first).get());
            balls.get(first).setRank(balls.get(first).getRank() + 1);
        } else {
            balls.get(first).setRepresentative(balls.get(second).get());
        }

    }

}