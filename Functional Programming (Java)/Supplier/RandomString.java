import java.util.function.*;
import java.util.Random;
public class RandomString {
    public static void main(String[] args) {
        int length = 8;
        
        Supplier<String> randomStringSupplier = () -> {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder randomString = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                randomString.append(characters.charAt(index));
            }

            return randomString.toString();
        };

        System.out.println("Random String: " + randomStringSupplier.get());
    }
}
