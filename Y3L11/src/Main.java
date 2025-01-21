import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Java7Strategy j7 = new Java7Strategy();
//        List<Student> studs7 = j7.processFile("D:\\Programozás\\Java\\Y3L11\\src\\data.txt");
//        j7.printStatistics(studs7);
        Java8Strategy j8 = new Java8Strategy();
        List<Student> studs8 = j8.processFile("D:\\\\Programozás\\\\Java\\\\Y3L11\\\\src\\\\data.txt");
//        studs8.stream().forEach(student -> {
//                System.out.print(student.getName()+", "+student.getGender()+", ");
//                Arrays.stream(student.getGrades())
//                        .forEach(grade -> System.out.print(grade+", "));
//                System.out.println();
//        });
        j8.printStatistics(studs8);
    }
}