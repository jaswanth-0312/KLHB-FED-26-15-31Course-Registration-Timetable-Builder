import java.util.Scanner;

class CourseRegistration {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String studentName;
        int rollNo;
        int courses;
        double feePerCourse = 1500.0;
        boolean registered;


        System.out.print("Enter student name: ");
        studentName = sc.nextLine();

        System.out.print("Enter roll number: ");
        rollNo = sc.nextInt();

        System.out.print("Enter number of courses: ");
        courses = sc.nextInt();


        double totalFee = courses * feePerCourse;

        if (courses > 0) {
            registered = true;
        } else {
            registered = false;
        }


        System.out.println("\n--- Course Registration ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Number of Courses: " + courses);
        System.out.println("Total Fee: " + totalFee);
        System.out.println("Registered: " + registered);

        // Simple timetable
        System.out.println("Timetable ");

        if (courses >= 1)
            System.out.println("Monday    : Java");

        if (courses >= 2)
            System.out.println("Tuesday   : Mathematics");

        if (courses >= 3)
            System.out.println("Wednesday : Physics");

        if (courses >= 4)
            System.out.println("Thursday  : Computer Networks");

        if (courses >= 5)
            System.out.println("Friday    : DDCA");

      
    }
}