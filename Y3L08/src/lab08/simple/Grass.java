package lab08.simple;

import lab08.Plant;

public class Grass implements Plant {
    @Override
    public double getOxigenAmountPerYear() {
        return 0.9;
    }

    @Override
    public int getLifeTime() {
        return 1;
    }

    @Override
    public String getRepresentation() {
        return getClass().getSimpleName().substring(0,1);
    }
}
