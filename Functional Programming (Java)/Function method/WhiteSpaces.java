import java.util.function.*;

public class WhiteSpaces {
    public static void main(String[] args) {
        Function<String, String> removeExtraSpaces = s ->{
            return s.trim();
        };
        
        System.out.println(removeExtraSpaces.apply("   Hello World   "));
        System.out.println(removeExtraSpaces.apply(" Java Functional Programming "));
        System.out.println(removeExtraSpaces.apply(" Remove extra spaces "));
    }
}
