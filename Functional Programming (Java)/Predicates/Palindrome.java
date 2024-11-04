import java.util.function.*;

public class Palindrome{
    public static Predicate<String> isPalindrome = str -> {
        if (str == null) return false; 
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); 
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    };

    public static void main(String[] args) {
        System.out.println(isPalindrome.test("madam"));
        System.out.println(isPalindrome.test("malayalam"));
        System.out.println(isPalindrome.test("Hello World"));
    }
}