// public class count {
//     static int count = 0;
//     public static void main(String[] args) throws java.lang.InterruptedException {
//         Thread t = new Thread(() -> {
//             for (int i = 0; i < 1000; i++) {
//                 count++;
//             }
//         });
//         t.start();
//         t.join();
//         System.out.println(count);
//     }
// }

class counter {
    int count;

    counter() {
        count = 0;
    }

    public synchronized void increment() {
        count++;
    }

}

class mythread extends Thread {
    public counter c;
    public int times=0;

    mythread(counter c) {
        this.c = c;
        this.times = 100000;
    }

    public void run() {

        System.out.println("Thread : " + Thread.currentThread().getName() + " is starting");
        for (int i = 0; i < times; i++) {
            c.increment();
        }
        System.out.println("Thread : " +Thread.currentThread().getName() + " has completed");
    }

}

public class count {
    public static void main(String[] args) throws java.lang.InterruptedException {
        counter c = new counter();
        // mythread t1 = new mythread(c);
        mythread[] threads = new mythread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new mythread(c);
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(c.count);
    }
}