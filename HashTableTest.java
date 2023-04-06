package assign09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class HashTableTest {
	HashTable<Integer,String> test=new HashTable<Integer,String>();
	HashTable<String,Integer> test1=new HashTable<String,Integer>();
	@Test
	void putSmallTest() {
		test.put(12639,"hello");
		test.put(64489, "wild");
		test.put(5998, "wilder");
		test.put(61923, "crazy");
		
		assertEquals("hello",test.get(12639));
	}
	void containsKeyTest() {
		test.put(12639,"hello");
		test.put(64489, "wild");
		test.put(5998, "wilder");
		test.put(61923, "crazy");
		
		assertEquals(true,test.containsKey(12639));
	}
	@Test
	void getContainsKeyValueSizeTest() {
		test1.put("hello",1);
		test1.put("world",2);
		test1.put("cat",3);
		test1.put("dog",4);
		test1.remove("hello");
		
		assertEquals(null, test1.get("hello"));
		assertEquals(false,test1.containsKey("hello"));
		assertEquals(true,test1.containsValue(4));
		assertEquals(3,test1.size());
	}
	@Test
    void getContainsValueBigTest() {
        for(Integer i=0;i<20;i++) {
            test1.put(i.toString(), -i);
        }
        for(Integer i=0;i<20;i++) {
        	assertEquals(true,test1.containsValue(-i));
        }

    }
	@Test
    void getContainsValueBigTestRemove() {
        for(Integer i=0;i<20;i++) {
            test1.put(i.toString(), -i);
        }
        test1.remove("3");
        test1.remove("19");
        assertEquals(false, test1.containsValue(3));
        assertEquals(false, test1.containsValue(19));
    }
	@Test
    void getContainsValueTestDoubleStartLength() {
		for(Integer i=0;i<20;i++) {
         test1.put(i.toString(), i);
     }
        test1.put("46", 46);
        test1.remove("46");
       assertEquals(false,test1.containsValue(46));
       for(Integer i=0;i<20;i++) {
      	assertEquals(true,test1.containsValue(i));
      }

    }
	@Test
    void getContainsValueEmptyTest() {
    
        	assertEquals(false,test1.containsValue(12));
        

    }
	@Test
    void clearTest() {
		for(Integer i=0;i<20;i++) {
         test1.put(i.toString(), i);
     }
        test1.clear();
       for(Integer i=0;i<20;i++) {
      	assertEquals(false,test1.containsValue(i));
      }

    }
	@Test
    void getContainsKeyBigTestRemove() {
        for(Integer i=0;i<20;i++) {
            test1.put(i.toString(), i);
        }
        test1.remove("3");
        test1.remove("19");
        assertEquals(false, test1.containsKey("3"));
        assertEquals(false, test1.containsKey("19"));
    }
	@Test
    void listTest() {
		for(Integer i=0;i<20;i++) {
         test1.put(i.toString(), i);
     }
       List<MapEntry<String, Integer>> arr= test1.entries();
       for(MapEntry<String,Integer> t:arr) {
      	System.out.println(t.getValue());
      }

    }
	@Test
    void listOnEmptyTest() {
       List<MapEntry<String, Integer>> arr= test1.entries();
       for(MapEntry<String,Integer> t:arr) {
      	assertEquals(null,t.getValue());
      }

    }
	@Test
    void isEmptyTest() {
		for(Integer i=0;i<20;i++) {
         test1.put(i.toString(), i);
     }
        test1.clear();
      	assertEquals(true,test1.isEmpty());
      

    }
	@Test
    void isEmptyTestOnFull() {
        for(Integer i=0;i<20;i++) {
            test1.put(i.toString(), i);
        }

        assertEquals(false, test1.isEmpty());
      
    }
	@Test
    void sizeAfterRemoveTest() {
        for(Integer i=0;i<20;i++) {
            test1.put(i.toString(), i);
        }
        test1.remove("3");
        test1.remove("19");
        assertEquals(18, test1.size());
    }
	@Test
    void removeTwiceTest() {
        for(Integer i=0;i<20;i++) {
            test1.put(i.toString(), i);
        }
        test1.remove("3");
        assertEquals(null,test1.remove("3"));
    }
	@Test
    void removeEmptyTest() {
        test1.remove("3");
        assertEquals(null,test1.remove("3"));
    }
	@Test
    void reHashTest() {
		for(Integer i=0;i<2000;i++) {
         test1.put(i.toString(), i);
     }
       for(Integer i=0;i<2000;i++) {
      	assertEquals(true,test1.containsValue(i));
      }

    }
}
