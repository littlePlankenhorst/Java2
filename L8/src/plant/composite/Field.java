package plant.composite;
import plant.Plant;

import java.util.HashSet;
public class Field implements Plant {
    HashSet<Plant> plants = new HashSet<Plant>();
    public void add(Plant plant){
        plants.add(plant);
    }

    public void remove(Plant plant){
        plants.remove(plant);
    }
    public double getOxigenAmountPerYear() {
        double sum=0;
        for (Plant plant :plants){
            sum += plant.getOxigenAmountPerYear();
        }
        return sum;
    }
    public int getLifeTime() {
        int maxim=0;
        for (Plant plant : plants){
            if(plant.getLifeTime() > maxim){
                maxim=plant.getLifeTime();
            }
        }
        return maxim;
    }
    public String getRepresentation() {
        String result = "[";
        for (Plant plant : plants) {
            result += plant.getRepresentation() + ", ";
        }
        result += "]";
        result = result.replace(", ]", "]");
        return result;
    }

    public Field(HashSet<Plant> plants) {
        this.plants = plants;
    }
}
