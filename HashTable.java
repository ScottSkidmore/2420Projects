package assign09;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import static java.math.BigInteger.valueOf;

public class HashTable<K, V> implements Map<K, V>{

    public ArrayList<MapEntry<K,V>> arr;

    private int size = 0;

    private int arrSize;

    public HashTable(){
        this.arr = new ArrayList<MapEntry<K,V>>(23);
        for(int i=0;i<23;i++) {
            arr.add(null);
        }
        arrSize=23;
    }

    /**
     * Removes all mappings from this map.
     *
     * O(table length) for quadratic probing or separate chaining
     */
    @Override
    public void clear() {
        for(MapEntry<K,V> item: arr){
            if(item!=null) {
                remove(item.getKey());
            }
        }
    }

    /**
     * Determines whether this map contains the specified key.
     *
     * O(1) for quadratic probing or separate chaining
     *
     * @param key
     * @return true if this map contains the key, false otherwise
     */
    @Override
    public boolean containsKey(K key) {
        if (get(key) == null) return false;
        else return true;
    }

    /**
     * Determines whether this map contains the specified value.
     *
     * O(table length) for quadratic probing
     * O(table length + N) for separate chaining
     *
     * @param value
     * @return true if this map contains one or more keys to the specified value,
     *         false otherwise
     */
    @Override
    public boolean containsValue(V value) {
        //System.out.println(value);
        for (MapEntry<K,V> item: arr){
            if(item!=null) {
                V valuePair = item.getValue();
                // System.out.println(valuePair);
                if(valuePair.equals(value)) return true;
            }
        }
        return false;
    }

    /**
     * Returns a List view of the mappings contained in this map, where the ordering of
     * mapping in the list is insignificant.
     *
     * O(table length) for quadratic probing
     * O(table length + N) for separate chaining
     *
     * @return a List object containing all mapping (i.e., entries) in this map
     */
    @Override
    public List<MapEntry<K, V>> entries() {
        List<MapEntry<K,V>> list=new ArrayList<MapEntry<K,V>>();
        for(MapEntry<K,V> item: arr){
            if(item!=null) {
                list.add(item);
            }
        }
        return list;
    }

    /**
     * Gets the value to which the specified key is mapped.
     *
     * O(1) for quadratic probing or separate chaining
     *
     * @param key
     * @return the value to which the specified key is mapped, or null if this map
     *         contains no mapping for the key
     */
    @Override
    public V get(K key) {
        int originalIndex = compress(key.hashCode());
        int newIndex = originalIndex;
        int i = 1;
        while(arr.get(newIndex) != null){
            if(arr.get(newIndex).getKey().equals(key)) return arr.get(newIndex).getValue();
            newIndex = originalIndex+(i*i);
            i++;
            newIndex = newIndex % arr.size();
        }
        return null;
    }

    /**
     * Determines whether this map contains any mappings.
     *
     * O(1) for quadratic probing or separate chaining
     *
     * @return true if this map contains no mappings, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if(size == 0) return true;
        else return false;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * (I.e., if the key already exists in this map, resets the value;
     * otherwise adds the specified key-value pair.)
     *
     * O(1) for quadratic probing or separate chaining
     *
     * @param key
     * @param value
     * @return the previous value associated with key, or null if there was no
     *         mapping for key
     */
    @Override
    public V put(K key, V value) {
        //System.out.println(key);
        MapEntry<K,V> me=new MapEntry<K, V>(key,value);
        int entry=compress(key.hashCode());
        int ogentry=entry;
        int i =0;
        while(arr.get(entry)!=null) {
            i++;
            if(arr.get(entry).getKey().equals(me.getKey())) {
                MapEntry<K,V> holder=arr.get(entry);
                arr.set(entry,me);
                return holder.getValue();
            }
            else {

                entry=ogentry+(i*i);
                while(entry>=arr.size()) {
                    //System.out.println(entry);
                    entry=entry-(arr.size());
                }
            }
            //System.out.println(entry);
        }
        arr.set(entry,me);
        this.size++;

        double currentSize=this.size;
        if (currentSize/arr.size()>=.5) {
            reHash(arr);
        }
        return null;
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     *
     * O(1) for quadratic probing or separate chaining
     *
     * @param key
     * @return the previous value associated with key, or null if there was no
     *         mapping for key
     */
    @Override
    public V remove(K key) {
        int originalIndex = compress(key.hashCode());
        int newIndex = originalIndex;
        int i = 1;
        while(arr.get(newIndex) != null){
            if(arr.get(newIndex).getKey().equals(key)) {
                arr.get(newIndex).setRemoved();
                return arr.get(newIndex).getValue();
            }
            newIndex = originalIndex+(i*i);
            i++;
            newIndex = newIndex % arr.size();
        }
        return null;
    }

    /**
     * Determines the number of mappings in this map.
     *
     * O(1) for quadratic probing or separate chaining
     *
     * @return the number of mappings in this map
     */
    @Override
    public int size() {
        return size;
    }
    public int compress(int number){
        if(number<0)number = number*-1;
        // System.out.println(number%arr.size());
        return number%arr.size();
    }
    public void reHash(ArrayList<MapEntry<K,V>> arr) {
        this.size = 0;
        BigInteger num = (valueOf(arr.size()*2)).nextProbablePrime();
        int arrSize = num.intValue();
        this.arrSize=arrSize;
        ArrayList<MapEntry<K, V>> newArr = new ArrayList<MapEntry<K, V>>(arrSize);
        ArrayList<MapEntry<K, V>> copy = new ArrayList<MapEntry<K,V>>(arr.size());

        for(int i = 0; i < arr.size(); i++){
            copy.add(arr.get(i));
        }

        for(int i = 0; i < arrSize; i++) {
            newArr.add(null);
        }

        int ogArray = arr.size();
        this.arr = newArr;
        this.arrSize = this.arr.size();

        for (int i = 0; i < ogArray; i++) {
            if(copy.get(i) != null && copy.get(i).getRemoved() !=true){
                put(copy.get(i).getKey(),copy.get(i).getValue());
                this.size++;
            }
        }

    }

}