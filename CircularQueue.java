package Queues;
import java.util.Scanner;

class CircularQueue {
    private int capacity;
    private int front;
    private int rear;
    private int[] queue;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue more items.");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        queue[rear] = item;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // You can choose a different sentinel value if needed.
        }
        int item = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return item;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the circular queue: ");
        int capacity = scanner.nextInt();
        CircularQueue cq = new CircularQueue(capacity);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an item to enqueue: ");
                    int item = scanner.nextInt();
                    cq.enqueue(item);
                    break;
                case 2:
                    int dequeuedItem = cq.dequeue();
                    if (dequeuedItem != -1) {
                        System.out.println("Dequeued item: " + dequeuedItem);
                    }
                    break;
                case 3:
                    System.out.println("Exiting the circular queue program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
