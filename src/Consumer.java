import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Student> queue;

    @Override
    public void run() {
        try {
            while (true) {
                Student student = queue.take();
                if (student.isPoisoned()) {
                    break;
                }
                handle(student);
            }
            System.out.println("Thread ended");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void handle(Student student) throws InterruptedException {
        System.out.println("Студент " + student.getId() + " зашёл в кабинет сдавать " + student.getAmountOfLabs() + " работ по " + student.getSubject());
        for (int i = 1; i <= student.getAmountOfLabs() / 5; i++) {
            System.out.println("Студент " + student.getId() + " сдал " + i * 5 + " работ по " + student.getSubject() + " из " + student.getAmountOfLabs());
            Thread.sleep(4000);
        }
    }

    public Consumer(BlockingQueue<Student> queue) {
        this.queue = queue;
    }


}
