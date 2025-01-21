import java.awt.*;
import java.lang.reflect.Array;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
//       // 1. Feladat
//        System.out.println("Hello Bence!");
//
//        // 2. Feladat
//        int sumodd=0;
//        int sumeven=0;
//
//        try {
//            for (String arg : args) {
//                int num = Integer.parseInt(arg);
//                if (num % 2 == 0) {
//                    sumeven += num;
//                } else
//                    sumodd += num;
//            }
//        }
//        catch (Exception e){
//            System.out.println("Az argumentumok kozott nem lehet betu!");
//        }
//        System.out.println("Paratlanok: "+sumodd);
//        System.out.println("Parosok: "+sumeven);

//        // 3. Feladat
//        for (String arg : args){
//            char[] ar = arg.toCharArray();
//            for (Character c : ar)
//            {
//                if(Character.isLowerCase(c)){
//                    System.out.print(Character.toUpperCase(c));
//                }
//                else {
//                    System.out.print(Character.toLowerCase(c));
//                }
//            }
//            System.out.println();
//        }

        // 4. Feladat

        ArrayList<ArrayList> tombs = new ArrayList<>();
        int n=10;
        try {n=Integer.parseInt(args[0]);}
        catch (Exception e){
            System.out.println("Arg is not number");
        }
        int c=1;
        for (int i=0; i<n;i++){

            ArrayList<Integer> numbers = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                numbers.add(c);
                c++;
            }
            tombs.add(numbers);
        }
        for (int i=0;i<tombs.size();i++){
            System.out.println(tombs.get(i).toString().replace("[","").replace("]",""));
        }



    }
}