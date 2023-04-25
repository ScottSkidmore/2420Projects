package comprehensive;

import java.util.HashMap;
import java.util.Map;

public class DisjointForest<E> implements DisjointSet<E>{

    Map<E,Node <E>> balls = new HashMap<E,Node <E>>();

    @Override
    public void makeSet(E element) {
        Node<E> newNode = new Node<E>(element);
        balls.put(element, newNode);
       
    }

    @Override
    public E getRepresentative(E element) {
        Node<E> tempNode = balls.get(element);
        while(tempNode.get() != null){
           tempNode=balls.get(getRepresentative(tempNode.get().getElement()));
        }
        return tempNode.getElement();
    }

    @Override
    public void union(E one, E two) {
    	E first=getRepresentative(one);
    	E second=getRepresentative(two);
    	if(balls.get(first).getRank()>balls.get(second).getRank()) {
    		balls.get(second).setRepresentative(balls.get(first));
    	}else if(balls.get(first).getRank()==balls.get(second).getRank()){
    		balls.get(first).setRepresentative(balls.get(second));
    		balls.get(second).setRank(balls.get(second).getRank()+1);
    	}else {
    		balls.get(first).setRepresentative(balls.get(second));
    	}
    	
    	}
    	
    }
