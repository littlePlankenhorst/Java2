package core;

public class Car implements Vehicle{
    private String type;
    private int age;

    public String toString(){
        return "The car's type is: " +type+" and its age is: "+age;
    }

    public Car(String type, int age) {
        this.type = type;
        this.age = age;
    }

    @Override
    public void NumberOfWheels() {
        System.out.println("The number of the car's wheels is: 4");
    }
}
