// Ezen kívül hozzunk létre egy leves (Soup) és egy főétel (MainDish) interfészt,
// illetve a kínai és az indiai főételeket és leveseket, amelyek a megfelelő interfészeket implementálják. 
// Írjuk felül az osztályok toString() metódusát, amelyek egyszerűen térítsék vissza az adott osztályok neveit. 
// Egy osztály neve a getClass().getSimpleName() metódushívással kérhető le.  
// A leves interfész associateMainDish(...) metódusa segítségével az adott leveshez a paraméterként kapott főétel társítható; 
// implementáláskor ebben a függvényben egyszerűen írjuk ki, hogy "A ... leveshez a ... főételt társítottam.".
// Kiíratáskor nem szükséges a toString() függvény explicit meghívása

public class KungPaoChicken implements MainDish {

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}