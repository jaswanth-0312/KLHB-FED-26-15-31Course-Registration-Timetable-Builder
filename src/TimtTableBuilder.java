import java.util.ArrayList;
import java.util.Scanner;

// ---------------------------------------------------------
// Course Registration and Timetable Builder
// everything is in this one file
// ---------------------------------------------------------


// this class stores the details of one course
class Course {

    String code;
    String name;
    int credits;
    String day;
    int start;   // starting hour (24 hr format)
    int end;     // ending hour

    public Course(String code, String name, int credits, String day, int start, int end) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.day = day;
        this.start = start;
        this.end = end;
    }

    public void show() {
        System.out.println(code + " | " + name + " | " + credits + " credits | " + day + " " + start + ":00 - " + end + ":00");
    }
}


// this class has all the courses that students can pick
class CourseData {

    ArrayList<Course> list = new ArrayList<Course>();

    public CourseData() {
        // adding all the courses here
        list.add(new Course("CS101", "Intro to Programming", 4, "Mon", 9, 11));
        list.add(new Course("CS102", "Data Structures", 4, "Tue", 10, 12));
        list.add(new Course("MA101", "Calculus", 3, "Mon", 10, 12));
        list.add(new Course("PH101", "Physics", 3, "Wed", 9, 11));
        list.add(new Course("EN101", "English", 2, "Thu", 14, 16));
        list.add(new Course("CS201", "Database Systems", 4, "Wed", 10, 12));
        list.add(new Course("CS202", "Operating Systems", 4, "Fri", 9, 11));
        list.add(new Course("EC101", "Electronics", 3, "Thu", 11, 13));
    }

    // show all courses
    public void showAll() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).show();
        }
    }

    // find a course using its code, returns null if not found
    public Course getCourse(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).code.equalsIgnoreCase(code)) {
                return list.get(i);
            }
        }
        return null;
    }
}


// this class handles the registering and dropping of courses
class Registration {

    ArrayList<Course> myCourses = new ArrayList<Course>();
    int totalCredits = 0;
    int maxCredits = 20;

    public void addCourse(Course c) {

        // check if already registered
        for (int i = 0; i < myCourses.size(); i++) {
            if (myCourses.get(i).code.equals(c.code)) {
                System.out.println("You already registered for this course!");
                return;
            }
        }

        // check credit limit
        if (totalCredits + c.credits > maxCredits) {
            System.out.println("Cannot register, credit limit is " + maxCredits);
            return;
        }

        // check for time clash
        for (int i = 0; i < myCourses.size(); i++) {
            Course other = myCourses.get(i);
            if (other.day.equals(c.day)) {
                if (c.start < other.end && other.start < c.end) {
                    System.out.println("Time clash with " + other.code);
                    return;
                }
            }
        }

        // everything is fine so add it
        myCourses.add(c);
        totalCredits = totalCredits + c.credits;
        System.out.println("Registered for " + c.name);
    }

    public void dropCourse(String code) {
        boolean found = false;
        for (int i = 0; i < myCourses.size(); i++) {
            if (myCourses.get(i).code.equalsIgnoreCase(code)) {
                totalCredits = totalCredits - myCourses.get(i).credits;
                myCourses.remove(i);
                System.out.println("Course dropped");
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("You have not registered for this course");
        }
    }

    public void showMyCourses() {
        if (myCourses.size() == 0) {
            System.out.println("No courses registered yet");
        }
        for (int i = 0; i < myCourses.size(); i++) {
            myCourses.get(i).show();
        }
        System.out.println("Total credits = " + totalCredits);
    }
}


// this class prints the timetable
class Timetable {

    public void show(ArrayList<Course> courses) {

        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};

        // table has 8 rows (9am to 4pm) and 5 columns (mon to fri)
        String[][] table = new String[8][5];

        // first fill everything with -
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                table[i][j] = "-";
            }
        }

        // now put the courses in the table
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);

            // find which column the day is
            int col = 0;
            for (int j = 0; j < 5; j++) {
                if (days[j].equals(c.day)) {
                    col = j;
                }
            }

            for (int hour = c.start; hour < c.end; hour++) {
                table[hour - 9][col] = c.code;
            }
        }

        // print the table
        System.out.println();
        System.out.print("Time     ");
        for (int j = 0; j < 5; j++) {
            System.out.print(days[j] + "      ");
        }
        System.out.println();

        for (int i = 0; i < 8; i++) {
            System.out.print((i + 9) + ":00    ");
            for (int j = 0; j < 5; j++) {
                System.out.print(table[i][j] + "   ");
            }
            System.out.println();
        }
    }
}


// main class, this has the menu
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseData data = new CourseData();
        Registration reg = new Registration();
        Timetable tt = new Timetable();

        int choice = 0;

        while (choice != 6) {
            System.out.println();
            System.out.println("---- COURSE REGISTRATION ----");
            System.out.println("1. Show all courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. Show my courses");
            System.out.println("5. Show my timetable");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                data.showAll();
            }
            else if (choice == 2) {
                System.out.print("Enter course code: ");
                String code = sc.next();
                Course c = data.getCourse(code);
                if (c == null) {
                    System.out.println("Course not found!");
                } else {
                    reg.addCourse(c);
                }
            }
            else if (choice == 3) {
                System.out.print("Enter course code to drop: ");
                String code = sc.next();
                reg.dropCourse(code);
            }
            else if (choice == 4) {
                reg.showMyCourses();
            }
            else if (choice == 5) {
                tt.show(reg.myCourses);
            }
            else if (choice == 6) {
                System.out.println("Bye!");
            }
            else {
                System.out.println("Wrong choice, try again");
            }
        }
    }
}
