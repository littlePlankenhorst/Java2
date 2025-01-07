package core;

public class Airplane implements Vehicle {
    private String type;
    private int age;
    private float length;

    public String toString(){
        return "The airplane's type is: "+type+" and its age is: "+age+" and its length is: "+length;
    }

    public void NumberOfWheels(){
        System.out.println("The number of the airplane's wheels is 8");
    }

    public Airplane(String type, int age, float length) {
        this.type = type;
        this.age = age;
        this.length = length;
    }
}
