/**
 * Interface StackSchnittstelle <br>
 * Class Stack implements this interface which defines a stack
 * @author Sameer Dhimal, Wojciech Maximilian Frackowski
 */
public interface StackSchnittstelle{

    /**
     * places a element on the top of the stack
     * @param data the given value
     */
    public abstract void push(int data);

    /**
     * removes the topmost element from the stack
     * @return the removed element
     */
    public abstract int pop();

    /**
     * returns the topmost element of the stack
     * @return top element
     */
    public abstract int top();



    /**
     * checks either the stack is empty or not
     * @return true if it is empty
     */
    public boolean isEmpty();


    /**
     * gives output of the stack as a String on the screen
     * @return the stack as String
     */
    public abstract String toString();
}
