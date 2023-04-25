package comprehensive;

public class Node<E> {

    Node<E> representative = null;

    E data;
    
    int rank;

    public Node(E element){
        this.data= element;
        rank=1;
    }

    public void setRepresentative(Node<E> N){
        this.representative = N;
    }

    public Node<E> get(){
        return representative;
    }
    public E getElement(){
        return data;
    }
    public int getRank(){
        return rank;
    }
    public void setRank(int n){
        this.rank = n;
    }

}
