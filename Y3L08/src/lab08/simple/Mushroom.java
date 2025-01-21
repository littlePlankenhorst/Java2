package lab08.simple;

import lab08.Plant;

public class Mushroom implements Plant {
    @Override
    public double getOxigenAmountPerYear() {
        return 6.3;
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
