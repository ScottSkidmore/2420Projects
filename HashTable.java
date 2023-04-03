package assign09;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import static java.math.BigInteger.valueOf;

public class HashTable<K, V> implements Map<K, V>{

    private ArrayList<MapEntry<K,V>> arr;

    private int size = 0;

    private int arrSize;

    public HashTable(){
        this.arr = new ArrayList<MapEntry<K,V>>();
        for(int i=0;i<24;i++) {
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
            remove(item.getKey());
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
        for (MapEntry<K,V> item: arr){
            V valuePair = item.getValue();
            if(valuePair.equals(value)) return true;
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
            list.add(item);
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
            if(newIndex >= arrSize) newIndex = newIndex - arrSize;
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
        System.out.println(key);
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
                while(entry>=arr.size()-1) {
                    entry=entry-(arr.size()-1);
                }
            }
            System.out.println(entry);
        }
        arr.set(entry,me);
        size++;
        double size=arrSize;
        double currentSize=this.size;
        if (currentSize/size>=.5) {
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
        if(containsKey(key)) {
            V holder=get(key);
            put(key,(V) "ben");
            size--;
            return holder;
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
        System.out.println(number%arr.size());
        return number%arr.size();
    }
    public void reHash(ArrayList<MapEntry<K,V>> arr) {
        BigInteger num = (valueOf(arrSize*2)).nextProbablePrime();
        int arrSize = num.intValue();
        this.arrSize=arrSize;
        ArrayList<MapEntry<K, V>> newArr = new ArrayList<MapEntry<K, V>>(arrSize);

        for (int i = 0; i< arrSize; i++) {
            if (arr.get(i) != null && arr.get(i).equals(new MapEntry<K,String>(arr.get(i).getKey(),"ben") )) {
            }
            else if(arr.get(i) != null){
                put(arr.get(i).getKey(), arr.get(i).getValue());
            }
            else newArr.set(i, null);
        }
        this.arr = newArr;
    }

}