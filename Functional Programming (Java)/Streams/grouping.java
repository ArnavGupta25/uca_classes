import java.util.*;
import java.util.stream.*;

public class grouping {
    // group list of string by their first character using groupingBy
    public static void main(String[] args) {
        String[] input = {"hello", "world", "java", "streams", "apple", "banana", "cat", "dog"};

        Map<Character, List<String>> ans = Arrays.stream(input)
            .collect(Collectors.groupingBy(s -> s.charAt(0))); 
        System.out.println(ans);

        //group by length
        Map<Integer, List<String>> ans2 = Arrays.stream(input)
            .collect(Collectors.groupingBy(String::length));
        System.out.println(ans2);
    }

}
