import java.util.Random;
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
            Random random = new Random();
            int labs = random.nextInt(3);
            int amountOfLabs = 0;
            switch (labs) {
                case 0:
                    amountOfLabs = 10;
                    break;
                case 1:
                    amountOfLabs = 20;
                    break;
                case 2:
                    amountOfLabs = 100;
                    break;
            }

            int subjectNumber = random.nextInt(3);
            String subject = "";
            switch (subjectNumber) {
                case 0:
                    subject = "Физика";
                    break;
                case 1:
                    subject = "Вышмат";
                    break;
                case 2:
                    subject = "ООП";
                    break;
            }

            if (i >= 100) {
                Student student = new Student(i, -1, subject);
                queue.put(student);
            } else {
                Student student = new Student(i, amountOfLabs, subject);
                System.out.println("Студент " + student.getId() + " встал в очередь");
                queue.put(student);
            }
            Thread.sleep(1000);
        }
    }

    public Producer(BlockingQueue<Student> queue) {
        this.queue = queue;
    }
}
