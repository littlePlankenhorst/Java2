package collection;
import core.Car;

public class CarList {
    private static Car[] cars;

    private static int current;

    public CarList (int size) {
        cars = new Car[size];
        current=0;
    }
    public void addCar(Car car){
        try{
            cars[current] = car;
            current ++;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("The list is full!");
        }
    }
    public CarIterator getIterator(){
        return new CarIterator();
    }



    public static class CarIterator{
        private int index;

        public CarIterator() {
            index=0;
        }

        public boolean hasMoreElements(){
            return index < current;
        }

        public Car nextElement(){
            return cars[index++];
        }


    }

}