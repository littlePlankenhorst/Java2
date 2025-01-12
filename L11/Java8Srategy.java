import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Srategy implements Strategy {
    @Override
    public List<Student> processFile(String fileName) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))   {

            students = br.lines()
                    .map(line -> {
                        // Split the line into parts and map to a Student
                        String[] parts = line.split(",");
                        String name = parts[0].trim();
                        String gender = parts[1].trim();
                        int[] grades = Stream.of(parts)
                                .skip(2) // Skip name and gender
                                .mapToInt(grade -> Integer.parseInt(grade.trim()))
                                .toArray(); // Collect grades as an array
                        return new Student(name, gender, grades);
                    })
                    .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                    .collect(Collectors.toList()); // Collect all students into a List
            }
        catch (IOException e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void printStatistics(List<Student> students) {
        int[] m={0};
        double[] highMaleAvg={Double.MIN_VALUE};
        double[] highFemaleAvg={Double.MIN_VALUE};
        Student male=new Student(".","male", m);
        Student female=new Student(".","female",m);
        ArrayList<String> fnames = new ArrayList<>();
        ArrayList<Double> means = new ArrayList<>();

        System.out.println("Mean grades per student:");

        students.forEach(student -> {
            int[] grades = student.getGrades();
            OptionalDouble avg = IntStream.of(grades).average();

            if (student.getGender().equals("male")){
                if (avg.getAsDouble()>highMaleAvg[0]) {
                    male.setName(student.getName());
                    highMaleAvg[0] = avg.getAsDouble();
                }
            }
            else {
                if (avg.getAsDouble()>highFemaleAvg[0]) {
                    female.setName(student.getName());
                    highFemaleAvg[0] = avg.getAsDouble();
                }
            }

            if (Arrays.stream(grades).anyMatch(grade -> grade == 10)){
                fnames.add(student.getName().split(" ")[0]);
            }

            System.out.println(student.getName() + ": " + String.format("%.2f", avg.getAsDouble()));
            means.add(avg.getAsDouble());
        });

        OptionalDouble avgOfMeans = means
                .stream()
                        .mapToDouble(value -> value)
                                .average();

        int totalSum = students.stream()
                .flatMapToInt(student -> IntStream.of(student.getGrades())) 
                .sum();

        long totalCount = students.stream()
                .mapToLong(student -> student.getGrades().length) 
                .sum();

        double globalAverage = (double) totalSum / totalCount;

        System.out.println("Mean of mean grades: " + avgOfMeans.getAsDouble());
        System.out.println("Mean of all grades: " + globalAverage);
        System.out.println("Male student with highest mean: " + male.getName());
        System.out.println("Female student with highest mean: " + female.getName());
        System.out.println("Student's first name that have a grade 10: " + fnames.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", ")));
        }
    }
