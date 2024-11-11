//Random UUID and prints 10 times at intervals of 2 seconds using supplier and consumer

import java.util.function.*;

public class Supplier_Consumer {
    public static void main(String[] args) {

        Function<Supplier<String>, Consumer<String>> generateAndPrintUUID = (supplier) -> {
            String randomidfromsupplier = supplier.get();
            Consumer<String> consumer = (randomidfromconsumer) -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(2000);
                        System.out.println(i + " " + randomidfromconsumer + " " + randomidfromsupplier);
                    } catch (Exception e) {
                        //
                    }
                }
            };
            return consumer;
        };

        generateAndPrintUUID.apply(() -> {
            return String.valueOf("randomid-- " + Math.random() * 1000 + "--");
        }).accept("Log System");

    }
}
