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

    


 }