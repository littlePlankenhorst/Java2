// Ezen kívül hozzunk létre egy leves (Soup) és egy főétel (MainDish) interfészt,
// illetve a kínai és az indiai főételeket és leveseket, amelyek a megfelelő interfészeket implementálják. 
// Írjuk felül az osztályok toString() metódusát, amelyek egyszerűen térítsék vissza az adott osztályok neveit. 
// Egy osztály neve a getClass().getSimpleName() metódushívással kérhető le.  
// A leves interfész associateMainDish(...) metódusa segítségével az adott leveshez a paraméterként kapott főétel társítható; 
// implementáláskor ebben a függvényben egyszerűen írjuk ki, hogy "A ... leveshez a ... főételt társítottam.".
// Kiíratáskor nem szükséges a toString() függvény explicit meghívása

public class AlmondSoup implements Soup {
    @Override
    public void associateMainDish(MainDish mainDish) {
        System.out.println("A " + getClass().getSimpleName() + " leveshez a " + mainDish.getClass().getSimpleName() + " főételt társítottam.");
    }
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}