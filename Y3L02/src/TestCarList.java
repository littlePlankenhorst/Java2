import collection.CarList;
import core.Car;

public class TestCarList {
    public static void main(String[] args) {
        CarList carList = new CarList(4);

        Car car1 = new Car("VOLVO", 2003, 109.5F);
        Car car2= new Car("JAGUAR", 2024, 402.1F);
        carList.addCar(new Car("BMW",2023,223));
        carList.addCar(new Car("MERCEDES",2005,114));
        carList.addCar(car1);
        carList.addCar(car2);
        CarList.CarIterator iterator = carList.getIterator();
        while (iterator.hasMoreElements()){
            System.out.println(iterator.nextElement());
        }

    }

}
