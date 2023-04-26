package comprehensive;
/**
 * Class creates a node for the disjoint set with the 
 * needed functionality
 * @author Scott and Nate
 *
 * @param <E>
 */
public class Node<E> {

    Node<E> representative = null;

    E data;
    
    int rank;
    /**
     * constructs the node assigning the rank and 
     * the data it is holding
     * @param element the data it will hold
     */
    public Node(E element){
        this.data= element;
        rank=1;
    }
/**
 * setter for the representative field
 * @param N the node we want to set the field as
 */
    public void setRepresentative(Node<E> N){
        this.representative = N;
    }
/**
 * getter for the representative field
 * @return the representative node
 */
    public Node<E> get(){
        return representative;
    }
    /**
     * getter for the data
     * @return the data of the node
     */
    public E getElement(){
        return data;
    }
    /**
     * getter for the rank of the node
     * @return the rank value
     */
    public int getRank(){
        return rank;
    }
    /**
     * setter for the rank value of a node
     * @param n value we want the rank
     */
    public void setRank(int n){
        this.rank = n;
    }

}
