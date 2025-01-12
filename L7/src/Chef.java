// Hozzunk létre egy szakács (Chef) interfészt, amely két metódust tartalmaz,
// az egyik metódus a leves elkészítését valósítja meg, a másik pedig a főételét.
// Az interfészt két szakács implementálja: egy kínai és egy indiai;
// mindkét szakács a saját ízvilágának megfelelő levest, illetve főételt készít el.

public interface Chef {
    public Soup prepareSoup();
    public MainDish prepareMainDish();
}