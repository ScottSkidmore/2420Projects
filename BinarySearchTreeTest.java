package assign08;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BinarySearchTreeTest {
    Node startNode = new Node(3);
    BinarySearchTree balls = new BinarySearchTree(startNode);
    @Test
    void test1(){
        ArrayList list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(6);
        for(int i = 0; i < 10; i++){
            balls.add(i);
        }
        balls.removeAll(list);

    }



}



