import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Strategy implements Strategy {
    @Override
    public List<Student> processFile(String fileName) {
        List<Student> students= new ArrayList<>();
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(fileName));

            students = in.lines()
                    .map(line -> {
                        String[] parts = line.split(",");
                        String name = parts[0];
                        String gender = parts[1];
                        int[] grades = Stream.of(parts)
                                .skip(2)
                                .mapToInt(grade -> Integer.parseInt(grade.trim()))
                                .toArray();
                        return new Student(name,gender,grades);
                    }).sorted(new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    }).collect(Collectors.toList());

        } catch(FileNotFoundException e) {
            System.out.println("Hiba a fajl betoltesekor.");
        }


        return students;
    }

    @Override
    public void printStatistics(List<Student> students) {
        List<Double> means=new ArrayList<>();
        List<Integer> grades = new ArrayList<>();
        Double[] recHighestMale={0.0};
        Double[] recHighestFemale={0.0};
        String[] maleName={""};
        String[] femaleName={""};
        List<String> firstNames=new ArrayList<>();

        System.out.println("Mean grades per student");
        students.forEach(student -> {
            System.out.print(student.getName()+" : ");
            OptionalDouble meanStudent = IntStream.of(student.getGrades()).average();
            means.add(meanStudent.getAsDouble());
            System.out.println(meanStudent.getAsDouble());

            IntStream.of(student.getGrades())
                    .forEach(grade -> grades.add(grade));

            if(student.getGender().equals("male")
                    &&  meanStudent.getAsDouble() > recHighestMale[0]){
                recHighestMale[0] = meanStudent.getAsDouble();
                maleName[0] = student.getName();
            }
            else if(student.getGender().equals("male")
                    &&  meanStudent.getAsDouble() > recHighestFemale[0]){
                recHighestFemale[0] = meanStudent.getAsDouble();
                femaleName[0] = student.getName();
            }

            if(IntStream.of(student.getGrades()).max().getAsInt() == 10){
                firstNames.add(student.getName().split(" ")[0]);
            }
        });

        // fontos!!
        // listaval igy tud dolgozni a stream
        OptionalDouble meansmean = means
                .stream()
                .mapToDouble(value -> value)
                .average();
        OptionalDouble meanAll = grades
                .stream()
                .mapToInt(value -> value)
                .average();

        System.out.println("Mean of mean grades: " +meansmean.getAsDouble());
        System.out.println("Mean of all grades: " + meanAll.getAsDouble());
        System.out.println("Male student with highest mean: " + maleName[0]);
        System.out.println("Female student with highest mean: " + femaleName[0]);
        System.out.print("Student's first name that have a grade 10: ");
        firstNames.forEach(name -> System.out.print(name + ", "));

    }
}
