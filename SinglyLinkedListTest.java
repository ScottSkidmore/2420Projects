package assign06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SinglyLinkedListTest<E> {
    SinglyLinkedList<Integer> smallIntList= new SinglyLinkedList<Integer>();

    SinglyLinkedList<Integer> bigIntList = new SinglyLinkedList<Integer>();

    SinglyLinkedList<Point> pointList = new SinglyLinkedList<>();

    SinglyLinkedList<Integer> emptyList = new SinglyLinkedList<>();
    
    LinkedListStack<URL>UList= new LinkedListStack<URL>();


    @BeforeEach
    void setUp(){
        for(int i = 0; i < 10; i++){
            smallIntList.insertFirst(i);
        }
        for(int j = 0; j < 40; j++){
            bigIntList.insertFirst(j);
            pointList.insertFirst(new Point(j,j));
        }
    }

//---------------------------------------------Tests-Begin-Here----------------------------------------------
    @Test
    void testInsertFirstOnSmall() {
        smallIntList.insertFirst(1);
        smallIntList.insertFirst(2);
        smallIntList.insertFirst(3);
        assertEquals(3,smallIntList.get(0));
    }

    @Test
    void testInsertFirstOnBig() {
        bigIntList.insertFirst(1);
        bigIntList.insertFirst(2);
        bigIntList.insertFirst(3);
        assertEquals(3,bigIntList.get(0));
    }

    @Test
    void testInsertOnBig() {
        bigIntList.insert(0,2222);
        assertEquals(2222,bigIntList.get(0));
        bigIntList.insert(41,2222);
        assertEquals(2222, bigIntList.get(41));
        bigIntList.insert(20, 2222);
        assertEquals(2222, bigIntList.get(20));
    }

    @Test
    void testInsertOnSmall() {
        bigIntList.insert(4, 2222);
        assertEquals(2222, bigIntList.get(4));
    }
    @Test
    void testSizeOnEmpty() {
        assertEquals(0,emptyList.size());
    }
    @Test
    void testSizeOnSmall() {
        smallIntList.insertFirst(1);
        smallIntList.insertFirst(2);
        smallIntList.insertFirst(3);
        assertEquals(13,smallIntList.size());
    }

    @Test
    void testGetOnSmall() {
        assertEquals(5, smallIntList.get(4));
    }

    @Test
    void testGetOnBig() {
        assertEquals(35, bigIntList.get(4));
    }

    @Test
    void testGetAtEnds() {
        assertEquals(39, bigIntList.get(0));
        assertEquals(0, bigIntList.get(39));

    }

    @Test
    void testgetFirst() {
        assertEquals(39, bigIntList.getFirst());
        assertEquals(9, smallIntList.getFirst());
    }

    @Test
    void isEmptyTestOnSmall() {
        assertEquals(false, smallIntList.isEmpty());
    }

    @Test
    void testIsEmptyOnEmpty() {
        assertEquals(true, emptyList.isEmpty());
    }

    @Test
    void testClearOnSmall() {
        smallIntList.clear();
        assertEquals("[]", Arrays.toString(smallIntList.toArray()));
    }

    @Test
    void testClearOnPoint() {
        pointList.clear();
        assertEquals("[]", Arrays.toString(pointList.toArray()));
    }

    @Test
    void testToArray() { // should be good
        assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", Arrays.toString(smallIntList.toArray()));
    }

    @Test
    void testIndexOfTestOnSmall(){
        assertEquals(7, smallIntList.indexOf(2));
    }

    @Test
    void testIndexOfOnBig() {
        System.out.println(Arrays.toString(bigIntList.toArray()));
        assertEquals(0, bigIntList.indexOf(39));
    }
    @Test
    void testLinkedListStack() throws MalformedURLException {
       URL firstU=new URL("http://example.com/");
       UList.push(firstU);
        assertEquals(0, bigIntList.indexOf(39));
    }



}
