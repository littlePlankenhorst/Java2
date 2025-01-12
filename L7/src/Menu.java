// Végül hozzunk létre egy menü osztályt, amely adattagként egy levest és egy főételt tartalmaz
// (ezen a szinten csak az interfészekre hivatkozzunk). 
// A createMenu(...) metódusban állítsuk be az adattagokat a paraméterként kapott szakács által elkészített levesre,
// illetve főételre, majd társítsuk a kapott levest és a főétellel. 
// A main(...) függvényben hozzunk létre egy-egy menüt, mindkét szakács segítségével.

public class Menu {
    private Soup soup;
    private MainDish mainDish;

    public void createMenu(Chef chef) {
        this.soup = chef.prepareSoup();
        this.mainDish = chef.prepareMainDish();
        soup.associateMainDish(mainDish);
    }

    public static void main(String[] args) {
        Menu chineseMenu = new Menu();
        chineseMenu.createMenu(new ChineseChef());

        Menu indianMenu = new Menu();
        indianMenu.createMenu(new IndianChef());
    }
}