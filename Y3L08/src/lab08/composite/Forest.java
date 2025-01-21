package lab08.composite;

import lab08.Plant;

import java.util.ArrayList;

public class Forest implements Plant {
    private ArrayList<Plant> list = new ArrayList<>();

    public Forest() {
    }
    public void add(Plant plant){
        list.add(plant);
    }
    public void remove (Plant plant){
        list.remove(plant);
    }

    @Override
    public double getOxigenAmountPerYear() {
        Double oxigenAmountPerYear=0.00;
        for (Plant plant : list){
            oxigenAmountPerYear+=plant.getOxigenAmountPerYear();
        }
        return oxigenAmountPerYear;
    }

    @Override
    public int getLifeTime() {
        int max=0;
        for (Plant plant : list){
            if (plant.getLifeTime()>max)
                max = plant.getLifeTime();
        }
        return max;
    }

    @Override
    public String getRepresentation() {
        String plants="{";
        for (Plant plant : list){
            plants+=plant.getRepresentation();
            plants+=", ";
        }
        plants=plants.substring(0,plants.length()-1);
        plants += "}";
        return plants;
    }
}
