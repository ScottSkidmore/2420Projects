package comprehensive;

public class Node<E> {

    Node<E> representative = null;

    E data;

    public Node(E element){
        this.data= element;
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

}
