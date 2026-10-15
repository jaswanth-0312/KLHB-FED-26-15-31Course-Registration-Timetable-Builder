import java.util.Scanner;

public class Commit8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter course credits: ");
            int credits = Integer.parseInt(sc.nextLine());

            System.out.println("Credits: " + credits);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number!");
        }

    }
}