import plant.Plant;
import plant.composite.Field;
import plant.composite.Forest;
import plant.simple.*;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
//        Forest forest = new Forest();
//        forest.add(new Flower());
//        forest.add(new Grass());
//        forest.add(new OakTree());
//        Forest forest2 = new Forest();
//        forest2.add(new Flower());
//        System.out.println(forest.getRepresentation());
//        System.out.println(forest.getLifeTime());
//        System.out.println(forest.getOxigenAmountPerYear());
//        Field field = new Field();
//        field.add(new Flower());
//        field.add(new Grass());
//        System.out.println(field.getRepresentation());

        HashSet<Plant> p1 = new HashSet<>();
        p1.add(new Grass());
        p1.add(new Flower());

        Field f1 = new Field(p1);
        //System.out.println(f1.getRepresentation());

        HashSet<Plant> p2 = new HashSet<>();
        p2.add(new Mushroom());
        p2.add(new Mushroom());

        Field f2 = new Field(p2);
        //System.out.println(f2.getRepresentation());

        ArrayList<Plant> fp = new ArrayList<>();
        fp.add(f1);
        fp.add(f2);
        fp.add(new PineTree());
        fp.add(new OakTree());

        Forest f = new Forest(fp);
        System.out.println(f.getRepresentation());
        System.out.println("Max lifetime : " + f.getLifeTime());
        System.out.println("Oxigen amount per year " + f.getOxigenAmountPerYear());
    }
}