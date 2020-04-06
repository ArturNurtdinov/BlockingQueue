import java.util.Random;

public class Student {
    private int id;
    private int amountOfLabs;
    private String subject;
    private boolean isPoisoned;

    public Student(int id) {
        this.id = id;
        isPoisoned = false;
        Random random = new Random();
        int labs = random.nextInt(3);
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
    }

    public int getAmountOfLabs() {
        return amountOfLabs;
    }

    public String getSubject() {
        return subject;
    }

    public int getId() {
        return id;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public void setPoisoned(boolean poisoned) {
        isPoisoned = poisoned;
    }
}
