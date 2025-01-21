package core;

public class Airplane implements Vehicle{

    private String type;
    private int age;
    private float length;

    public Airplane(String type, int age, float length) {
        this.type = type;
        this.age = age;
        this.length = length;
    }

    public String toString(){
        return "A gep egy " + type + " modell, " + age + " evbol valo, " + length + "m hosszu gep";
    }
    public void numberOfWheels(){
        System.out.println("A kerekek szama 3");
    }
}
