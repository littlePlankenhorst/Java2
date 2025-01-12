package plant.composite;

import plant.Plant;

import java.util.ArrayList;
public class Forest implements Plant {
    private ArrayList<Plant> plants = new ArrayList<>();

    public void add(Plant plant){
        plants.add(plant);
    }

    public void remove(Plant plant){
        plants.remove(plant);
    }

    public Forest(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    @Override
    public double getOxigenAmountPerYear() {
        double sum=0;
        for (Plant plant :plants){
            sum += plant.getOxigenAmountPerYear();
        }
        return sum;
    }

    @Override
    public int getLifeTime() {
        int maxim=0;
        for (Plant plant : plants){
            if(plant.getLifeTime() > maxim){
                maxim=plant.getLifeTime();
            }
        }
        return maxim;
    }

    @Override
    public String getRepresentation() {
        String result = "{";
        for (Plant plant : plants) {
            result += plant.getRepresentation() + ", ";
        }
        result += "}";
        result = result.replace(", }", "}");
        return result;
    } 
}
