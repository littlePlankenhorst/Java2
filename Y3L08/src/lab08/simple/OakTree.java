package lab08.simple;

import lab08.Plant;

public class OakTree implements Plant {
    @Override
    public double getOxigenAmountPerYear() {
        return 405.7;
    }

    @Override
    public int getLifeTime() {
        return 70;
    }

    @Override
    public String getRepresentation() {
        return getClass().getSimpleName().substring(0,1);
    }
}
