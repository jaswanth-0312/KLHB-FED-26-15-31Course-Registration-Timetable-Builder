import java.util.Scanner;

public class Commit4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter course number: ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= 5) {
            System.out.println("Course registration successful!");
        } else {
            System.out.println("Invalid course number!");
        }

   
    }
}