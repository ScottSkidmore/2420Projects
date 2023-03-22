package assign08;

/**
 * This class represents a node in a Binary Search Tree.
 * It also includes helper methods used in the Binary Search Tree Class.
 *
 * @param <T> The type of data stored in the node.
 * @Author Nate Zuro and Scott Skidmore
 * @Version March 20, 2023
 */
public class Node<T extends Comparable<? super T>> {
    private Node<T> left = null;
    private Node<T> right = null;
    private T data = null;

    /**
     * Constructs a node with the data param.
     *
     * @param data the data you want in the node.
     */
    public Node(T data){
        this.data = data;
    }

    /**
     * Gets the left child node of the current node.
     *
     * @return the left child node.
     */
    public Node<T> getLeft(){
        return left;
    }

    /**
     * Gets the right child node of the current node.
     *
     * @return the right child node.
     */
    public Node<T> getRight(){
        return right;
    }

    /**
     * Sets the left child node to a new node.
     *
     * @param node the new node that you want to set to the left node.
     */
    public void setLeft(Node<T> node){
        this.left = node;
    }

    /**
     * Sets the right child node to a new node.
     *
     * @param node the new node that you want to set to the right node.
     */
    public void setRight(Node<T> node){
        this.right = node;
    }

    /**
     * Gets that data that is stored in the node.
     *
     * @return the data stored in the node.
     */
    public T getData(){
        return this.data;
    }
}
