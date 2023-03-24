package assign08;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {
    Node<Integer> startNode = new Node<Integer>(3);
    BinarySearchTree<Integer> balls = new BinarySearchTree<Integer>();
    BinarySearchTree<String> ball = new BinarySearchTree<String>();
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
    	int total=1000;
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
       total=total+1000;
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
    	int total=1000;
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
       total=total+1000;
    	}
    }
    @Test
    void timingTest3(){
    	System.out.println("tree set test");
    	int total=1000;
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
       total=total+1000;
    	}
    }
//all the assert equala above are wrong
//	  @Test
//	    void containsOnSmall() {
//	        for (int i = 10; i > 0; i--) {
//	            balls.add(i);
//	            balls.add(10);
//	            balls.add(11);
//	            balls.add(0);
//	        }
//	        assertEquals(true, balls.contains(2));
//	        assertEquals(true, balls.contains(11));
//	        assertEquals(true, balls.contains(0));
//	    }
//	  @Test
//	    void containsOnString() {
//		  
//	        ball.add("cat");
//	        ball.add("steve");
//	        ball.add("stove");
//	        
//	        assertEquals(true, ball.contains("stove"));
//	    }
//	  @Test
//	    void spellChecker() {
//		  ArrayList<String>arr= new ArrayList<String>();
//		  arr.add("and");
//		  arr.add("raining");
//		  arr.add("cats");
//		  arr.add("dogs");
//		  
//	        SpellChecker check=new SpellChecker(arr);
//	        ArrayList<String>arr1= new ArrayList<String>();
//			  arr1.add("and");
//			  arr1.add("raining");
//			  arr1.add("cats");
//			  arr1.add("dogs");
//			  arr1.add("its");
//	        check.spellCheck(arr1);
//	       System.out.println(check.spellCheck(arr1).toString());
//	    }
//	  @Test
//	    void removeOnRandoms(){
//	      int a = 0; 
//		  ArrayList<Integer> list = new ArrayList<Integer>();
//	        int[] array={1882703391,-483649543,1059174907,182361766,639244271,-567159552,-762226503,511044042,633591167,254921129,-567159552};
//	        for(int i = 0; i < 100; i++){
//	            Random r = new Random();
//	            int j = r.nextInt();
//	        	balls.add(j);
//	        	if(i == 5) {
//	        		a = j;
//	        	}
//	        }
//	        assertEquals(true, balls.contains(a));
//	    }
//	  
}

