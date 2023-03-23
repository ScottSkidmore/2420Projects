package assign08;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

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
            balls.add(10);
            balls.add(11);
            balls.add(0);
        }
        assertEquals(true, balls.contains(2));
        assertEquals(true, balls.contains(11));
        assertEquals(true, balls.contains(0));
    }


//all the assert equala above are wrong

}



