import java.util.function.Predicate;

public class CheckPrime {

    public static Predicate<Integer> isPrime = num -> {
        if (num <= 1) return false; 
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false; 
            }
        }
        return true;
    };

    public static void main(String[] args) {

        System.out.println(isPrime.test(17));
        System.out.println(isPrime.test(4));
        System.out.println(isPrime.test(29));
    }
}
