package assign6;

/**
 * Created by alexandermaxwell on 4/17/17.
 */
public class FileObj {

    /*
     * Private member variables.
     */
    private String fileName; // Holds file name.
    private int wordCount; // Holds word count of File object.

    /**
     * Default Constructor
     */
    public FileObj(){
        fileName ="";
        wordCount = 0;
    }

    /**
     * Overloaded Constructor
     * @param fileName name of file.
     */
    public FileObj(String fileName){
        this.fileName=fileName;
        wordCount = 0;
    }

    /*
     * Public Accessors
     */

    /**
     * @return wordcount the current file's total word count.
     */
    public int getWordCount() {
        return wordCount;
    }
}
