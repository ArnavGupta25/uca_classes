// // Various locks in threads

// import java.util.concurrent.locks.*;

// public class MT {
//     int val;
//     Lock lock;

//     MT() {
//         val = 0;
//         lock = new ReentrantLock();
//     }

//     public static void main(String[] args) throws InterruptedException {
//         MT lock = new MT();
//         // System.out.println("Initial value: " + lock.val);
//         // lock.increment();
//         // System.out.println("Incremented value: " + lock.val);
//         Thread[] threads = new Thread[10];
//         for (int i = 0; i < threads.length; i++) {
//             threads[i] = new Thread(lock::increment);
//             threads[i].start();
//         }
//         for (int i = 0; i < threads.length; i++) {
//             threads[i].join();
//         }
//         System.out.println("Final value: " + lock.val);
//     }

//     public void increment() {
//         if (lock.tryLock()) {
//             try {
//                 Thread.sleep(10);
//                 val++;
//             } catch (InterruptedException e) {
//                 System.out.println(e);
//             }
//             lock.unlock();
//         } else {
//             System.out.println("Could not acquire lock");
//         }
//     }
// }

// Various locks in threads

import java.util.concurrent.*;

public class MT {
    int val;
    Semaphore lock;

    MT() {
        val = 0;
        lock = new Semaphore(10);
    }

    public static void main(String[] args) throws InterruptedException {
        MT lock = new MT();
        // System.out.println("Initial value: " + lock.val);
        // lock.increment();
        // System.out.println("Incremented value: " + lock.val);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(lock::increment);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("Final value: " + lock.val);
    }

    public void increment() {
        if (lock.tryAcquire()) {
            try {
                Thread.sleep(100);
                val++;
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            lock.release();
        } else {
            System.out.println("Could not acquire lock");
        }
    }
}

