package assign09;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.valueOf;

/**
 * This class provides a structure and methods for
 * a hash table
 *
 * @param <K> key which determines place in table
 * @param <V> value pair of key
 */
public class HashTable<K, V> implements Map<K, V> {

    private ArrayList<MapEntry<K, V>> arr;

    private int size = 0;

    private int arrSize;

    private boolean[] tombStones;

    /**
     * Constructor for hash table
     * creates backing array structure
     */
    public HashTable() {
        this.arr = new ArrayList<MapEntry<K, V>>(23);
        tombStones = new boolean[23];
        for (int i = 0; i < 23; i++) {
            arr.add(null);
            tombStones[i] = false;
        }
        arrSize = 23;
    }

    /**
     * Removes all mappings from this map.
     * <p>
     * O(table length) for quadratic probing or separate chaining
     */
    @Override
    public void clear() {
        for (MapEntry<K, V> item : arr) {
            if (item != null) {
                remove(item.getKey());
            }
        }
        size = 0;
    }

    /**
     * Determines whether this map contains the specified key.
     * <p>
     * O(1) for quadratic probing or separate chaining
     *
     * @param key - key of what you want to find
     * @return true if this map contains the key, false otherwise
     */
    @Override
    public boolean containsKey(K key) {
        if (get(key) == null) return false;
        else return true;
    }

    /**
     * Determines whether this map contains the specified value.
     * <p>
     * O(table length) for quadratic probing
     * O(table length + N) for separate chaining
     *
     * @param value the value of what you want to find
     * @return true if this map contains one or more keys to the specified value,
     * false otherwise
     */
    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < arr.size(); i++) {
            MapEntry<K, V> item = arr.get(i);
            if (item != null && tombStones[i] == false) {
                V valuePair = item.getValue();
                if (valuePair.equals(value)) return true;
            }
        }
        return false;
    }

    /**
     * Returns a List view of the mappings contained in this map, where the ordering of
     * mapping in the list is insignificant.
     * <p>
     * O(table length) for quadratic probing
     * O(table length + N) for separate chaining
     *
     * @return a List object containing all mapping (i.e., entries) in this map
     */
    @Override
    public List<MapEntry<K, V>> entries() {
        List<MapEntry<K, V>> list = new ArrayList<MapEntry<K, V>>();
        for (MapEntry<K, V> item : arr) {
            if (item != null) {
                list.add(item);
            }
        }
        return list;
    }

    /**
     * Gets the value to which the specified key is mapped.
     * <p>
     * O(1) for quadratic probing or separate chaining
     *
     * @param key the key of the map entry value that you want returned
     * @return the value to which the specified key is mapped, or null if this map
     * contains no mapping for the key
     */
    @Override
    public V get(K key) {
        int originalIndex = compress(key.hashCode());
        int newIndex = originalIndex;
        int i = 1;
        while (arr.get(newIndex) != null && tombStones[newIndex] != true) {
            if (arr.get(newIndex).getKey().equals(key)) return arr.get(newIndex).getValue();
            newIndex = originalIndex + (i * i);
            i++;
            newIndex = newIndex % arr.size();
        }
        return null;
    }

    /**
     * Determines whether this map contains any mappings.
     * <p>
     * O(1) for quadratic probing or separate chaining
     *
     * @return true if this map contains no mappings, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * (I.e., if the key already exists in this map, resets the value;
     * otherwise adds the specified key-value pair.)
     * <p>
     * O(1) for quadratic probing or separate chaining
     *
     * @param key   key/identifier of map entry
     * @param value the key's associated value
     * @return the previous value associated with key, or null if there was no
     * mapping for key
     */
    @Override
    public V put(K key, V value) {
        MapEntry<K, V> me = new MapEntry<K, V>(key, value);
        int entry = compress(key.hashCode());
        int ogentry = entry;
        int i = 0;
        while (arr.get(entry) != null && this.tombStones[entry] == false) {
            i++;
            if (arr.get(entry).getKey().equals(me.getKey())) {
                MapEntry<K, V> holder = arr.get(entry);
                arr.set(entry, me);
                return holder.getValue();
            } else {
                entry = ogentry + (i * i);
                entry = entry % (arr.size());
            }

        }
        arr.set(entry, me);
        size++;
        double currentSize = this.size;
        if (currentSize / arr.size() >= .5) {
            reHash(arr);
        }
        return null;
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     * <p>
     * O(1) for quadratic probing or separate chaining
     *
     * @param key The key of the map entry that you want to remove
     * @return the previous value associated with key, or null if there was no
     * mapping for key
     */
    @Override
    public V remove(K key) {
        int originalIndex = compress(key.hashCode());
        int newIndex = originalIndex;
        int i = 1;
        while (arr.get(newIndex) != null) {
            if (arr.get(newIndex).getKey().equals(key) && tombStones[newIndex] == false) {
                tombStones[newIndex] = true;
                this.size--;
                V value = arr.get(newIndex).getValue();
                return value;
            }
            newIndex = originalIndex + (i * i);
            i++;
            newIndex = newIndex % arr.size();
        }
        return null;
    }

    /**
     * Determines the number of mappings in this map.
     * <p>
     * O(1) for quadratic probing or separate chaining
     *
     * @return the number of mappings in this map
     */
    @Override
    public int size() {
        return size;
    }

    public int compress(int number) {
        if (number < 0) number = number * -1;
        return number % arr.size();
    }

    /**
     * Creates a knew array of the next double prime value,
     * then puts each of the map entries that were in the old
     * array into the knew array, quadratically probing
     *
     * @param arr the array you want to rehash.
     */
    public void reHash(ArrayList<MapEntry<K, V>> arr) {
        this.size = 0;
        BigInteger num = (valueOf(arr.size() * 2)).nextProbablePrime();
        int arrSize = num.intValue();
        this.arrSize = arrSize;
        int size = arr.size();
        ArrayList<MapEntry<K, V>> newArr = new ArrayList<MapEntry<K, V>>(arrSize);

        for (int i = 0; i < arrSize; i++) {
            newArr.add(null);

        }
        this.arr = newArr;
        for (int i = 0; i < size; i++) {
            if (arr.get(i) != null && tombStones[i] != true) {
                MapEntry<K, V> me = new MapEntry<K, V>(arr.get(i).getKey(), arr.get(i).getValue());
                int entry = compress(arr.get(i).getKey().hashCode());
                int ogentry = entry;
                int j = 0;
                while (this.arr.get(entry) != null) {
                    j++;
                    if (this.arr.get(entry).getKey().equals(me.getKey())) {

                        this.arr.set(entry, me);
                    } else {
                        entry = ogentry + (j * j);
                        entry = entry % (this.arr.size());
                    }
                }
                this.arr.set(entry, me);
                this.size++;

            }
        }
        boolean[] balls = new boolean[arrSize];
        for (int i = 0; i < arrSize; i++) {
            balls[i] = false;
        }
        this.tombStones = balls;
    }

}