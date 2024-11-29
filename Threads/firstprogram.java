// @SuppressWarnings("all") // This can help suppress some warnings

// class Myrunnable implements Runnable {
//     public void run() {
//         System.out.println("Hello from a thread!");
//     }
// }

// public class firstprogram {
//     public static void main(String[] args) {
//         Myrunnable myrunnable = new Myrunnable();
//         Thread t = new Thread(myrunnable);
//         t.start();
//     }
// }

// using lambda function instead of runnable

public class firstprogram {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Hello from a thread!"));
        t.start();
    }
}

// using lambda function instead of runnable with multiple statements

// public class firstprogram {
//     public static void main(String[] args) {
//         Thread t = new Thread(() -> {
//             System.out.println("Hello from a thread!");
//             System.out.println("Hello from a thread!");
//         });
//         t.start();
//     }
// }

// using lambda function instead of runnable with multiple statements and loop

// public class firstprog {
//     public static void main(String[] args) {
//         Thread t = new Thread(() -> {
//             for (int i = 0; i < 5; i++) {
//                 System.out.println("Hello from a thread!");
//             }
//         });
//         t.start();
//     }
// }

// using lambda function instead of runnable with multiple statements and loop and sleep

// public class firstprog {
//     public static void main(String[] args) {
//         Thread t = new Thread(() -> {
//             for (int i = 0; i < 5; i++) {
//                 System.out.println("Hello from a thread!");
//                 try {
//                     Thread.sleep(1000);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             }
//         });
//         t.start();
//     }
// }

