package core;

public class Car {
    private String type;
    private int age;

    public Car(String type, int age) {
        this.type = type;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", age=" + age +
                '}';
    }
}
