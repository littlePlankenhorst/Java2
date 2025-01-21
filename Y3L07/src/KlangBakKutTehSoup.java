public class KlangBakKutTehSoup implements Soup {

    @Override
    public void AssociateMainDish(MainDish dish) {
        System.out.print("A " + getClass().getSimpleName() + " leveshez a "+dish.toString()+" foetelt tarsitottam.");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
