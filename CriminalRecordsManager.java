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
    }
 }