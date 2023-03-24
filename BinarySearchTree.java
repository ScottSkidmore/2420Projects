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
    private int size=0;
    private Node<Type> startNode = null;
    public BinarySearchTree() {

    }
    public Node<Type> getStartNode(){
        return startNode;
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
        // System.out.println(item);
        Node<Type> temp = new Node<Type>(item);
        if (startNode==null) {
            startNode=temp;
            size++;
            return true;
        }
        Node<Type> currentNode = startNode;

        if(contains(item)) {
            return false;
        }
//        if(temp.getData().compareTo(currentNode.getData()) == 0){
//            return false;
//       }
        while (currentNode.getLeft()!= null|| currentNode.getRight()!= null) {

         if(temp.getData().compareTo(currentNode.getData()) ==0) {
                return false;
            }

            if (temp.getData().compareTo(currentNode.getData()) < 0) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(temp);
                    //  System.out.println(currentNode.getData() + " left Child equals " + temp.getData());
                    size++;
                    return true;
                }
                else {
                    currentNode = currentNode.getLeft();
                }

            }
            if(temp.getData().compareTo(currentNode.getData()) >0) {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(temp);
                    // System.out.println(currentNode.getData() + " Right Child equals " + temp.getData());
                    size++;
                    return true;
                } else {
                    currentNode = currentNode.getRight();
                }
            }
        }
        if(temp.getData().compareTo(currentNode.getData()) < 0) {
            currentNode.setLeft(temp);
            // System.out.println(currentNode.getData() + " Left Child equals " + temp.getData());
        }else{
            currentNode.setRight(temp);
            //System.out.println(currentNode.getData() + " Right Child equals " + temp.getData());
        }
        size++;
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
        if(startNode==null) {

        }else {
            this.startNode = null;
        }
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
        int count=0;
        if(inOrder(item,startNode,count)>0)return true;
        return false;

    }

    public Node<Type> getLeftMostNode(Node<Type> node){
        if (node.getLeft() == null) {
            return node;
        }
        return getLeftMostNode(node.getLeft());
    }

    private Node<Type> getRightMostNode(Node<Type> node){
        if(node.getRight() == null) {
            return node;
        }
        return getRightMostNode(node.getRight());
    }
    private void inOrder(Node<Type> startNode,ArrayList<Type> arr) {
        if (startNode==null) return;
        inOrder(startNode.getLeft(),arr);
        arr.add(startNode.getData());
        inOrder(startNode.getRight(),arr);

    }
    private int inOrder(Type item,Node<Type>startNode,int count) {
        if (count>0)return count;
        if (startNode==null) return count;
        count=count+inOrder(item,startNode.getLeft(),count);
        if(startNode.getData()==item)count++;
        count=count+inOrder(item,startNode.getRight(),count);
        return count;

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
        Node<Type> temp = startNode;
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
        if(startNode==null){
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
        if(startNode == null)throw new NoSuchElementException("Set is empty");
        else{
            return getRightMostNode(startNode).getData();
        }
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
        // System.out.println("call");
        if(startNode==null)return false;
        if(startNode.getData().equals(item)){
            if (startNode.getRight() == null) {
                startNode = startNode.getLeft();
                size=size-1;
                return true;
            }
            if(startNode.getLeft() == null) {
                getLeftMostNode(startNode.getRight()).setLeft(startNode.getLeft());
                startNode = startNode.getRight();
                size=size-1;
                return true;
            }
            if(startNode.getLeft() == null && startNode.getRight() == null) startNode = null;
            getLeftMostNode(startNode.getRight()).setLeft(startNode.getLeft());
            startNode = startNode.getRight();
            size=size-1;
            return true;
        }
        Node<Type> parent = getBefore(item);
        // System.out.println(parent.getData());
        if (parent.getRight() != null && parent.getRight().getRight() != null){
            if(parent.getRight().getData().equals(item)){
                if (parent.getRight().getRight() == null) {
                    //System.out.println(parent.getData());
                    parent.setRight(parent.getRight().getLeft());
                    size=size-1;
                    return true;
                }
        }

            if(parent.getRight().getLeft() == null) {
                parent.setRight(parent.getRight().getRight());
                size=size-1;
                return true;
            }
            Node <Type> left = getLeftMostNode(parent.getRight().getRight());
            left.setLeft(parent.getRight().getLeft());
            parent.setRight(parent.getRight().getRight());
            size=size-1;
            return true;
        }
        if (parent.getLeft()!=null) {
            if(parent.getLeft().getData().equals(item)){
                if (parent.getLeft().getRight() == null) {
                    parent.setLeft(parent.getLeft().getRight());
                    size=size-1;
                    return true;
                }

                if(parent.getLeft().getLeft() == null) {
                    parent.setLeft(parent.getLeft().getRight());
                    size=size-1;
                    return true;
                }

                getLeftMostNode(parent.getLeft().getRight()).setLeft(parent.getRight().getLeft());
                parent.setRight(parent.getLeft().getRight());
                size=size-1;
                return true;
            }
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
        boolean bool = false;
        for(Type t: items){
            if(remove(t)){
                bool = true;
            }
        }
        return bool;
    }

    /**
     * Returns the number of items in this set.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an ArrayList containing all of the items in this set, in sorted
     * order.
     */
    @Override
    public ArrayList<Type>toArrayList() {
        ArrayList<Type> t=new ArrayList<Type>();
        inOrder(startNode,t);
        return t;
    }

    /**
     * If the item is in the set, the parent node of the node with that item will be returned.
     *
     * @param item
     * @return The parent node of the node with that item.
     * returns null if item is not in the set.
     */
    public Node<Type> getBefore(Type item) {
        Node<Type> temp = new Node<Type>(item);
        Node<Type> currentNode = startNode;

        if(item.equals(startNode.getData())) throw new IndexOutOfBoundsException("The data is at the first Node");

        while (currentNode.getLeft() != null|| currentNode.getRight() != null) {
            if (currentNode.getLeft() != null && temp.getData().compareTo(currentNode.getData()) < 0) {
                if(temp.getData().compareTo(currentNode.getLeft().getData()) == 0){
                    return currentNode;
                }
                if(temp.getData().compareTo(currentNode.getLeft().getData()) < 0){
                    currentNode = currentNode.getLeft();
                }
                if (currentNode.getLeft() == null) {
                    return null;
                }

            }
            if(currentNode.getRight() != null && temp.getData().compareTo(currentNode.getData()) > 0) {
                if(temp.getData().compareTo(currentNode.getRight().getData()) > 0) {
                    currentNode = currentNode.getRight();
                }
                if(temp.getData().compareTo(currentNode.getRight().getData()) == 0){
                    return currentNode;
                }
                if (currentNode.getRight() == null) {
                    return null;
                }
            }

        }
        return currentNode;
    }

}
