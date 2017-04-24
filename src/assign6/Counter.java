package assign6;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Class defines a shared class Counter, which
 * total's any number of values added to it.
 * @author Alexander Maxwell
 */
public class Counter {
    /**
     * Private Member Variables
     */
    private int totalWordCount;
    private ReentrantLock counterLock = new ReentrantLock();

    /**
     * Default Constructor
     */
    public Counter(){
        totalWordCount = 0;
    }

    /*
     * Class Methods
     */

    /**
     * @return returns the total word count of the Counter object.
     */
    public int getTotalWordCount() {
        return totalWordCount;
    }

    /**
     * @param count a value to add to the total count of the Counter object.
     */
    public void add(int count){
        counterLock.lock();
        try {
            totalWordCount +=count;
        } finally {
            counterLock.unlock();
        }
    }
} // End Counter class.
