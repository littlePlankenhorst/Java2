package core;

public class Car extends Vehicle{

    private float performance;

    public Car(String type, int age, float performance) {
        super(type, age);
        this.performance = performance;
    }

    @Override
    public String toString() {
        return "Az elem egy " + type + " markaju, " + age + " evbol valo, " + performance + " loeros auto.";
    }

    public float getPerformance() {
        return performance;
    }

    public void setPerformance(float performance) {
        this.performance = performance;
    }
}
