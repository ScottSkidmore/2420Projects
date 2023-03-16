package assign07;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphUtilityTests {
    List<Integer> first = new ArrayList<>();
    List<Integer> second = new ArrayList<>();
    List<Integer> thrid = new ArrayList<>();

    @Test
    public void areConnectedTest(){
        for(Integer i = 0; i < 10; i++){
            first.add(i);
            second.add(i+1);

        }
        assertEquals(true,GraphUtility.areConnected(first,second, 1,10));
    }

    @Test
    public void areConnectedTest2(){
            first.add(1);
            second.add(2);
            first.add(1);
            second.add(3);
            assertEquals(true,GraphUtility.areConnected(first,second, 1,3));
        }
}



