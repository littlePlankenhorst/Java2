public class IndianChef implements Chef {
    @Override
    public MainDish prepareMainDish() {
        ChickPeaCurry dish = new ChickPeaCurry();
        return dish;
    }

    @Override
    public Soup prepareSoup() {
        AlmondSoup soup = new AlmondSoup();
        soup.AssociateMainDish(prepareMainDish());
        return soup;
    }
}
