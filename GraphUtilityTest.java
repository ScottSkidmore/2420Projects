package assign07;


import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphUtilityTest {
	
	@Test
	void timingTestPushArray() {
		List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
    	int time=100000;
		for(int i=0;i<10;i++) {
        int count=0;
        for (int k=0;k<time;k++) {
   
        		first.add(k);
        		second.add(count+1);
        		first.add(k);
        		second.add(k-1);
        		count++;
  
        }
		double startTime=System.nanoTime();
		GraphUtility.areConnected(first, second, 0, 1000);
		double endTime=System.nanoTime();
		System.out.println(Double.toString(endTime-startTime));
		time=time+100000;
		}

	}

    @Test
    public void areConnectedSimpleTest(){
    	List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            first.add(i);
            second.add(i+1);
        }
        assertEquals(true,GraphUtility.areConnected(first,second, 1,3));

    }
    @Test
    public void areConnectedSimpleTestNotConnected(){
    	List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(1);
        second.add(3);
        first.add(4);
        second.add(5);
        
        assertEquals(false,GraphUtility.areConnected(first,second, 1,5));
    }
    @Test
    public void areConnectedSimpleTestLoop(){
    	List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(1);
        second.add(3);
        first.add(3);
        second.add(1);
        
        assertEquals(true, GraphUtility.areConnected(first,second, 1,1));
    }
    @Test
    public void areConnectedSimpleTestNotConnectedGap(){
    	List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(1);
        second.add(3);
        first.add(4);
        second.add(5);
        first.add(5);
        second.add(7);
        
        assertEquals(false,GraphUtility.areConnected(first,second, 1,7));
    }
    @Test
    public void areConnectedSimpleTestReverse(){
    	List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(1);
        second.add(4);
        first.add(4);
        second.add(5);
        first.add(5);
        second.add(7);
        
        assertEquals(false,GraphUtility.areConnected(first,second, 7,1));
    }
    @Test
    public void areConnectedMultiBranchTest(){
    	List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            first.add(i);
            second.add(i+1);
            first.add(i+2);
            second.add(i+10);
        }
        assertEquals(true,GraphUtility.areConnected(first,second, 3,11));

    }
    @Test
    public void areConnectedMultiBranchTest2(){
    	List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(1);
        second.add(10);
        first.add(1);
        second.add(11);
        first.add(10);
        second.add(20);
        first.add(10);
        second.add(112);
        assertEquals(true,GraphUtility.areConnected(first,second, 1,112));

    }
    @Test
    public void shortestPathTestSimple(){
    	List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(2);
        second.add(4);
        first.add(2);
        second.add(3);
        first.add(2);
        second.add(5);
        first.add(3);
        second.add(5);
        first.add(3);
        second.add(4);
        first.add(4);
        second.add(2);
        for(int i = 0; i < 100; i++){
            first.add(3);
            second.add(i+4);
           
        }
   
        //System.out.println(GraphUtility.shortestPath(first, second, 2,4).toString());

    }
    @Test
    public void shortestPathTestMultiPath(){
    	List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(1);
        second.add(2);
        first.add(2);
        second.add(3);
        first.add(3);
        second.add(4);
        first.add(2);
        second.add(4);
        first.add(4);
        second.add(7);
        first.add(7);
        second.add(8);
        first.add(3);
        second.add(8);
        first.add(1);
        second.add(8);
        first.add(8);
        second.add(1);
        
       // System.out.println(GraphUtility.shortestPath(first, second, 8,2).toString());

    }
    @Test
    public void shortestPathTestObject(){
    	List<Point> first = new ArrayList<>();
        List<Point> second = new ArrayList<>();
        Point point1=new Point(1,2);
        Point point2=new Point(2,3);
        Point point3=new Point(2,8);
        Point point4=new Point(2,12);
        first.add(point1);
        second.add(point2);
        first.add(point2);
        second.add(point3);
        first.add(point3);
        second.add(point4);
       
    
        
       // System.out.println(GraphUtility.shortestPath(first, second, point1, point4).toString());

    }
    @Test
    public void shortestPathTestSingle(){
    	List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(1);
        second.add(2);
       
        
       // System.out.println(GraphUtility.shortestPath(first, second, 1, 2).toString());

    }
    @Test
    public void shortestPathTestEmpty(){
    	List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
       
       
        
       //System.out.println(GraphUtility.shortestPath(first, second, 1, 2).toString());

    }
    @Test
    public void shortestPathTestMultiPathStartingMiddle(){
    	List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(1);
        second.add(2);
        first.add(2);
        second.add(3);
        first.add(3);
        second.add(4);
        first.add(4);
        second.add(5);
        List<Integer> arr=GraphUtility.shortestPath(first, second, 2, 5);
        
       System.out.println(arr);

    }
    
}