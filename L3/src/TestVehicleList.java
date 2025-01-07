import core.*;
import collection.*;

public class TestVehicleList {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", 5);
        Car car2 = new Car("Audi", 2);

        Airplane airplane= new Airplane("Boeing", 10,9);
        Airplane airplane1= new Airplane("Boeing 2.0", 9, 10);

        VehicleList lista= new VehicleList(2);

        lista.addVehicle(car1);
        lista.addVehicle(car2);
//        lista.addVehicle(airplane1);

        VehicleList.VehicleForwardIterator elore=lista.getForwardIterator();
        System.out.println("Forward iteration:\n");
        while (elore.hasMoreElements()){
            Vehicle vehicle = elore.nextElement();
            System.out.println(vehicle);
            vehicle.NumberOfWheels();
        }
        System.out.println("Backward iteration:\n");
        VehicleList.VehicleBackwardIterator hatra=lista.getBackwardIterator();
        while (hatra.hasMoreElements()){
            Vehicle vehicle = hatra.nextElement();
            System.out.println(vehicle);
            vehicle.NumberOfWheels();
        }


    }
}