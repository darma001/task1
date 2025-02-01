import java.io.*;
import java.util.*;

public class FileHandlerUtility {

    // Method to read the content of a file
    public static void readFile(String fileName) {
        // Try to open and read the file
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found: " + fileName);
                return;
            }

            // Create a scanner object to read the file
            Scanner scanner = new Scanner(file);
            System.out.println("Contents of " + fileName + ":");
            
            // Print each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close(); // Close the scanner after reading the file

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Method to write content to a file (this will overwrite the existing content)
    public static void writeFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName); // Will overwrite the file
            writer.write(content); // Write content to the file
            writer.close(); // Close the writer
            System.out.println("Content written to " + fileName + " successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to append content to an existing file
    public static void appendToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true); // Set 'true' for append mode
            writer.write(content); // Append content to the file
            writer.close(); // Close the writer
            System.out.println("Content appended to " + fileName + " successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file.");
            e.printStackTrace();
        }
    }

    // Method to modify specific content in a file
    public static void modifyFileContent(String fileName, String oldText, String newText) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found: " + fileName);
                return;
            }

            // Read the file and replace occurrences of oldText with newText
            StringBuilder fileContent = new StringBuilder();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Replace the old text with new text in each line
                line = line.replace(oldText, newText);
                fileContent.append(line).append("\n");
            }
            scanner.close();

            // Write the modified content back to the file
            FileWriter writer = new FileWriter(fileName);
            writer.write(fileContent.toString()); // Overwrite the file with modified content
            writer.close();
            System.out.println("File content modified successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file.");
            e.printStackTrace();
        }
    }

    // Main method to test the file operations
    public static void main(String[] args) {
        // Define the file name
        String fileName = "testFile.txt";

        // Write content to the file (this will overwrite existing content)
        String contentToWrite = "Hello, this is the initial content of the file.\nThis is the second line.";
        writeFile(fileName, contentToWrite);

        // Read the file and print its content
        readFile(fileName);

        // Append more content to the file
        String contentToAppend = "\nThis is some additional content appended to the file.";
        appendToFile(fileName, contentToAppend);

        // Read the file again to confirm appended content
        readFile(fileName);

        // Modify specific content in the file (replace "Hello" with "Hi")
        modifyFileContent(fileName, "Hello", "Hi");

        // Read the modified file to check the updated content
        readFile(fileName);
    }
}
