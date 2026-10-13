import java.util.ArrayList;

public class Commit10 {
    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();

        courses.add("Java");
        courses.add("Mathematics");
        courses.add("Physics");

        System.out.println("Registered Courses:");

        for (String course : courses) {
            System.out.println(course);
        }

        System.out.println("Total Courses: " + courses.size());
    }
}