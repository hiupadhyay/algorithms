package askedincompanies;

public class QueueUsingFixedSizeArray<T> implements Queue<String> {

    private int capacity;
    private int tail;
    private int head;
    private String[] arr;

    public QueueUsingFixedSizeArray(int capacity) {
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        arr = new String[this.capacity];
    }

    /**
     * @return
     * @throws Exception Insertion will happen at end of queue
     */
    @Override
    public String dequeue() throws Exception {
        if (head == tail)
            throw new Exception("Underflow");
        String output = arr[0];
        if (tail - 1 >= 0) System.arraycopy(arr, 1, arr, 0, tail - 1);
        return output;
    }

    /**
     * @param data
     * @throws Exception Deletion with happen at front of queue,element will be moved to front
     *                   before deletion.
     */
    @Override
    public void enqueue(String data) throws Exception {
        if (capacity == tail) {
            throw new Exception("OverFlow");
        }
        arr[tail] = data;
        tail++;
    }

    @Override
    public void display() {
        int i;
        if (head == tail) {
            System.out.println("\nQueue is Empty\n");
            return;
        }
        for (i = head; i < tail; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        // Create a queue of capacity 4
        Queue<String> q = new QueueUsingFixedSizeArray<String>(4);
        q.enqueue("20");
        q.enqueue("30");
        q.enqueue("40");
        q.enqueue("50");
        q.display();
        q.dequeue();
        q.display();
    }
}

interface Queue<T> {
    T dequeue() throws Exception;

    void enqueue(T data) throws Exception;

    void display();
}
