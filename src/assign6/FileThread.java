package assign6;

import java.lang.Thread;
import java.util.*;
import java.io.*;

/**
 * Class defines a fileThread object, which takes a file name as
 * input, reads in the file, and counts the total number of words.
 * @author Alexander Maxwell
 */
public class FileThread extends Thread {

    /**
     * Private Member Variables
     */
    private int wordCount; // Holds word count of the FileThread object.

    /**
     * Default Constructor
     */
    public FileThread(){
        super("Unknown");
        wordCount = 0;
        start();
    }

    /**
     * Overloaded Constructor
     * @param fileName name of file to be read
     */
    public FileThread(String fileName){
        super(fileName); // Passes filename to super class Thread.
        wordCount = 0;  // Set's word count to zero. Words NOT counted.
        start(); // Start the thread.
    }

    /*
     * Class Methods
     */

    /**
     * Returns the FileThread object's total word count.
     * @return wordcount the current file's total word count.
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * Sets the FileThread object's word count.
     * @param wordCount the word count passed in from other FileThread
     *                  class methods.
     */
    private void setWordCount(int wordCount){this.wordCount = wordCount;}

    /**
     * Overridden run() method from the Thread class.
     */
    @Override
    public void run(){
        try {
            // Read in data from the file using readFile() and
            // pass the ArrayList<String> to wordCounter.
            wordCounter(readFile(super.getName()));

            // Pause to allow other threads to complete.
            Thread.yield();

        }catch (FileNotFoundException e){e.printStackTrace();}
    }

    /**
     * Counts the number of words in a given string.
     * @param fileWordList an ArrayList of words found in the file.
     */
    private void wordCounter(ArrayList<String> fileWordList) {

        /**
         * Member Variables
         */
        // DEBUG int count = 1;
        ArrayList<String> checkedWordList = new ArrayList<>();

        for (String word : fileWordList) {

            // Remove all white space characters from the word.
            word = word.replaceAll("\\s+", "");

            // Remove all punctuations from the word.
            word = word.replaceAll("[\\p{Punct}]", " ");

            // Remove all spaces longer than " " from the word.
            //word = word.trim().replaceAll(" +", " ");

            // Create a new list of valid words as long as the
            // word is NOT empty.
            if(!word.isEmpty()) {
                // DEBUG: Each Word Shown
                //System.out.println(count++ + "Word Before add: " + word);
                checkedWordList.add(word);
            }
        }
        // Set the file's word count based on the size
        // of the checkedWordList ArrayList.
        setWordCount(checkedWordList.size());
    }

    /**
     * Reads in data from a file and counts total words in a file using
     * the helper method countWords().
     * @param fileName name of the file to read data in from.
     * @throws FileNotFoundException
     * @return fileWordList an ArrayList() of words found in the file.
     */
    private ArrayList<String> readFile(String fileName) throws FileNotFoundException{

        /**
         * Member variables.
         */
        ArrayList<String> fileLineList = new ArrayList<>();
        Scanner scanner;
        File file;

        // Try to open the file and read in input.
        try {
            // Create a new file object.
            file = new File(fileName);

            // Create a new scanner object.
            scanner = new Scanner(file).useDelimiter("\\s");

            // While the file's line has another word add
            // that word to the list of words in the file.
            while (scanner.hasNext()) {
                fileLineList.add(scanner.next());
            }
            scanner.close(); // Close scanner.
        }catch(FileNotFoundException e){ e.printStackTrace();}

        return fileLineList;
    }
} // End fileThread class.


