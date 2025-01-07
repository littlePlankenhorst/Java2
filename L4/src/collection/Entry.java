package collection;
import core.*;
public class Entry {
    private int key;
    private Car value;
    private Entry next;

    public Entry(int key, Car value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public Car getValue() {
        return value;
    }

    public Entry getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
