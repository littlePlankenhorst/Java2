import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Java7Strategy implements Strategy{


    @Override
    public List<Student> processFile(String fileName) {
        BufferedReader in;
        {
            try {
                in = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        List<Student> students = new ArrayList<>();
        while (true) {
            try {
                String lines = in.readLine();
                if(lines == null)
                    break;
                String[] line = lines.split(",");
                String name = line[0];
                String gender = line[1];
                int[] grades = new int[line.length-2];
                for (int i = 2; i < line.length; i++){
                    grades[i-2]= Integer.valueOf(line[i]);
                }
                students.add(new Student(name,gender,grades));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
//        for(Student student : students){
//            System.out.print(student.getName()+", " +
//                    student.getGender() + ", ");
//            for (int grade : student.getGrades()){
//                System.out.print(grade+", ");
//            }
//            System.out.println();
//        }
        return students;
    }

    @Override
    public void printStatistics(List<Student> students) {
        System.out.println("Mean grades per student: ");
        double means=0;
        int allsum=0;
        int numOfGrades=0;
        double male=0;
        double female=0;
        String femaleName="";
        String maleName="";
        List<String[]> topStudents=new ArrayList<>();
        for(Student student : students){
            int sum=0;
            for (int grade : student.getGrades()){
                sum+=grade;
                numOfGrades++;
                if (grade==10){
                    topStudents.add(student.getName().split(" "));
                }
            }
            double avg = (double) sum/student.getGrades().length;
            System.out.println(student.getName()+" : " + avg);
            if(student.getGender().equals("male") && avg > male){
                male=avg;
                maleName=student.getName();
            } else if (student.getGender().equals("female") && avg > female) {
                female=avg;
                femaleName=student.getName();
            }
            means+=avg;
            allsum+=sum;
        }
        System.out.println("Mean of mean grades: " + (means/students.size()));
        System.out.println("Mean of all grades: " + (double)allsum/numOfGrades);
        System.out.println("Male student with highest mean: " + maleName);
        System.out.println("Female student with highest mean: " + femaleName);
        System.out.print("Student's first name that have a grade 10: ");
        for(String[] student : topStudents){
            System.out.print(student[0]+", ");
        }
    }
}
