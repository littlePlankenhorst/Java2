public class Student {
    private String name;
    private String gender;
    private int[] grades;

    public Student(String name, String gender, int[] grades) {
        this.name = name;
        this.gender = gender;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public int[] getGrades() {
        return grades;
    }
}
