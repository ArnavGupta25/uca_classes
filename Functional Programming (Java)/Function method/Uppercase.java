import java.util.function.*;

public class Uppercase {
    public static void main(String[] args) {
        Function<String, String> toUpperCase = s -> {
            return s.toUpperCase();
        };
        
        System.out.println(toUpperCase.apply("hello"));
        System.out.println(toUpperCase.apply("java"));
        System.out.println(toUpperCase.apply("functional programming"));
    }
}


