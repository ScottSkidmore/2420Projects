package assign07;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphUtilityTest {

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
        first.add(1);
        second.add(2);
        first.add(2);
        second.add(3);
        first.add(3);
        second.add(4);
        first.add(2);
        second.add(4);
        System.out.println(GraphUtility.shortestPath(first, second, 1, 4).toString());

    }
}