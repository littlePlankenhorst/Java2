import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java7Strategy implements Strategy {
    @Override
    public List<Student> processFile(String fileName) throws FileNotFoundException {
        List<Student> students = new ArrayList<Student>();
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0].trim();
                String gender = parts[1].trim();
                
                int[] grades = new int[parts.length - 2];
                for (int i = 2; i < parts.length; i++) {
                    grades[i - 2] = Integer.parseInt(parts[i].trim());
                }
                
                students.add(new Student(name, gender, grades));
            }
            
            Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return s1.getName().compareTo(s2.getName());
                }
            });
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return students;
    }

    @Override
    public void printStatistics(List<Student> students) {
        double highestMaleAvg = Double.MIN_VALUE;
        double highestFemaleAvg = Double.MIN_VALUE;
        String topMaleStudent = "";
        String topFemaleStudent = "";
        ArrayList<String> firstNamesWithTen = new ArrayList<String>();
        ArrayList<Double> meanGrades = new ArrayList<Double>();
        
        System.out.println("Mean grades per student:");
        
        int totalGrades = 0;
        int gradeCount = 0;
        
        for (Student student : students) {
            int[] grades = student.getGrades();
            double sum = 0;
            
            for (int grade : grades) {
                sum += grade;
                totalGrades += grade;
                gradeCount++;
                
                if (grade == 10) {
                    String firstName = student.getName().split(" ")[0];
                    if (!firstNamesWithTen.contains(firstName)) {
                        firstNamesWithTen.add(firstName);
                    }
                }
            }
            
            double average = sum / grades.length;
            meanGrades.add(average);
            
            if (student.getGender().equals("male")) {
                if (average > highestMaleAvg) {
                    highestMaleAvg = average;
                    topMaleStudent = student.getName();
                }
            } else {
                if (average > highestFemaleAvg) {
                    highestFemaleAvg = average;
                    topFemaleStudent = student.getName();
                }
            }
            
            System.out.println(student.getName() + ": " + String.format("%.2f", average));
        }
        
        double sumOfMeans = 0;
        for (Double mean : meanGrades) {
            sumOfMeans += mean;
        }
        double meanOfMeans = sumOfMeans / meanGrades.size();
        
        double globalAverage = (double) totalGrades / gradeCount;
        
        System.out.println("Mean of mean grades: " + meanOfMeans);
        System.out.println("Mean of all grades: " + globalAverage);
        System.out.println("Male student with highest mean: " + topMaleStudent);
        System.out.println("Female student with highest mean: " + topFemaleStudent);
        
        StringBuilder namesWithTen = new StringBuilder();
        for (int i = 0; i < firstNamesWithTen.size(); i++) {
            namesWithTen.append(firstNamesWithTen.get(i));
            if (i < firstNamesWithTen.size() - 1) {
                namesWithTen.append(", ");
            }
        }
        System.out.println("Student's first name that have a grade 10: " + namesWithTen.toString());
    }
} 