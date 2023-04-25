package comprehensive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomForest<E> implements DisjointSet<E> {
	 Map<E,ArrayList<E>> balls = new HashMap<E,ArrayList<E>>();
	@Override
	public void makeSet(E element) {
		ArrayList<E>temp=new ArrayList<E>(5);
		for (int i = 0; i < 6; i++) {
			  temp.add(null);
			}
		temp.set(0, element);
		temp.set(5, element);
		balls.put(element, temp);
	}

	@Override
	public E getRepresentative(E element) {
		
		return balls.get(element).get(5);
	}

	@Override
	public void union(E one, E two) {
		ArrayList<E> first=balls.get(one);
		ArrayList<E> second=balls.get(two);
		int element1=0;
		int element2=0;
		for(int i=0;i<5;i++) {
			if(first.get(i)==null) {
				}else {
				element1=i;
			}
			if(second.get(i)==null) {
			}else {
			element2=i;
		}
		}
		if(element1>element2) {
    		second.set(5, first.get(5));
    	}else if(element1==element2){
    		first.set(5, second.get(5));
    		second.set(element2, null);
    		second.set(element2+1,two );
    	}else {
    		first.set(5, second.get(5));
    	}
		
	}

}
