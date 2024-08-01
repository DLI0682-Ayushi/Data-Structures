package Queues;
import java.util.PriorityQueue;

class PrintJob implements Comparable<PrintJob> {
    private String jobName;
    private int priority;

    public PrintJob(String jobName, int priority) {
        this.jobName = jobName;
        this.priority = priority;
    }

    @Override
    public int compareTo(PrintJob other) {
        // Higher priority jobs come first
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "PrintJob{" +
                "jobName='" + jobName + '\'' +
                ", priority=" + priority +
                '}';
    }
}
public class PrinterQueue {
    public static void main(String[] args) {
        PriorityQueue<PrintJob> printerQueue = new PriorityQueue<>();

        // Enqueue some print jobs (name, priority)
        printerQueue.offer(new PrintJob("Report", 2));
        printerQueue.offer(new PrintJob("Invoice", 1));
        printerQueue.offer(new PrintJob("Presentation", 3));

        // Dequeue and print the jobs
        while (!printerQueue.isEmpty()) {
            PrintJob job = printerQueue.poll();
            System.out.println("Printing: " + job);
        }
    }
}
