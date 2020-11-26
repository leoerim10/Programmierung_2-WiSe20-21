/**
 * Interface QueueSchnittstelle <br>
 * Class Queue implements this interface which defines a queue
 * @author Sameer Dhimal, Wojciech Maximilian Frackowski
 */
public interface QueueSchnittstelle {

    /**
     * adds the element at the end of the queue
     * @param x the given value
     */
    public abstract void enqueue(int x);


    /**
     * removes the first element from the queue
     * @return the removed element
     */
    public abstract int dequeue();

    /**
     * returns the first element of the queue
     * @return the first element
     */
    public abstract int first();

    /**
     * checks either the queue is empty or not
     * @return true if it is empty
     */
    public boolean isEmpty();


    /**
     * gives output of the queue as a String on the screen
     * @return the stack as String
     */
    public abstract String toString();
}
