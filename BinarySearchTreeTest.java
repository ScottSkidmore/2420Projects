package assign08;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {
    Node startNode = new Node(3);
    BinarySearchTree balls = new BinarySearchTree(startNode);
    @Test
    void addSmall(){
        ArrayList list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            balls.add(i);
            list.add(i);
        }
        assertEquals(balls.toArrayList(), list);
    }

    @Test
    void leftMostNodeHeavyRight(){
        Node node = new Node(0);
        ArrayList list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(6);
        for(int i = 0; i < 10; i++){
            balls.add(i);
        }
        assertEquals(node.getData(), balls.getLeftMostNode(node).getData());

    }
    @Test
    void leftMostNodeHeavyLeft(){
        Node node = new Node(1);
        ArrayList list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(6);
        for(int i = 10; i > 0; i--){
            balls.add(i);
        }
        assertEquals(node.getData(), balls.getLeftMostNode(node).getData());
    }

    @Test
    void addSmallOnRandoms(){
        Node node = new Node(1);
        ArrayList list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(6);
        for(int i = 10; i > 0; i--){
            Random r = new Random();
            int j = r.nextInt();
            balls.add(j);
        }
        assertEquals(node.getData(), balls.getLeftMostNode(node).getData());
    }
//all the assert equala above are wrong

}



