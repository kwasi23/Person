// PersonTest.java
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person("John", "Doe", "12345", "Mr.", 1995);
    }

    @Test
    public void testFullName() {
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testFormalName() {
        assertEquals("Mr. John Doe", person.formalName());
    }

    @Test
    public void testGetAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        assertEquals(currentYear - 1995, person.getAge());
    }

    @Test
    public void testGetAgeSpecificYear() {
        assertEquals(30, person.getAge(2025));
    }

    @Test
    public void testToCSVDataRecord() {
        assertEquals("12345,John,Doe,Mr.,1995", person.toCSVDataRecord());
    }
}
