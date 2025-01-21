import java.util.List;

public interface Strategy {
    public List<Student> processFile(String fileName);
    public void printStatistics(List<Student> students);
}
