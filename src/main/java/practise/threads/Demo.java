package practise.threads;

public class Demo {
    public static void main(String[] args) {
        RunnableTask runnableTask = new RunnableTask(1, 10);
        Thread evenThread = new Thread(() -> runnableTask.printEven(), "Even Thread");
        Thread oddThread = new Thread(() -> runnableTask.printOdd(), "Odd Thread");
        evenThread.start();
        oddThread.start();
    }
}

class RunnableTask {

    private boolean isOdd;
    private int start;
    private int end;

    RunnableTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public synchronized void printEven() {
        while (start < end) {
            while (isOdd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " Prints: " + start);
            start++;
            isOdd = true;
            notify();
        }
    }

    public synchronized void printOdd() {
        while (start < end) {
            while (!isOdd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " Prints: " + start);
            start++;
            isOdd = false;
            notify();
        }
    }
}


