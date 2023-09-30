// Person.java
import java.util.Calendar;


public class Person {
    private String firstName;
    private String lastName;
    private final String ID;  // Immutable field
    private String title;
    private int YOB;  // Year of Birth

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - YOB;
    }

    public int getAge(int year) {
        return year - YOB;
    }

    public String toCSVDataRecord() {
        return ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

    // Getters and Setters (I'll skip these for brevity but they're standard)

    @Override
    public String toString() {
        return ID + "  " + formalName() + "  " + YOB;
    }
}
