public class Commit6 {
    public static void main(String[] args) {
        String[] courses = {
            "Java", "Mathematics", "Physics"
        };

        String[] times = {
            "9 AM", "10 AM", "11 AM"
        };

        for (int i = 0; i < courses.length; i++) {
            System.out.println(
                courses[i] + " - " + times[i]
            );
        }
    }
}