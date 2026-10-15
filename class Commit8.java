class Course {
    String name;
    int credits;

    void display() {
        System.out.println("Course: " + name);
        System.out.println("Credits: " + credits);
    }
}

public class Commit7 {
    public static void main(String[] args) {
        Course c = new Course();

        c.name = "Java";
        c.credits = 4;

        c.display();
    }
}