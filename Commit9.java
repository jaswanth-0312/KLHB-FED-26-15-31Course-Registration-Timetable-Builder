import java.io.FileWriter;
import java.io.IOException;

public class Commit9 {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("courses.txt");

            fw.write("Java\n");
            fw.write("Mathematics\n");
            fw.write("Physics\n");

            fw.close();

            System.out.println("Courses saved!");
        } catch (IOException e) {
            System.out.println("Error saving courses.");
        }
    }
}