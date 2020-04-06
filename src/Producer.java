import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Student> queue;

    @Override
    public void run() {
        try {
            process();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void process() throws InterruptedException {
        for (int i = 0; i < 103; i++) {
            Student student = new Student(i);
            if (i >= 100) {
                student.setPoisoned(true);
            } else {
                System.out.println("Студент " + student.getId() + " встал в очередь");
            }
            queue.put(student);
            Thread.sleep(1000);
        }
    }

    public Producer(BlockingQueue<Student> queue) {
        this.queue = queue;
    }
}
