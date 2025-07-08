public class SwitchCalculator {
    public static void identifyType(Object obj) {
        String result = switch (obj) {
            case Integer i -> "Integer: " + i;
            case String s -> "String: " + s;
            case Double d -> "Double: " + d;
            default -> "Unknown type";
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        identifyType(100);
        identifyType("Hello");
        identifyType(3.14);
        identifyType(true);
    }
}
