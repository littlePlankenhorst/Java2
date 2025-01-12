import java.io.FileNotFoundException;
import java.util.List;
public interface Strategy {
    public List<Student> processFile(String fileName) throws FileNotFoundException;
    public void printStatistics(List<Student> students);
}
