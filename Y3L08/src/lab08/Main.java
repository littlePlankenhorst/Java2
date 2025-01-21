package lab08;

import lab08.composite.Field;
import lab08.composite.Forest;
import lab08.simple.*;

public class Main {
    public static void main(String[] args) {

        // {[G, F], [M, M], P, O}

        Forest forest = new Forest();
        Field field1 = new Field();
        Field field2 = new Field();

        field1.add(new Grass());
        field1.add(new Flower());

        field2.add(new Mushroom());
        field2.add(new Mushroom());

        forest.add(field1);
        forest.add(field2);
        forest.add(new PineTree());
        forest.add(new OakTree());

        System.out.println("Az erdo oxigentermelese:");
        System.out.println(forest.getOxigenAmountPerYear());
        System.out.println("Az erdo maximum elettartama:");
        System.out.println(forest.getLifeTime());
        System.out.println("Az erdo nevlistaja:");
        System.out.println(forest.getRepresentation());
    }
}