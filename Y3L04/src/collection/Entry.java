package collection;
import core.Car;

public class Entry {
    private Integer key;
    private Car value;
    private Entry next;

    public Entry(Integer key, Car value, Entry next) {
        this.value = value;
        this.next = next;
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    public Car getValue() {
        return value;
    }

    public Entry getNext() {
        return next;
    }
}
