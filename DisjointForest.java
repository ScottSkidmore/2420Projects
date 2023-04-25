package comprehensive;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class DisjointForest<E> implements DisjointSet<E>{

    Map<E,Node <E>> balls = new HashMap<E,Node <E>>();

    @Override
    public void makeSet(E element) {
        Node<E> newNode = new Node<E>(element);
        newNode.setRepresentative(newNode);
        balls.put(element, newNode);
       
    }

    @Override
    public E getRepresentative(E element) {
        Node<E> tempNode;
    	try {
        tempNode = balls.get(element);
    	}catch(Exception e) {
    		throw new NoSuchElementException();
    	}
        while(tempNode.get() != tempNode){
           tempNode=balls.get(getRepresentative(tempNode.get().getElement()));
        }
        return tempNode.getElement();
    }

    @Override
    public void union(E one, E two) {
    	E first=getRepresentative(one);
    	E second=getRepresentative(two);
    	if (first==second) {
    		return;
    	}
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
