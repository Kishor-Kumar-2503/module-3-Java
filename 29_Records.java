import java.util.List;

public record Person(String name, int age) {}

class RecordTest {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Alice", 30),
            new Person("Bob", 15),
            new Person("Charlie", 25)
        );

        System.out.println("All People:");
        people.forEach(System.out::println);

        System.out.println("\nPeople aged 18 and above:");
        people.stream()
              .filter(p -> p.age() >= 18)
              .forEach(System.out::println);
    }
}
