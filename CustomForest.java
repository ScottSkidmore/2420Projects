package comprehensive;

import java.util.ArrayList;

import java.util.HashMap;

/**
 * This class represents a custom DisjointForest. Contains methods for making, combining
 * and finding different sets.
 *
 * @param <E> The type of element that you wish to store
 */
public class CustomForest<E> implements DisjointSet<E> {
    private HashMap<E, ArrayList<E>> balls = new HashMap<E, ArrayList<E>>();

    /**
     * Makes a new set list containing one element.
     *
     * @param element the element that will be in the new set.
     */
    @Override
    public void makeSet(E element) {
        ArrayList<E> temp = new ArrayList<E>();

        temp.add(element);
        temp.add(element);
        balls.put(element, temp);
    }

    /**
     * Gets the representative of the different sets.
     *
     * @param element an element you want to find the representative of
     * @return the representative of the list.
     */
    @Override
    public E getRepresentative(E element) {
        ArrayList<E> temp = balls.get(element);
        int element1 = 0;
        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i) == null) {
            } else {
                element1 = i;
            }
        }
        while (temp.get(0) != temp.get(element1)) {
            temp = balls.get(temp.get(0));
            for (int i = 1; i < temp.size(); i++) {
                if (temp.get(i) == null) {
                } else {
                    element1 = i;
                }
            }
        }
        return temp.get(0);
    }

    /**
     * Combines the elements from two lists or sets
     *
     * @param one the element from the first set you want to combine
     * @param two the element from the second set you want to combine.
     */
    @Override
    public void union(E one, E two) {
        ArrayList<E> first = balls.get(one);
        ArrayList<E> second = balls.get(two);
        first = balls.get(first.get(0));
        second = balls.get(second.get(0));
        int element1 = 0;
        int element2 = 0;

        for (int i = 1; i < first.size(); i++) {
            if (first.get(i) == null) {
            } else {
                element1 = i;
            }
        }
        for (int i = 1; i < second.size(); i++) {
            if (second.get(i) == null) {
            } else {
                element2 = i;
            }
        }
        if (element1 > element2) {
            second.set(0, first.get(0));
        } else if (element1 == element2) {
            first.set(0, second.get(0));
            second.set(element2, null);
            second.add(second.get(0));
        } else {
            first.set(0, second.get(0));
        }

    }

}