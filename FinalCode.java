import java.util.Scanner;

public class FinalCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String studentName;
        int rollNumber;
        int choice;
        int count = 0;

        String[] courses = {
            "Java",
            "Mathematics",
            "Physics",
            "English",
            "Electronics"
        };

        String[] times = {
            "9:00 AM",
            "10:00 AM",
            "11:00 AM",
            "1:00 PM",
            "2:00 PM"
        };

        System.out.println("=== Course Registration System ===");

        System.out.print("Enter student name: ");
        studentName = sc.nextLine();

        System.out.print("Enter roll number: ");
        rollNumber = sc.nextInt();

        do {
            System.out.println("\nAvailable Courses:");
            for (int i = 0; i < courses.length; i++) {
                System.out.println((i + 1) + ". " + courses[i]);
            }

            System.out.println("0. Finish Registration");
            System.out.print("Choose a course number: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= courses.length) {
                System.out.println("Registered successfully: "
                        + courses[choice - 1]);
                count++;
            } else if (choice == 0) {
                System.out.println("Registration completed.");
            } else {
                System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        System.out.println("\n=== Student Details ===");
        System.out.println("Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Total Registrations: " + count);

        System.out.println("\n=== Timetable ===");
        for (int i = 0; i < courses.length; i++) {
            System.out.println(courses[i] + " - " + times[i]);
        }

        sc.close();
    }
}