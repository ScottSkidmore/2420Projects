package assign08;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {
    BinarySearchTree<Integer> balls = new BinarySearchTree<Integer>();
    @Test
    void addSmall(){
        ArrayList<Integer> list = new ArrayList<>();
        balls.add(3);
        for(int i = 0; i < 10; i++){
            balls.add(i);
            list.add(i);
        }
        assertEquals(balls.toArrayList(), list);
    }

    @Test
    void leftMostNodeHeavyRight(){
        Node<Integer> node = new Node<Integer>(0);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(6);
        for(int i = 0; i < 10; i++){
            balls.add(i);
        }
        assertEquals(node.getData(), balls.getLeftMostNode(balls.getStartNode()).getData());

    }
    @Test
    void leftMostNodeHeavyLeft(){
        Node<Integer> node = new Node<Integer>(1);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(6);
        for(int i = 10; i > 0; i--){
            balls.add(i);
        }
        assertEquals(node.getData(), balls.getLeftMostNode(balls.getStartNode()).getData());
    }

    @Test
    void addSmallOnRandoms(){
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 10; i > 0; i--){
            Random r = new Random();
            int j = r.nextInt();
            balls.add(j);
            list.add(j);
        }
        Collections.sort(list);
        assertEquals(balls.toArrayList(), list);
    }

    @Test
    void containsOnSmall() {
        for (int i = 10; i > 0; i--) {
            balls.add(i);
        }
        balls.add(10);
        balls.add(11);
        balls.add(0);
        assertEquals(true, balls.contains(8));
        assertEquals(true, balls.contains(11));
        assertEquals(true, balls.contains(0));
    }

    @Test
    void containsEmpty() {
       assertEquals(false, balls.contains(0));
    }
    @Test
    void containsAllEmpty() {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(1);
        list.add(2);
        list.add(4);
        assertEquals(false, balls.containsAll(list));
    }

    @Test
    void addEmpty() {
        assertEquals(true, balls.add(0));
    }
    @Test
    void addAllEmpty() {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(1);
        list.add(2);
        list.add(4);
        assertEquals(true, balls.addAll(list));
    }

    @Test
    void clearEmpty(){
    }

    @Test
    void firstEmpty(){
        assertEquals(new NoSuchElementException("Set is empty"), balls.first());
    }

    @Test
    void lastEmpty(){
        assertEquals(new NoSuchElementException("Set is empty"), balls.last());
    }

    @Test
    void removeEmpty(){
        assertEquals(false, balls.remove(1));
    }

    @Test
    void removeAllEmpty(){
        ArrayList<Integer> list= new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(1);
        list.add(2);
        list.add(4);
        assertEquals(false, balls.removeAll(list));
    }
    @Test
    void addLargeOnRandoms(){
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 100; i > 0; i--){
            Random r = new Random();
            int j = r.nextInt();
            balls.add(j);
            list.add(j);
        }
        Collections.sort(list);
        assertEquals(balls.toArrayList(), list);
    }

    @Test
    void addAllLargeOnRandoms(){
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 100; i > 0; i--){
            Random r = new Random();
            int j = r.nextInt();
            list.add(j);
        }
        balls.addAll(list);
        Collections.sort(list);
        assertEquals(balls.toArrayList(), list);
    }

    @Test
    void removeOnRandoms(){
        ArrayList<Integer> list = new ArrayList<>();
        int[] array={1882703391,-483649543,1059174907,182361766,639244271,-567159552,-762226503,511044042,633591167,254921129,-567159552};
        for(int i = 0; i > array.length; i++){
            balls.add(array[i]);
        }
        assertEquals(true, balls.remove(-567159552));
    }




//all the assert equala above are wrong

}



