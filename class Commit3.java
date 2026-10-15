import java.util.Scanner;

public class Commit3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Select course number (1-3): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Selected: Java");
                break;
            case 2:
                System.out.println("Selected: Mathematics");
                break;
            case 3:
                System.out.println("Selected: Physics");
                break;
            default:
                System.out.println("Invalid choice");
        }

      
    }
}