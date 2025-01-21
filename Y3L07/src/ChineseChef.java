public class ChineseChef implements Chef {

    @Override
    public MainDish prepareMainDish() {
        KungPaoChicken dish = new KungPaoChicken();
        return dish;
    }
    @Override
    public Soup prepareSoup() {
        KlangBakKutTehSoup soup = new KlangBakKutTehSoup();
        soup.AssociateMainDish(prepareMainDish());
        return soup;
    }
}
