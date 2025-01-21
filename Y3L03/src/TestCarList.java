import collection.VehicleIterator;
import collection.VehicleList;
import core.Airplane;
import core.Car;
import core.Vehicle;

public class TestCarList {
    public static void main(String[] args) {
        VehicleList carList = new VehicleList(5);

        Vehicle car1 = new Car("VOLVO", 2003);
        Vehicle car2= new Car("JAGUAR", 2024);
        carList.addVehicle(new Car("BMW",2023));
        carList.addVehicle(new Car("MERCEDES",2005));
        carList.addVehicle(car1);
        carList.addVehicle(car2);
        VehicleIterator forwardIterator = carList.getForwardIterator();
        VehicleIterator backwardIterator = carList.getBackwardIterator();
        Airplane ap1= new Airplane("Boeing", 2023,16);
        carList.addVehicle(ap1);

        System.out.println("Forward Iterator:");
        while (forwardIterator.hasMoreElements()){
            System.out.println(forwardIterator.nextElement());

        }
        System.out.println("Backward Iterator:");
        while (backwardIterator.hasMoreElements()){
            System.out.println(backwardIterator.nextElement());
            }
    }

}
