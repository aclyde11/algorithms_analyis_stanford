package Hashing;

import java.util.Arrays;

/**
 * Created by austin on 8/28/16.
 */
public class MyHashTable<K, V>{
    final int DEFAULT_SIZE = 128;

    public MyEntry<K, V>[] map;
    private int count;
    private double flow_size = .67; // (0, 1)

    public MyHashTable () {
        map = new MyEntry[DEFAULT_SIZE];
    }

    public MyHashTable (int capacity) {
        map = new MyEntry[Math.max(DEFAULT_SIZE, capacity)];
    }

    private int getHash (K key) {
        return key.hashCode() % map.length;
    }

    public boolean put (K key, V value) {
        int hash = getHash(key);
        int attempt = 1;
        while (map[hash] != null) {
            hash += attempt;
            attempt *= 2;
            if (hash > map.length - 1) {
                hash = hash % map.length;
            }
            if (attempt > 128) {
               return  false;
            }
        }
        map[hash] = new MyEntry(key, value);
        count++;
        ensureCapacity();
        return true;
    }

    private void ensureCapacity () {
        if (((double) count) / map.length > (1-flow_size))  {
            rehash((int) (map.length * 1.5));
        }
    }

    private void rehash (int capacity) {
        MyEntry[] temp = map;
        map = new MyEntry[capacity];
        for(MyEntry o : temp) {
            if (o != null)
                put((K) o.key, (V) o.value);
        }
    }

    public void reflow (double percent_empty) {
        flow_size = 1 - percent_empty;
        ensureCapacity();
    }

    public V get (K key) {
        int hash = getHash(key);
        int attempt = 1;
        while (map[hash] == null || !map[hash].key.equals(key)){
            hash += attempt;
            attempt *= 2;
            if (hash > map.length - 1) {
                hash = hash % map.length;
            }
            if (attempt > 128) {
                return null;
            }
        }
        return map[getHash (key)].value;
    }

    public void print_map (){
        for (MyEntry e : map) {
            if (e != null)
                System.out.println(e.key + " " + e.value + ": " + e.key.hashCode()%map.length);
        }
    }
}