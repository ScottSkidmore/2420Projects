package assign07;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphUtilityTest {
    List<Integer> first = new ArrayList<>();
    List<Integer> second = new ArrayList<>();

    @Test
    public void areConnectedTest(){
        for(int i = 0; i < 3; i++){
            first.add(i);
            second.add(i+1);
        }
        assertEquals(true,GraphUtility.areConnected(first,second, 1,3));

    }
}