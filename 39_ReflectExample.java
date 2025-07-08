import java.lang.reflect.*;

public class ReflectExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("SampleClass");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
        }
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Method m = clazz.getMethod("hello");
        m.invoke(obj);
    }
}

class SampleClass {
    public void hello() {
        System.out.println("Hello from SampleClass!");
    }
}