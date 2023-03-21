package assign08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * A class for representing a sorted set of generically-typed items. By
 * definition, a set contains no duplicate items. The items are ordered using
 * their natural ordering (i.e., each item must be Comparable). Note that this
 * class is much like Java's SortedSet, but simpler.
 *
 * @author Scott Skidore and Nate Zuro
 * @version March 20, 2023
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type>{

    private Node startNode = null;
    public BinarySearchTree(Node n){
        this.startNode = n;
    }

    /**
     * Ensures that this set contains the specified item.
     *
     * @param item - the item whose presence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     *         the input item was actually inserted); otherwise, returns false
     */
    @Override
    public boolean add(Type item) {
        Node temp = new Node(item);
        Node currentNode = startNode;
        if(temp.getData().compareTo(currentNode.getData()) ==0){
            return false;
        }
        while (currentNode.getLeft()!=(null)|| currentNode.getRight()!=(null)) {
            if(temp.getData().compareTo(currentNode.getData()) ==0){
                return false;
            }
            if (temp.getData().compareTo(currentNode.getData()) < 0) {
                if (currentNode.getLeft().getData().equals(null)) {
                    currentNode.setLeft(temp);
                    return true;
                } else {
                    currentNode = currentNode.getLeft();
                }

            }
            if(temp.getData().compareTo(currentNode.getData()) >0) {
                if (currentNode.getRight().getData().equals(null)) {
                    currentNode.setRight(temp);
                    return true;
                } else {
                    currentNode = currentNode.getRight();
                }
            }
        }
        if(temp.getData().compareTo(currentNode.getData()) < 0) {
            currentNode.setLeft(temp);
        }else{
            currentNode.setRight(temp);
        }
        return true;
    }

    /**
     * Ensures that this set contains all items in the specified collection.
     *
     * @param items - the collection of items whose presence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     *         any item in the input collection was actually inserted); otherwise,
     *         returns false
     */
    @Override
    public boolean addAll(Collection<? extends Type> items) {
        for(Type item:items){
            if(add(item) == false){
                return false;
            }
        }
       return true;
    }

    /**
     * Removes all items from this set. The set will be empty after this method
     * call.
     */
    @Override
    public void clear() {
        this.startNode = null;
    }

    /**
     * Determines if there is an item in this set that is equal to the specified
     * item.
     *
     * @param item - the item sought in this set
     * @return true if there is an item in this set that is equal to the input item;
     *         otherwise, returns false
     */
    @Override
    public boolean contains(Type item) {
        Node temp = new Node(item);
        Node currentNode = startNode;
        if(currentNode.getData() == temp.getData()) return true;

        while (currentNode.getLeft() != null|| currentNode.getRight() != null) {
            if (temp.getData().compareTo(currentNode.getData()) < 0) {
                if(temp.getData().compareTo(currentNode.getLeft().getData()) == 0){
                    return true;
                }
                if (currentNode.getLeft().equals(null)) {
                    return false;
                } else {
                    currentNode = currentNode.getLeft();
                }

            }
            if(temp.getData().compareTo(currentNode.getData()) >0) {
                if(temp.getData().compareTo(currentNode.getRight().getData()) == 0){
                    return true;
                }
                if (currentNode.getRight().equals(null)) {
                    return false;
                } else {
                    currentNode = currentNode.getRight();
                }
            }
        }
        return false;
    }

    /**
     * Determines if for each item in the specified collection, there is an item in
     * this set that is equal to it.
     *
     * @param items - the collection of items sought in this set
     * @return true if for each item in the specified collection, there is an item
     *         in this set that is equal to it; otherwise, returns false
     */
    @Override
    public boolean containsAll(Collection<? extends Type> items) {
        for(Type item:items){
            if(contains(item) == false){
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the first (i.e., smallest) item in this set.
     *
     * @throws NoSuchElementException if the set is empty
     */
    @Override
    public Type first() throws NoSuchElementException {
        Node temp = startNode;
        if(startNode == null)throw new NoSuchElementException("Set is empty");
        else{
            while(temp!=null){
                if (temp.getLeft() == null) return (Type) temp.getData();
                temp = temp.getLeft();
            }
        }
        return null;
    }

    /**
     * Returns true if this set contains no items.
     */
    @Override
    public boolean isEmpty() {
        if(startNode.equals(null)){
            return true;
        }
        return false;
    }

    /**
     * Returns the last (i.e., largest) item in this set.
     *
     * @throws NoSuchElementException if the set is empty
     */
    @Override
    public Type last() throws NoSuchElementException {
            Node temp = startNode;
            if(startNode == null)throw new NoSuchElementException("Set is empty");
            else{
                while(temp!=null){
                    if (temp.getRight() == null) return (Type)temp.getData();
                    temp = temp.getRight();
                }
            }
        return null;
    }

    /**
     * Ensures that this set does not contain the specified item.
     *
     * @param item - the item whose absence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     *         the input item was actually removed); otherwise, returns false
     */
    @Override
    public boolean remove(Type item) {
        if(startNode.getData().equals(item)){
            getLeftMostNode(startNode.getRight()).setLeft(startNode.getLeft());
            startNode = startNode.getRight();
            return true;
        }
        Node parent = getBefore(item);
        System.out.print(parent.getData());

        if(parent.getRight().getData().equals(item)){
            if (parent.getRight().getRight() == null) {
                parent.setRight(parent.getRight().getLeft());
                return true;
            }

            if(parent.getRight().getLeft() == null) {
                parent.setRight(parent.getRight().getRight());
                return true;
            }

            getLeftMostNode(parent.getRight().getRight()).setLeft(parent.getRight().getLeft());
            parent.setRight(parent.getRight().getRight());
            return true;
        }

        if(parent.getLeft().getData().equals(item)){
            if (parent.getLeft().getRight() == null) {
                parent.setLeft(parent.getRight().getLeft());
                return true;
            }

            if(parent.getLeft().getLeft() == null) {
                parent.setLeft(parent.getLeft().getRight());
                return true;
            }

            getLeftMostNode(parent.getLeft().getRight()).setLeft(parent.getRight().getLeft());
            parent.setRight(parent.getLeft().getRight());
            return true;
        }
        return false;
    }

    /**
     * Ensures that this set does not contain any of the items in the specified
     * collection.
     *
     * @param items - the collection of items whose absence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     *         any item in the input collection was actually removed); otherwise,
     *         returns false
     */
    @Override
    public boolean removeAll(Collection<? extends Type> items) {
        return false;
    }

    /**
     * Returns the number of items in this set.
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Returns an ArrayList containing all of the items in this set, in sorted
     * order.
     */
    @Override
    public ArrayList<Type>toArrayList() {
        return null;
    }

    /**
     * If the item is in the set, the parent node of the node with that item will be returned.
     *
     * @param item
     * @return The parent node of the node with that item.
     * returns null if item is not in the set.
     */
    public Node getBefore(Type item) {
        Node temp = new Node(item);
        Node currentNode = startNode;

        if(item.equals(startNode.getData())) throw new IndexOutOfBoundsException("The data is at the first Node");

        while (currentNode.getLeft() != null|| currentNode.getRight() != null) {
            if (currentNode.getLeft() != null && temp.getData().compareTo(currentNode.getLeft().getData()) < 0) {
                if(temp.getData().compareTo(currentNode.getLeft().getData()) == 0){
                    return currentNode;
                }
                if (currentNode.getLeft().equals(null)) {
                    return null;
                } else {
                    currentNode = currentNode.getLeft();
                }

            }
            if(currentNode.getRight() != null && temp.getData().compareTo(currentNode.getData()) >0) {
                if(temp.getData().compareTo((Type)currentNode.getRight().getData()) == 0){
                    return currentNode;
                }
                if (currentNode.getRight().equals(null)) {
                    return null;
                } else {
                    currentNode = currentNode.getRight();
                }
            }
        }
        return null;
    }
    private Node getLeftMostNode(Node node){
        if(node.getLeft() == null) {
            return node;
        }
        return getRightMostNode(node.getLeft());
    }

    private Node getRightMostNode(Node node){
        if(node.getRight() == null) {
            return node;
        }
        return getLeftMostNode(node.getRight());
    }

}
