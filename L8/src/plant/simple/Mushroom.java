package plant.simple;

import plant.Plant;

public class Mushroom implements Plant {
    @Override
    public double getOxigenAmountPerYear() {
        return 2;
    }

    @Override
    public int getLifeTime() {
        return 2;
    }

    @Override
    public String getRepresentation() {
        char[] chars = getClass().getName().toCharArray();
        String answ="";
        for(char ch : chars) {
            if(Character.isUpperCase(ch)){
                answ += ch;
            }
        }
        return answ;
    }
}
