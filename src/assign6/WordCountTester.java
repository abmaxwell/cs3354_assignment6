package assign6;

import java.util.ArrayList;

/**
 * Class to test the FileThread and Counter classes.
 * @author Alexander Maxwell
 */
public class WordCountTester {

    public static void main(String[] args) {

        /**
         * Public Member Variables
         */
        Counter fileListWordCount = new Counter();
        FileThread file;

        // Get a file name from the command line arguments
        for (String fileName : args) {
            // Create new file thread object and pass it the file name.
            file = new FileThread(fileName);

            // Run the file thread (start in constructor).
            file.run();

            // Add new file's total word count to the ArrayList
            // total word counter.
            fileListWordCount.add(file.getWordCount());

            // Print out file's name and total word count.
            System.out.println(file.getName() + ": " + file.getWordCount());
        }

        // Display the total word count for all files.
        System.out.println("Total Word Count: " + fileListWordCount.getTotalWordCount());
    }
}

