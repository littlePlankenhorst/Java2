public class AlmondSoup implements Soup {
    @Override
    public void AssociateMainDish(MainDish dish) {
        System.out.println("A(z) " + getClass().getSimpleName() + " leveshez a" + dish.toString() + "fotelt tarsitottam");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
