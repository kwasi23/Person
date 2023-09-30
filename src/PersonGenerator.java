import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    // Changed to store actual Person objects
    private static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            getPersonData(scanner);

            System.out.println("Wanna add more? (yes/no)");
            String more = scanner.nextLine();
            if (!more.equalsIgnoreCase("yes")) break;
        }

        System.out.println("Now, tell me where you want to dump this data?");
        String filename = scanner.nextLine();

        saveData(filename);
    }

    private static void getPersonData(Scanner scanner) {
        System.out.println("Hit me with the ID:");
        String id = scanner.nextLine();

        System.out.println("First name, please:");
        String firstName = scanner.nextLine();

        System.out.println("Last name? Don't be shy:");
        String lastName = scanner.nextLine();

        System.out.println("Any cool title? Like Sir or Dr.?");
        String title = scanner.nextLine();

        System.out.println("Lastly, when were they born?");
        int yob = SafeInput.getRangedInt(scanner, "Year of Birth", 1940, 2000);

        // Creating and adding a Person object to the list
        persons.add(new Person(firstName, lastName, id, title, yob));
    }

    private static void saveData(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (Person dude : persons) {
                writer.write(dude.toCSVDataRecord() + "\n");
            }
            writer.close();
            System.out.println("Boom! Saved to " + filename);
        } catch (IOException e) {
            System.out.println("Oopsie! Something's not right. Error: " + e.getMessage());
        }
    }
}
