// Bank- 1 Person- AccountNo, Balance (never go negative)
//10 Depositer- Random money(use math.random())- Account No. 10- Thread ()
//10 Withdrawer- Random Money (0-100 ) withdraw, bank account account ( Killing , Wait for somtime- 2 seconds

public class Task1 {
    class Bank {
        int balance = 1000;

        public synchronized void deposit(int amount) {
            balance += amount;
            System.out.println("Deposited: " + amount + " Balance: " + balance);
        }

        public synchronized void withdraw(int amount) {
            if (balance - amount < 0) {
                System.out.println("Insufficient Balance");
            } else {
                balance -= amount;
                System.out.println("Withdrawn: " + amount + " New Balance: " + balance);
            }
        }
    }

    static class Depositer extends Thread {
        Bank bank;

        public Depositer(Bank bank) {
            this.bank = bank;
        }

        public void run() {
            int amount = (int) (Math.random() * 1000);
            bank.deposit(amount);
        }
    }

    static class Withdrawer extends Thread {
        Bank bank;

        public Withdrawer(Bank bank) {
            this.bank = bank;
        }

        public void run() {
            int amount = (int) (Math.random() * 1000);
            bank.withdraw(amount);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Task1 task = new Task1();
        Bank bank = task.new Bank();
        for (int i = 0; i < 10; i++) {
            Depositer d = new Depositer(bank);
            d.start();
        }
        for (int i = 0; i < 10; i++) {
            Withdrawer w = new Withdrawer(bank);
            w.start();
        }
    }
}