public class Student {
    private int id;
    private int amountOfLabs;
    private String subject;

    public Student(int id, int amountOfLabs, String subject) {
        this.id = id;
        this.amountOfLabs = amountOfLabs;
        this.subject = subject;
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

}
