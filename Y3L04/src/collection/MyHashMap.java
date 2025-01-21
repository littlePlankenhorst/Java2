package collection;
import core.Car;
public class MyHashMap {
    private Entry[] entries;

    public MyHashMap(Integer size) {
        entries= new Entry[size];
    }

    public int hashFunction(Integer key){
        return key% entries.length;
    }

    public void put(Integer key, Car value){
        if (key>9999 || key<1000){
            System.out.println("Key must be 4 digits!");
            return;
        }
        int index = hashFunction(key);
        Entry current = entries[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                System.out.println("Key is taken!");
                return;
            }
            current = current.getNext();
        }
        entries[index] = new Entry(key, value, entries[index]);
    }

    public Car get(Integer key){
        int index = hashFunction(key);
        Entry current = entries[index];
        while (current!=null){
            if(current.getKey().equals(key))
                return current.getValue();
            else
                current = current.getNext();
        }

        return null;
    }
    public boolean containsKey(Integer key){
        return get(key) != null;
    }
}

