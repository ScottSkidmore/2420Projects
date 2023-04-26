package comprehensive;

import java.util.LinkedList;

public interface DisjointSet<E> {

    /**
     * Makes a new set containing one element.
     *
     * @param element the element that will be in the new set.
     */
    public void makeSet(E element);

    /**
     * Gets the representative of the different sets.
     *
     * @param element an element you want to find the representative of.
     * @return the representative of the list.
     */
    public E getRepresentative(E element);

    /**
     * Combines the elements from two lists or sets.
     *
     * @param one the element from the first set you want to combine.
     * @param two the element from the second set you want to combine.
     */
    public void union(E one, E two);

}
