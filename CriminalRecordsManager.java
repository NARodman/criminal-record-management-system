import java.io.*;
import java.util.*;

/**
 * CriminalRecordsManager
 * 
 * A command-line application to manage criminal records.
 * Allows users to add, view, edit, and delete records stored in records.txt.
 * 
 * Records are stored in the format:
 * Name | Crime | DateOfCrime | Sentence
 * 
 * Example:
 * John Doe | Theft | 2023-05-15 | 2 years imprisonment
 * 
 * @Nina Lanier
 */

 public class CriminalRecordsManager {
    private static final String FILE_NAME = "records.txt";
    private List<Record> records;

    //Record class represents a single criminal record 
    static class Record {
        String name;
        String crime;
        String dateOfCrime;
        String sentence;
    

    //Constructor to Initialize a Record 
    Record(String name, String crime, String dateOfCrime, String sentence) {
        this.name = name;
        this.crime = crime;
        this.dateOfCrime = dateOfCrime;
        this.sentence = sentence;
    }

    //Serializes the Record to a string suitable for file storage
    public String toString() {
        return name + " | " + crime + " | " + dateOfCrime + " | " + sentence;
    }

    //Deserializes a string to a Record object
    public static Record fromString(String recordStr) {
        String[] parts = recordStr.split(" \\| ");
        if (parts.length == 4) {
            return new Record(parts[0], parts[1], parts[2], parts[3]);
        }
            return null;

        }
    }

    //Constructor that initlizes the records list and loads existing records from the file 
    public CriminalRecordsManager() {
        records = new ArrayList<>();
        loadrecords();
    }

    //Loads records from the records.txt file
    private void loadrecords() {
        File file = new File(FILE_NAME);
        if(!file.exists()) {
            System.out.println("No existing records found. Starting fresh.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                Record record = Record.fromString(line);
                if (record != null) {
                    records.add(record);
                }
            }
            System.out.println("Loaded " + records.size() + "records.");
        } catch (IOException e) {
            System.out.println("Error loading records: " + e.getMessage());
        }
    }

    //Saves records to the records.txt file
    private void saveRecords() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Record record : records) {
                bw.write(record.toString());
                bw.newLine();
            }
            System.out.println("Records Saved Successfully.");
        }catch (IOException e) {
            System.out.println("Error saving records: " + e.getMessage());
        }
    }

    //Adds New Record to Records List 
    private void addRecord(String name, String crime, String dateOfCrime, String sentence) {
        Record newRecord = new Record(name, crime, dateOfCrime, sentence);
        records.add(newRecord);
        System.out.println("Record Added Succesfully.");
    }

    //Displays records in a formatted manner 
    private void viewRecords() {
        if(records.isEmpty()) {
            System.out.println("No records to display.");
            return;
        }

        System.out.println("\n--- Criminal Records ---");
        for (int i = 0; i < records.size(); i++) {
            Record r = records.get(i);
            System.out.println((i + 1) + ".Name: " + r.name + ", .Crime: " + r.crime + ", Date of Crime: " + r.dateOfCrime + ", Sentence: " + r.sentence);
        }
    }
    //Edits an existing record at specified index 
    private void editRecord(int index, String name, String crime, String dateOfCrime, String sentence) {
        if (index < 0 || index >= records.size()) {
            System.out.println("Invalid record number.");
            return;
        }
        Record r  = records.get(index);
        r.name = name;
        r.crime = crime;
        r.dateOfCrime = dateOfCrime;
        r.sentence = sentence;
        System.out.println("Record Update Successfully.");
    }

    //Deletes a record at specified index 
    private void deleteRecord (int index) {
        if (index < 0 || index >= records.size()) {
            System.out.println("Invalid record number.");
            return;
        }
        records.remove(index);
        System.out.println("Record Deleted Successfully.");
    }
    //Displays Main Menu to user 
    private void displayMenu() {
        System.out.println("\n--- Criminal Records Manager ---");
        System.out.println("1. Add Record");
        System.out.println("2. View Records");
        System.out.println("3. Edit Record");
        System.out.println("4. Delete Record");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    //Main method to run the application 
    public static void main(String[] args) {
        Criminal RecordsManager manager = newCriminalRecordsManager();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            manager.displayMenu();
            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please Enter A Valid Number: ");
                continue;
            }

            switch(choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Enter Crime: ");
                    String crime = scanner.nextLine().trim();
                    System.out.print("Enter Date of Crime: ");
                    String dateOfCrime = scanner.nextLine().trim();
                    System.out.print("Enter Sentence: ");
                    String sentence = scanner.nextLine().trim();
                    if (name.isEmpty() || crime.isEmpty() || dateOfCrime.isEmpty() || sentence.isEmpty()) {
                        System.out.println("All fields required. Record not addeded.");
                        break;
                    } 
                    manager.addRecord(name, crime, dateOfCrime, sentence);
                    break;

                case 2:
                    manager.viewRecords();
                    break;

                case 3:
                    manager.viewRecords();
                    if (manager.records.isEmpty()){
                        break;
                    }
                    System.out.print("Enter record number to edit: ");
                    String editInput = scanner.nextLine();
                    int editIndex;
                    try {
                        editIndex = Integer.parseInt(editInput) - 1;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please Enter a Number: ");
                        break;
                    }

            }
            }
        }
    }


 }