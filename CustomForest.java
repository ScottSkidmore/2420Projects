package comprehensive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomForest<E> implements DisjointSet<E> {
	 Map<E,ArrayList<E>> balls = new HashMap<E,ArrayList<E>>();
	@Override
	public void makeSet(E element) {
		ArrayList<E>temp=new ArrayList<E>();
		
		temp.add( element);
		temp.add( element);
		balls.put(element, temp);
	}

	@Override
	public E getRepresentative(E element) {
		ArrayList<E> temp= balls.get(element);
		int element1=0;
		for(int i=1;i<temp.size();i++) {
			if(temp.get(i)==null) {
				}else {
				element1=i;
			}
		}
		while(temp.get(0)!=temp.get(element1)) {
			temp=balls.get(temp.get(0));
			for(int i=1;i<temp.size();i++) {
				if(temp.get(i)==null) {
					}else {
					element1=i;
				}
			}
		}
		return temp.get(0);
	}
	

	@Override
	public void union(E one, E two) {
		ArrayList<E> first=balls.get(one);
		ArrayList<E> second=balls.get(two);
first=balls.get(first.get(0));
second=balls.get(second.get(0));
		int element1=0;
		int element2=0;
		
		for(int i=1;i<first.size();i++) {
			if(first.get(i)==null) {
				}else {
				element1=i;
			}
		}
		for(int i=1;i<second.size();i++) {
			if(second.get(i)==null) {
			}else {
			element2=i;
		}
		}
		if(element1>element2) {
    		second.set(0, first.get(0));
    	}else if(element1==element2){
    		first.set(0, second.get(0));
    		second.set(element2, null);
    		second.add(second.get(0) );
    	}else {
    		first.set(0, second.get(0));
    	}
		
	}

}
