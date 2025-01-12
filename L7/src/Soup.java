// Ezen kívül hozzunk létre egy leves (Soup) [...] osztalyts
// Írjuk felül az osztályok toString() metódusát, amelyek egyszerűen térítsék vissza az adott osztályok neveit.  
// A leves interfész associateMainDish(...) metódusa segítségével az adott leveshez a paraméterként kapott főétel társítható; 

public interface Soup {
    void associateMainDish(MainDish mainDish);

    @Override
    public String toString();
}

