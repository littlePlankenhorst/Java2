package core;

public class Car implements Vehicle{

    private String type;
    private int age;

    public Car(String type, int age) {
        this.type = type;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Az elem egy " + type + " markaju, " + age + " evbol valo auto.";
    }

    @Override
    public void numberOfWheels() {
        System.out.println("A kerekek szama 4");
    }
}
