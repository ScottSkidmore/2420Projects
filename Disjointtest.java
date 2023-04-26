package comprehensive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class Disjointtest {
    DisjointForest<Integer>dj=new DisjointForest<Integer>();
    CustomForest<Integer>cdj=new CustomForest<Integer>();

    //--------------------------------Normal-Disjoint-tests-----------------------------------
    @Test
    void testDFMakeSetSmall() {
        dj.makeSet(12);
        dj.makeSet(11);
        dj.makeSet(10);
        dj.makeSet(9);
        dj.makeSet(8);

        Integer num = dj.balls.get(12).getElement();
        assertEquals(12,num);
    }

    @Test
    void testDFMakeSetLarge() {
       for(int i = 0; i < 10_000; i++) {
           dj.makeSet(i);
       }
        Integer num = dj.balls.get(500).getElement();
        assertEquals(500,num);
    }

    @Test
    void testDFRepresentativeSmall() {
        dj.makeSet(1);
        Integer num = dj.getRepresentative(dj.balls.get(1).getElement());
        assertEquals(1,num);
    }

    @Test
    void testDFRepresentativeLarge() {
        dj.makeSet(0);
        for(int i = 1; i < 1000; i++) {
            dj.makeSet(i);
            dj.union(0,i);
        }

        Integer num = dj.getRepresentative(dj.balls.get(500).getElement());
        assertEquals(0,num);
    }

    @Test
    void testDFUnionSmall() {
        dj.makeSet(1);
        dj.makeSet(2);
        dj.makeSet(3);
        dj.makeSet(4);
        dj.union(1,2);
        dj.union(1,3);
        assertEquals(true,dj.getRepresentative(2)==dj.getRepresentative(3));
        assertEquals(false,dj.getRepresentative(4)==dj.getRepresentative(3));
    }

    @Test
    void testDFUnionOnManySets() {
        for(int i=0;i<200;i++) {
            dj.makeSet(i);
        }
        dj.makeSet(1000);
        dj.makeSet(1001);
        for(int i=0;i<100;i++) {
            for(int j=100;j<200;j++) {
                dj.union(j,i);

            }
            dj.union(i, 2*i);

        }
        dj.union(1000,1);
        dj.union(1001,101);


        assertEquals(true,dj.getRepresentative(2)==dj.getRepresentative(3));
        assertEquals(true,dj.getRepresentative(1000)==dj.getRepresentative(1001));
    }

    @Test
    void testDFUnionOn2BigSets() {
        dj.makeSet(0);
        for(int i = 1; i < 1000; i++) {
            dj.makeSet(i);
            dj.union(0,i);
        }

        dj.makeSet(1000);
        for(int i = 1000; i < 2000; i++){
            dj.makeSet(i);
            dj.union(1000, i);
        }
        dj.union(0,1000);

        for(int i = 0; i < 2000; i++){
            assertEquals(0,dj.getRepresentative(i));
        }
    }

    @Test
    void testDFOnManySetsToLargeSet() {
        for(int i=0;i<128;i++) {
            dj.makeSet(i);
        }
        for(int i=0;i<64;i++) {
            dj.union(i, 63+1);
        }
        for(int i=0;i<32;i++) {
            dj.union(i, 31+1);
        }
        for(int i=0;i<16;i++) {
            dj.union(i, 15+i);
        }
        for(int i=0;i<8;i++) {
            dj.union(i, 7+1);
        }
        for(int i=0;i<4;i++) {
            dj.union(i, 3+i);
        }
        for(int i=0;i<2;i++) {
            dj.union(i, 1+i);
        }
        for(int i=0;i<64;i++) {
            assertEquals(true,dj.getRepresentative(i)==dj.getRepresentative(63+1));
        }
    }

    @Test
    void testDFUnionEmpty() {
        dj.makeSet(12);

        try{
            dj.union(12,5);
        }
        catch(Exception e){
            return;
        }
    }

    //-----------------------------------Custom-Disjoint-tests-------------------------------------

    @Test
    void testCustomMakeSetSmall() {
        cdj.makeSet(12);
        cdj.makeSet(11);
        cdj.makeSet(10);
        cdj.makeSet(9);
        cdj.makeSet(8);

        int num = cdj.balls.get(12).get(0);
        assertEquals(12,num);
    }

    @Test
    void testCustomMakeSetLarge() {
        for(int i = 0; i < 10_000; i++) {
            cdj.makeSet(i);
        }
        ArrayList<Integer> nums = cdj.balls.get(500);
        assertEquals(500,nums.get(0));
    }

    @Test
    void testCustomRepresentativeSmall() {
        cdj.makeSet(1);
        assertEquals(1,cdj.getRepresentative(1));
    }

    @Test
    void testCustomRepresentativeLarge() {
        cdj.makeSet(0);
        for(int i = 1; i < 1000; i++) {
            cdj.makeSet(i);
            cdj.union(0,i);
        }
        assertEquals(1,cdj.getRepresentative(500));
        assertEquals(1,cdj.getRepresentative(765));
    }

    @Test
    void testCustomUnionSmall() {
        cdj.makeSet(1);
        cdj.makeSet(2);
        cdj.makeSet(3);
        cdj.makeSet(4);
        cdj.union(1,2);
        cdj.union(1,3);
        assertEquals(true,cdj.getRepresentative(2)==cdj.getRepresentative(3));
        assertEquals(false,cdj.getRepresentative(4)==cdj.getRepresentative(3));
    }

    @Test
    void testCustomUnionOnManySets() {
        for(int i=0;i<200;i++) {
            cdj.makeSet(i);
        }
        cdj.makeSet(1000);
        cdj.makeSet(1001);
        for(int i=0;i<100;i++) {
            for(int j=100;j<200;j++) {
                cdj.union(j,i);

            }
            cdj.union(i, 2*i);

        }
        cdj.union(1000,1);
        cdj.union(1001,101);


        assertEquals(true,cdj.getRepresentative(2)==cdj.getRepresentative(3));
        assertEquals(true,cdj.getRepresentative(1000)==cdj.getRepresentative(1001));
    }

    @Test
    void testCustomUnionOn2BigSets() {
        cdj.makeSet(0);
        for(int i = 1; i < 1000; i++) {
            cdj.makeSet(i);
            cdj.union(0,i);
        }

        cdj.makeSet(1000);
        for(int i = 1000; i < 2000; i++){
            cdj.makeSet(i);
            cdj.union(1000, i);
        }
        cdj.union(0,1000);

        for(int i = 0; i < 2000; i++){
            assertEquals(1000,cdj.getRepresentative(i));
        }
    }

    @Test
    void testCustomOnManySetsToLargeSet() {
        for(int i=0;i<128;i++) {
            cdj.makeSet(i);
        }
        for(int i=0;i<64;i++) {
            cdj.union(i, 63+1);
        }
        for(int i=0;i<32;i++) {
            cdj.union(i, 31+1);
        }
        for(int i=0;i<16;i++) {
            cdj.union(i, 15+i);
        }
        for(int i=0;i<8;i++) {
            cdj.union(i, 7+1);
        }
        for(int i=0;i<4;i++) {
            cdj.union(i, 3+i);
        }
        for(int i=0;i<2;i++) {
            cdj.union(i, 1+i);
        }
        for(int i=0;i<64;i++) {
            assertEquals(true,cdj.getRepresentative(i)==cdj.getRepresentative(63+1));
        }
    }

    @Test
    void testCustomUnionEmpty() {
        cdj.makeSet(12);

        try{
            cdj.union(12,5);
        }
        catch(Exception e){
            return;
        }

    }


}