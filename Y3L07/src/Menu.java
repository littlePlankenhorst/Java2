
public class Menu {
    private Soup soup;
    private MainDish mainDish;

    public void createMenu(Chef chef){
        chef.prepareSoup();
        chef.prepareMainDish();
    }

    public static void main(String[] args) {

        Menu menu = new Menu();
        ChineseChef chineseChef = new ChineseChef();
        menu.createMenu(chineseChef);
        System.out.println();
        IndianChef indianChef = new IndianChef();
        menu.createMenu(indianChef);

    }
}