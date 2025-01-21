package collection;

import core.Vehicle;

public class VehicleList {
    private int current;
    private Vehicle vehicles[];

    public VehicleList(int size){
        this.vehicles= new Vehicle[size];
        current=0;
    }

    public void addVehicle(Vehicle vehicle){
        try{
            vehicles[current]=vehicle;
            current++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You want to add more vehicles than space is in the list.");
        }

    }

    public class VehicleForwardIterator implements VehicleIterator{
        private int index;

        public VehicleForwardIterator() {index=0;}

        public boolean hasMoreElements(){return index<current;}
        public Vehicle nextElement(){return vehicles[index++];}
    }

    public class VehicleBackwardIterator implements VehicleIterator{
        private int index;

        public VehicleBackwardIterator() {index= current;}

        public boolean hasMoreElements(){return index >= 0;}
        public Vehicle nextElement(){return vehicles[index--];}
    }



    public VehicleIterator getForwardIterator(){return new VehicleForwardIterator();}
    public VehicleIterator getBackwardIterator(){return new VehicleBackwardIterator();}

}
