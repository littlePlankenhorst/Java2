package collection;

import core.Car;

public class MyHashMap {
    private Entry[] entries;

    public MyHashMap(int size) {
        entries= new Entry[size];
    }
    
    private int hashFunction(int key) {
        return key % entries.length;
    }
    public void put(int key, Car value){
        if (key>9999 || key<1000) {
            System.out.println("Error, 4 digits number needed\n");
            return;
        }
        int index = hashFunction(key);
        Entry current = entries[index];
        while (current != null) {
            if ((current.getKey() == key)) {
                System.out.println("Error, key already exists\n");
            return;}
            current = current.getNext();
        }
        entries[index]=new Entry(key,value,entries[index]);
    }
    public Car get(int key) {
        int index = hashFunction(key);
        Entry current = entries[index];

        while (current != null) {
            if (current.getKey() == key) {
                return current.getValue();
            }
            current = current.getNext();
        }

        return null;
    }
    public boolean containsKey(int key){
        return get(key) != null;
    }
}
