package threads;

public class PrintEvenOddNumbers {
    public static void main(String[] args) {
        Printer printer = new Printer();
        int max = 1000;
        Thread t1 = new Thread(new PrintOddTask(printer, max), "Odd");
        Thread t2 = new Thread(new PrintEvenTask(printer, max), "Even");
        t1.start();
        t2.start();
    }

}

class PrintEvenTask implements Runnable {
    private Printer printer;
    private int max;

    PrintEvenTask(Printer printer, int max) {
        this.printer = printer;
        this.max = max;

    }

    @Override
    public void run() {
        for (int i = 2; i < max; i += 2) {
            printer.printEven(i);
        }

    }
}

class PrintOddTask implements Runnable {
    private Printer printer;
    private int max;

    PrintOddTask(Printer printer, int max) {
        this.printer = printer;
        this.max = max;

    }

    @Override
    public void run() {
        for (int i = 1; i < max; i += 2) {
            printer.printOdd(i);
        }

    }
}

class Printer {

    boolean even = false;

    void printEven(int number) {
        //while number is odd, please wait..
        synchronized (this) {

            while (!even) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Printed by: " + Thread.currentThread().getName() + " Thread, and val=" + number);
            even = false;
            notify();
        }
    }

    void printOdd(int number) {
        //while nnumber is even please wait.
        synchronized (this) {
            while (even) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Printed by: " + Thread.currentThread().getName() + " Thread, and val=" + number);
            even = true;
            notify();
        }
    }
}
