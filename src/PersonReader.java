import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PersonReader {

    // List to store Person objects read from the file
    private static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        String filePath = pickAFile();

        if (filePath != null && !filePath.isEmpty()) {
            loadData(filePath);
            displayData();
        } else {
            System.out.println("Alright, maybe next time!");
        }
    }

    private static String pickAFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Where's that Person file?");
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            System.out.println("You didn't pick anything :(");
            return "";
        }
    }

    private static void loadData(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 5) {
                    Person p = new Person(parts[1].trim(), parts[2].trim(), parts[0].trim(), parts[3].trim(), Integer.parseInt(parts[4].trim()));
                    persons.add(p);
                } else {
                    System.out.println("This line seems wonky: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Oh no! File trouble. Here's what went down: " + e.getMessage());
        }
    }

    private static void displayData() {
        System.out.println("\nID#      Firstname     Lastname      Title     YOB");
        System.out.println("========================================================");

        for (Person person : persons) {
            System.out.println(person); // Using Person's toString method
        }
    }
}
