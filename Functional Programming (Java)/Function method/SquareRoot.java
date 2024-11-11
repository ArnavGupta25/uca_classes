import java.util.function.*;

public class SquareRoot {
    public static void main(String[] args) {
        Function<Integer, Double> root = (x) -> {
            return Math.sqrt(x);
        };
        
        System.out.println(root.apply(25));
        System.out.println(root.apply(49));
        System.out.println(root.apply(121));
        System.out.println(root.apply(81));
    }
}
