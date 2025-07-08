import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Orange");
        list.add("Apple");
        list.add("Banana");

        Collections.sort(list, (a, b) -> a.compareToIgnoreCase(b));

        System.out.println("Sorted list:");
        for(String s : list) {
            System.out.println(s);
        }
    }
}
