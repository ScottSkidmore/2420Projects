package comprehensive;

import java.util.HashMap;

public class DisjointForest<E> implements DisjointSet<E>{

    HashMap<E,Node <E>> balls = new HashMap<E,Node <E>>();

    @Override
    public void makeSet(E element) {
        Node newNode = new Node(element);
        balls.put(element, newNode);
        newNode.setRepresentative(newNode);
    }

    @Override
    public E getRepresentative(E element) {
        Node tempNode = balls.get(element);
        while(tempNode.get() != null){
            tempNode=tempNode.get();
        }
        return tempNode.getElement();
    }

    @Override
    public void union(E one, E two) {

    }
}
