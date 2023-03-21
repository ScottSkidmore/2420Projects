package assign08;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BinarySearchTreeTest {
    Node startNode = new Node(-1);
    BinarySearchTree balls = new BinarySearchTree(startNode);
    @Test
    void test1(){
        ArrayList list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }
        balls.addAll(list);
        balls.remove(3);

    }



}



