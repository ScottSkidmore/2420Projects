package assign08;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {
//    Node<Integer> startNode = new Node<Integer>(3);
//    BinarySearchTree<Integer> balls = new BinarySearchTree<Integer>();
//    @Test
//    void addSmall(){
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i = 0; i < 10; i++){
//            balls.add(i);
//            list.add(i);
//        }
//        assertEquals(balls.toArrayList(), list);
//    }
//
//    @Test
//    void leftMostNodeHeavyRight(){
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(5);
//        list.add(6);
//        for(int i = 0; i < 10; i++){
//            balls.add(i);
//        }
//        assertEquals(0, balls.getLeftMostNode(balls.getStartNode()).getData());
//
//    }
//    @Test
//    void leftMostNodeHeavyLeft(){
//        Node<Integer> node = new Node<Integer>(1);
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(5);
//        list.add(6);
//        for(int i = 10; i > 0; i--){
//            balls.add(i);
//        }
//        assertEquals(node.getData(), balls.getLeftMostNode(node).getData());
//    }
//
//    @Test
//    void addSmallOnRandoms(){
//        Node<Integer> node = new Node<Integer>(1);
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(5);
//        list.add(6);
//        for(int i = 10; i > 0; i--){
//            Random r = new Random();
//            int j = r.nextInt();
//            balls.add(j);
//        }
//        assertEquals(node.getData(), balls.getLeftMostNode(node).getData());
//    }
//    @Test
//    void sizeTestAddOnEmpty(){
//        balls.add(2);
//        balls.add(5);
//        balls.add(6);
//       
//        assertEquals(3, balls.size());
//    }
//    @Test
//    void lastTestAddOnEmpty(){
//        balls.add(2);
//        balls.add(5);
//        balls.add(6);
//       
//        assertEquals(6, balls.last());
//    }
    @Test
    void timingTest(){
//    	BinarySearchTree<Integer> balls=new BinarySearchTree<Integer>();
//    	int total1=40000;
//        for(int i=0;i<total1;i++) {
//        	balls.add(i);
//        }
//        for(int i=0;i<total1;i++) {
//        	balls.contains(i);
//        }
    	System.out.println("contains test");
    	int total=10000;
    	for(int j=0;j<19;j++) {
    	BinarySearchTree<Integer> ball=new BinarySearchTree<Integer>();
        for(int i=0;i<total;i++) {
        	ball.add(i);
        }
        double startTime=System.nanoTime();
        for(int i=0;i<total;i++) {
        	ball.contains(i);
        }
       double endTime=System.nanoTime();
       System.out.println(Double.toString(endTime-startTime));
       total=total+10000;
    	}
    }
    @Test
    void timingTest2(){
//    	BinarySearchTree<Integer> balls=new BinarySearchTree<Integer>();
//    	int total1=40000;
//        for(int i=0;i<total1;i++) {
//        	balls.add(i);
//        }
//        for(int i=0;i<total1;i++) {
//        	balls.contains(i);
//        }
    	System.out.println("contains random test");
    	int total=10000;
    	for(int j=0;j<19;j++) {
    	BinarySearchTree<Integer> ball=new BinarySearchTree<Integer>();
    	
    	ArrayList<Integer> arr=new ArrayList<Integer>();
    	 for(int i=0;i<total;i++) {
         	arr.add(i);
         	
         }
    	 Collections.shuffle(arr);
        for(int i=0;i<total;i++) {
        	
        	ball.add(arr.get(i));
        }
        double startTime=System.nanoTime();
        for(int i=0;i<total;i++) {
        	ball.contains(i);
        }
       double endTime=System.nanoTime();
       System.out.println(Double.toString(endTime-startTime));
       total=total+10000;
    	}
    }
    @Test
    void timingTest3(){
    	System.out.println("tree set test");
    	int total=10000;
    	for(int j=0;j<19;j++) {
    	TreeSet<Integer> ball=new TreeSet<Integer>();
    	
    	ArrayList<Integer> arr=new ArrayList<Integer>();
    	 for(int i=0;i<total;i++) {
         	arr.add(i);
         	
         }
    	 Collections.shuffle(arr);
        for(int i=0;i<total;i++) {
        	
        	ball.add(arr.get(i));
        }
        double startTime=System.nanoTime();
        for(int i=0;i<total;i++) {
        	ball.contains(i);
        }
       double endTime=System.nanoTime();
       System.out.println(Double.toString(endTime-startTime));
       total=total+10000;
    	}
    }
//all the assert equala above are wrong

}

