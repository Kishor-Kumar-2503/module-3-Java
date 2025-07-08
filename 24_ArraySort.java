import java.util.ArrayList;
import java.util.Scanner;

public class ArraySort {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter names (type 'exit' to stop):");
        while(true) {
            String name = sc.nextLine();
            if(name.equalsIgnoreCase("exit")) break;
            names.add(name);
        }

        System.out.println("Names entered:");
        for(String name : names) {
            System.out.println(name);
        }
        sc.close();
    }
}
