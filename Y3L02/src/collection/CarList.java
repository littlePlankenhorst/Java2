package collection;

import core.Car;

public class CarList {
    private int current;
    private Car cars[];

    public CarList(int size){
        this.cars= new Car[size];
        current=0;
    }

    public void addCar(Car car){
        try{
            cars[current]=car;
            current++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You want to add more cars than space is in the list.");
        }

    }

    public class CarIterator{
        private int index;

        public CarIterator() {index=0;}

        public boolean hasMoreElements(){return index<current;}
        public Car nextElement(){return cars[index++];}
    }

    public CarIterator getIterator() {return new CarIterator();}

}
