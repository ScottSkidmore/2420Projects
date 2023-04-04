package assign09;

import static org.junit.jupiter.api.Assertions.*;

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

        //System.out.println(test.get(24411));
    }
    @Test
    void getContainsKeyValueSizeTest() {
        test1.put("hello",1);
        test1.put("world",2);
        test1.put("cat",3);
        test1.put("dog",4);
        test1.remove("hello");

        System.out.println(test1.get("hello"));
        System.out.println(test1.containsKey("hello"));
        System.out.println(test1.containsValue(4));
        System.out.println(test1.size());
    }
    @Test
    void getContainsValueBigTest() {
        for(Integer i=0;i<14;i++) {
            test1.put(i.toString(), i);
            System.out.println(test1.arr);
        }

        System.out.println(test1.arr);
        System.out.println(test1.arr.size());

    }

}
