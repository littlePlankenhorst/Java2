package lab08.simple;

import lab08.Plant;

public class Flower implements Plant {
    @Override
    public double getOxigenAmountPerYear() {
        return 15.5;
    }

    @Override
    public int getLifeTime() {
        return 2;
    }

    @Override
    public String getRepresentation() {
        return getClass().getSimpleName().substring(0,1);
    }
}
