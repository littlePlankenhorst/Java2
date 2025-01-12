package plant.simple;

import plant.Plant;

public class OakTree implements Plant {
    @Override
    public double getOxigenAmountPerYear() {
        return 11;
    }

    @Override
    public int getLifeTime() {
        return 22;
    }

    @Override
    public String getRepresentation() {
        char[] chars = getClass().getName().toCharArray();
        String answ="";
        for(char ch : chars) {
            if(Character.isUpperCase(ch)){
                answ += ch;
                return answ;
            }
        }
        return answ;
    }
}
