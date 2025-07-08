import java.util.Scanner;

public class TestAge {
    static void checkAge(int age) throws AgeException {
        if (age < 18) {
            throw new AgeException("Age must be at least 18.");
        } else {
            System.out.println("Age is valid.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            checkAge(age);
        } catch (AgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        sc.close();
    }
}
