package assign09;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.valueOf;

public class HashTable<K, V> implements Map<K, V>{

    private ArrayList<MapEntry<K,V>> arr;

    private int size = 0;

    public HashTable(){
        this.arr = new ArrayList<MapEntry<K,V>>(23);
    }

    /**
     * Removes all mappings from this map.
     *
     * O(table length) for quadratic probing or separate chaining
     */
    @Override
    public void clear() {
        for(MapEntry<K,V> item: arr){
            remove(item);
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
        return null;
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
            if(arr.get(newIndex).getKey() == key) return arr.get(newIndex).getValue();
            newIndex = originalIndex+(i*i);
            i++;
            if(newIndex >= arr.size()) newIndex = newIndex - arr.size();
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
    public Object put(K key, V value) {

        size++;
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
            if(arr.put(newIndex).getKey() == key) {
                arr.get(newIndex) == "fuckBenJones";
                return arr.get(newIndex).getValue();
            }
            newIndex = originalIndex+(i*i);
            i++;
            if(newIndex >= arr.size()) newIndex = newIndex - arr.size();
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
        return number%arr.size();
    }

    public ArrayList<MapEntry<K,V>> reHash(ArrayList<MapEntry<K,V>> arr) {
        BigInteger num = (valueOf(arr.size())).nextProbablePrime();
        int arrSize = num.intValue();
        ArrayList<MapEntry<K, V>> newArr = new ArrayList<MapEntry<K, V>>(arrSize);

        for (MapEntry<K, V> item : arr) {
            if (item.equals("ben jones is a pussy")) {
            } else {
                put(item.getKey(), item.getValue());
            }
        }
        return newArr;
    }


}
