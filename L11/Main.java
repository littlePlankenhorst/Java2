import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "data.txt";
        Strategy Java8 = new Java8Srategy();
        Strategy Java7 = new Java7Strategy();
        List<Student> studentsS7 = null;
        List<Student> studentsS8 = null;
        try {
            studentsS8 = Java8.processFile(filePath);
            studentsS7 = Java7.processFile(filePath);
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("A valasz Java7-es strategiakkal:");
        Java7.printStatistics(studentsS7);
        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("A valasz Java8-as strategiakkal:");
        Java8.printStatistics(studentsS8);

    }
}
