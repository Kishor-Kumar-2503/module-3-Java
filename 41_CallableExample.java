import java.util.concurrent.*;
import java.util.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            tasks.add(() -> "Task " + finalI + " result");
        }
        List<Future<String>> results = executor.invokeAll(tasks);
        for (Future<String> result : results) {
            System.out.println(result.get());
        }
        executor.shutdown();
    }
}