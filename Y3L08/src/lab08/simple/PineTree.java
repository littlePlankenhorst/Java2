package lab08.simple;

import lab08.Plant;

public class PineTree implements Plant {
    @Override
    public double getOxigenAmountPerYear() {
        return 695.5;
    }

    @Override
    public int getLifeTime() {
        return 36;
    }

    @Override
    public String getRepresentation() {
        return getClass().getSimpleName().substring(0,1);
    }
}
