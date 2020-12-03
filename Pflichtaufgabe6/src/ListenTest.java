import static org.junit.Assert.*;
import java.util.EmptyStackException;

import org.junit.BeforeClass;
import org.junit.Test;

public class ListenTest {
    private static Stack s1, s2;
    private static Queue q1, q2;


    @BeforeClass
    public static void setUp() throws Exception {
        s1 = new Stack();
        s1.push(1); // to test for with already created stack with elements existing
        s1.push(2);
        s1.push(3);
        s2 = new Stack(); // test starting with an empty stack

        q1 = new Queue(); // to test for with already created queue with elements existing
        q1.enqueue(4);
        q1.enqueue(5);
        q1.enqueue(6);
        q2 = new Queue(); // test starting with an empty queue
    }


/*----------------------------------------Stack test-----------------------------------------------------*/


    @Test
    public void newStackPush() {  // add element to a complete new stack
        s2.push(1);
        s2.push(2);
        assertEquals("** 2 **\n** 1 **\n*******", s2.toString());
    }

    @Test
    public void existingStackPush() {  // add element to an existing stack
      s1.push(10);
      s1.push(15);
        assertEquals("** 15 **\n** 10 **\n** 3 **\n** 2 **\n** 1 **\n*******", s1.toString());
    }


    @Test
    public void newStackPop() { // add the element to the new stack and remove the top most element after that
        Stack s3 = new Stack();
        s3.push(1);
        s3.push(2);
        assertEquals(2, s3.pop());
    }


    @Test(expected = EmptyStackException.class) // removing every element from a stack
    public void stackPopNull() {
        Stack stack = new Stack();
        stack.push(55);
        stack.push(80);
        stack.push(55);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }

    @Test
    public void stackNotEmpty() { // check either stack is empty
        assertEquals(false, s1.isEmpty());
    }

    @Test
    public void stackEmpty() { // adding element to an empty stack and removing it to check either the stack is empty
        Stack s5 = new Stack();
        s5.push(1);
        s5.push(21);
        s5.push(15);
        s5.pop();
        s5.pop();
        s5.pop();
        assertEquals(true, s5.isEmpty());
    }


    @Test(expected = EmptyStackException.class) // check if exception is thrown for an empty stack asking to return its top element
    public void stackTopEmpty() {
        Stack stack = new Stack();
        stack.top();
    }


    @Test
    public void stackTopNotEmpty2() { // asking to return the top element from a stack
        Stack s5 = new Stack();
        s5.push(20);
        s5.push(35);
        assertEquals(35, s5.top());
    }


    @Test
    public void emptyStackSize(){ // checking the size of an empty stack
        Stack stack = new Stack();
        assertEquals(0, stack.size());

    }

    @Test
    public void stackSize(){ // checking the size of a given stack
        Stack stack = new Stack();
        stack.push(5);
        stack.push(9);
        stack.push(55);
        stack.push(57);
        stack.push(100);
        stack.pop();
        stack.pop();
        assertEquals(3, stack.size());

    }



    /*----------------------------------------Queue test-----------------------------------------------------*/


    @Test
    public void existingQueueEnque() {  // add element to an existing queue
        q1.enqueue(10);
        q1.enqueue(15);
        assertEquals("<--- 4 5 6 10 15 <---", q1.toString());
    }


    @Test
    public void newQueueEnqueue() { // adding an element to the completely new queue
        q2.enqueue(1);
        q2.enqueue(2);
        q2.enqueue(5);
        assertEquals("<--- 1 2 5 <---", q2.toString());
    }


    @Test
    public void newQueueDequeue() { // add the element to the new queue and remove the top most element after that
        Queue q3 = new Queue();
        q3.enqueue(16);
        q3.enqueue(15);
        q3.enqueue(21);
        q3.dequeue();
        assertEquals(15, q3.dequeue());
    }


    @Test(expected = EmptyStackException.class) // removing every element from a queue
    public void nullQueueDeque() {
        Queue q4 = new Queue();
        q4.enqueue(55);
        q4.enqueue(95);
        q4.enqueue(15);
        q4.dequeue();
        q4.dequeue();
        q4.dequeue();
        q4.dequeue();
    }


    @Test
    public void queueNotEmpty() { // check either the already existing queue is empty
        assertEquals(false, q1.isEmpty());
    }

    @Test
    public void queueEmpty() { // adding element to an empty queue and removing it to check either the queue is empty
        Queue q6 = new Queue();
        q6.enqueue(15);
        q6.dequeue();
        assertEquals(true, q6.isEmpty());
    }


    @Test(expected = EmptyStackException.class) // check if exception is thrown for an empty queue asking to return its first element
    public void queueFirstEmpty() {
        Queue queue = new Queue();
        queue.first();
    }

    @Test
    public void queueFirst1() { // asking to return the first element from an existing queue
        assertEquals(4, q1.first());
    }


    @Test
    public void queueFirst2() { // asking to return the first element from a newly created queue
        Queue q10 = new Queue();
        q10.enqueue(33);
        q10.enqueue(35);
        q10.enqueue(41);
        assertEquals(33, q10.first());
    }


    @Test
    public void emptyQueueSize(){ // checking the size of an empty queue
        Queue q5 = new Queue();
        assertEquals(0, q5.size());
    }


    @Test
    public void queueSize(){ // checking the size of a given queue
        Queue queue = new Queue();
        queue.enqueue(66);
        queue.enqueue(95);
        queue.enqueue(78);
        queue.enqueue(5);
        queue.enqueue(73);
        queue.enqueue(41);
        queue.dequeue();
        assertEquals(5, queue.size());
    }
}	