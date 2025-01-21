package lab08.composite;

import lab08.Plant;

import java.util.HashSet;

public class Field implements Plant {
    private HashSet<Plant> set = new HashSet<>();

    public Field() {
    }
    public void add(Plant plant){
        set.add(plant);
    }
    public void remove (Plant plant){
        set.remove(plant);
    }

    @Override
    public double getOxigenAmountPerYear() {
        Double oxigenAmountPerYear=0.00;
        for (Plant plant : set){
            oxigenAmountPerYear+=plant.getOxigenAmountPerYear();
        }
        return oxigenAmountPerYear;
    }

    @Override
    public int getLifeTime() {
        int max=0;
        for (Plant plant : set){
            if (plant.getLifeTime()>max)
                max = plant.getLifeTime();
        }
        return max;
    }

    @Override
    public String getRepresentation() {
        String plants="[";
        for (Plant plant : set){
            plants+=plant.getRepresentation();
            plants+=", ";
        }
        plants=plants.substring(0,plants.length()-1);
        plants += "]";
        return plants;
    }
}
