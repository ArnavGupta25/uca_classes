import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class uppercase {
    public static void main(String[] args) {
        String[] input = {"hello", "world", "java", "streams"};

        List<String> ans = Arrays.stream(input)
            .map(String::toUpperCase)
            .collect(Collectors.toList()); 
        System.out.println(ans);
    }
}
